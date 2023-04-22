package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.parking.core.client.google.DataConverter.toDirectionsGeocodedWaypoint
import com.github.hemoptysisheart.parking.core.client.google.data.DirectionsStatus
import com.github.hemoptysisheart.parking.core.client.google.data.ResultMeta
import com.github.hemoptysisheart.parking.core.client.google.data.TravelMode
import com.github.hemoptysisheart.util.d
import com.github.hemoptysisheart.util.i
import com.github.hemoptysisheart.util.logger
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
    private val api: PlacesApi

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
            .create(PlacesApi::class.java)

        logger.i("#init complete : $this")
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
            places = response.results!!.map { DataConverter.toPlace(it) },
            nextToken = response.nextPageToken
        )

        logger.d { "#nearBy return : $page" }
        return page
    }

    override suspend fun directions(params: DirectionsParams, requestAt: Instant): DirectionsSearchResult {
        logger.d { "#directions args : params=$params, requestAt=$requestAt" }

        val response = api.direction(
            key,
            params.origin.toString(),
            params.destination.toString(),
            params.alternatives,
            params.arrivalTime?.epochSecond,
            params.avoid?.joinToString("|"),
            params.departureTime?.epochSecond,
            params.locale?.language ?: locale.language,
            params.transportationMode?.code,
            params.region,
            params.trafficModel?.code,
            params.transitRoutingPreference?.code,
            params.unit?.code,
        )
        val responseAt = timeProvider.instant()
        logger.i("#directions : response=$response")

        val result = DirectionsSearchResult(
            meta = ResultMeta(params, requestAt, responseAt),
            status = DirectionsStatus.valueOf(response.status ?: throw IllegalArgumentException("status is null.")),
            availableTravelModes = response.availableTravelModes?.map { TravelMode.valueOf(it) },
            routes = response.routes!!.map { DataConverter.toDirectionsRoute(it) },
            geocodedWaypoints = response.geocodedWaypoints?.map { toDirectionsGeocodedWaypoint(it) },
            errorMessage = response.errorMessage
        )

        logger.d { "#directions return : $result" }
        return result
    }

    override fun toString() =
        "${MapsClientImpl::class.simpleName}(key=[ PROTECTED ], locale=$locale, useDefaultLocale=$useDefaultLocale, timeProvider=$timeProvider, client=$client, api=$api)"
}
