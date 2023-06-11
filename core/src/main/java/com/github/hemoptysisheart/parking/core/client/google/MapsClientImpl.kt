package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.data.*
import com.github.hemoptysisheart.util.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Instant

class MapsClientImpl(config: PlacesClientConfig) : MapsClient {
    private val key = config.key
    private val locale = config.locale
    private val useDefaultLocale = config.useDefaultLocale
    private val timeProvider = config.timeProvider
    private val client: OkHttpClient
    private val api: ApiSpec

    init {
        client = OkHttpClient.Builder().let {
            if (config.debug) {
                it.addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            }
            it.build()
        }

        api = Retrofit.Builder()
            .client(client)
            .baseUrl(config.endpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiSpec::class.java)

        logger.i("#init complete : $this")
    }

    override suspend fun place(params: PlaceParams): PlaceResult {
        logger.v("#place args : params=$params")

        val response = api.place(
            key = key,
            placeId = params.placeId,
            fields = params.fields?.let { it.ifEmpty { null } }?.joinToString(",", "", "") { it.code },
            language = params.language?.language,
            region = params.region,
            reviewsNoTranslations = params.reviewsNoTranslations,
            reviewsSort = params.reviewsSort?.code,
            sessionToken = params.sessionToken
        )

        val result = PlaceResult(
            htmlAttributes = response.htmlAttributions ?: throw IllegalArgumentException("htmlAttributions is null."),
            place = response.result?.toData() ?: throw IllegalArgumentException("result is null."),
            status = PlacesDetailsStatus[response.status ?: throw IllegalArgumentException("status is null.")],
            infoMessages = response.infoMessages
        )

        logger.v("#place return : $result")
        return result
    }

    override suspend fun autocomplete(params: AutocompleteParams, requestAt: Instant): AutocompleteResult {
        logger.v("#autocomplete args : params=$params, requestAt=$requestAt")
        val response = api.autocomplete(
            key = key,
            input = params.input,
            radius = params.radius,
            components = params.components?.joinToString("|") { "country:${it.isO3Country}" },
            language = params.language?.language,
            location = params.location?.toString(),
            locationBias = params.locationBias?.toString(),
            locationRestriction = params.locationRestriction?.toString(),
            offset = params.offset,
            origin = params.origin?.toString(),
            region = params.region, sessionToken = params.sessionToken,
            strictBounds = params.strictBounds,
            types = params.types?.joinToString("|", "", "") { it.code }
        )
        val responseAt = Instant.now()
        val result = AutocompleteResult(
            meta = ResultMeta(params, requestAt, responseAt),
            predictions = response.predictions?.filter {
                if (null == it.placeId) {
                    logger.w("#autocomplete prediction has no placeId : prediction=$it")
                    false
                } else {
                    true
                }
            }?.map { it.toData() } ?: throw IllegalArgumentException("predictions is null."),
            status = PlacesAutocompleteStatus[response.status ?: throw IllegalArgumentException("status is null.")],
            errorMessage = response.errorMessage,
            infoMessages = response.infoMessages
        )
        logger.v("#autocomplete return : $result")
        return result
    }

    override suspend fun nearBy(params: NearbySearchParams, requestAt: Instant): NearbySearchResult {
        logger.d { "#nearBy args : params=$params, requestAt=$requestAt" }

        val response = api.nearBy(
            keyword = params.keyword,
            location = "${params.latitude},${params.longitude}",
            language = params.locale?.language
                ?: if (useDefaultLocale) this.locale.language else null,
            minPrice = params.minPrice,
            maxPrice = params.maxPrice,
            open = params.open,
            radius = params.radius,
            rankBy = params.rankBy?.code,
            type = params.type?.code,
            key = key
        )
        val responseAt = timeProvider.instant()
        logger.d { "#nearBy : response=$response" }

        val page = NearbySearchResult(
            meta = ResultMeta(
                params = params,
                requestAt = requestAt,
                responseAt = responseAt
            ),
            places = response.results!!.map { it.toData() },
            nextToken = response.nextPageToken
        )

        logger.d { "#nearBy return : $page" }
        return page
    }

    override suspend fun directions(params: DirectionsParams, requestAt: Instant): DirectionsSearchResult {
        logger.d { "#directions args : params=$params, requestAt=$requestAt" }

        val response = api.direction(
            key = key,
            origin = params.origin.toString(),
            destination = params.destination.toString(),
            alternatives = params.alternatives,
            arrivalTime = params.arrivalTime?.epochSecond,
            avoid = params.avoid?.joinToString("|"),
            departureTime = params.departureTime?.epochSecond,
            language = params.locale?.language ?: locale.language,
            mode = params.transportationMode?.code,
            region = params.region,
            trafficModel = params.trafficModel?.code,
            transitRoutingPreference = params.transitRoutingPreference?.code,
            units = params.unit?.code,
        )
        val responseAt = timeProvider.instant()
        logger.i("#directions : response=$response")

        val result = DirectionsSearchResult(
            meta = ResultMeta(params, requestAt, responseAt),
            status = DirectionsStatus.valueOf(response.status ?: throw IllegalArgumentException("status is null.")),
            availableTravelModes = response.availableTravelModes?.map { TravelMode.valueOf(it) },
            routes = response.routes!!.map { it.toData() },
            geocodedWaypoints = response.geocodedWaypoints?.map { it.toData() },
            errorMessage = response.errorMessage
        )

        logger.d { "#directions return : $result" }
        return result
    }

    override fun toString() =
        "${MapsClientImpl::class.simpleName}(key=[ PROTECTED ], locale=$locale, useDefaultLocale=$useDefaultLocale, timeProvider=$timeProvider, client=$client, api=$api)"
}
