package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.data.*
import com.github.hemoptysisheart.util.logger
import com.github.hemoptysisheart.util.v
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MapsClientImpl(config: PlacesClientConfig) : MapsClient {
    companion object {
        private const val TAG = "MapsClientImpl"
    }

    private val key = config.key
    private val locale = config.locale
    private val useDefaultLocale = config.useDefaultLocale

    private val api: ApiSpec

    init {
        api = Retrofit.Builder()
            .client(OkHttpClient.Builder().run {
                if (config.debug) {
                    addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                }
                build()
            })
            .baseUrl(config.endpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiSpec::class.java)
    }

    override suspend fun place(params: PlaceParams): Place? {
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
        logger.v("#place : response=$response")

        val place = response.result?.toData()

        logger.v("#place return : $place")
        return place
    }

    override suspend fun autocomplete(params: AutocompleteParams): List<PlaceAutocompletePrediction> {
        logger.v("#autocomplete args : params=$params")

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
        logger.v("#autocomplete : response=$response")

        val predictions = response.predictions?.filter { null != it.placeId }?.map { it.toData() }
            ?: throw IllegalArgumentException("predictions is null.")

        logger.v("#autocomplete return : $predictions")
        return predictions
    }

    override suspend fun nearBy(params: NearbySearchParams): List<Place> {
        logger.v { "#nearBy args : params=$params" }

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
        logger.v { "#nearBy : response=$response" }

        val places = response.results!!.map { it.toData() }

        logger.v { "#nearBy return : $places" }
        return places
    }

    override suspend fun directions(params: DirectionsParams): List<DirectionsRoute> {
        logger.v { "#directions args : params=$params" }

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
        logger.v { "#directions : response=$response" }

        val routes = response.routes!!.map { it.toData() }

        logger.v { "#directions return : $routes" }
        return routes
    }

    override fun toString() = "$TAG(key=[ PROTECTED ], locale=$locale, useDefaultLocale=$useDefaultLocale, api=$api)"
}
