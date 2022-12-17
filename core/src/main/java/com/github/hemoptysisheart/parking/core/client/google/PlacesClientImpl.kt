package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.domain.d
import com.github.hemoptysisheart.domain.i
import com.github.hemoptysisheart.domain.logger
import com.github.hemoptysisheart.parking.core.client.google.dto.NearbyParams
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlacesClientImpl(config: PlacesClientConfig) : PlacesClient {
    private val key = config.key
    private val locale = config.locale
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

    override suspend fun nearBy(params: NearbyParams) {
        logger.d { "#nearBy args : params=$params" }


        val response = api.nearBy(
            keyword = params.keyword,
            location = "${params.latitude},${params.longitude}",
            language = params.language?.language,
            minPrice = params.minPrice,
            maxPrice = params.maxPrice,
            open = params.open,
            radius = params.radius,
            rankBy = params.rankBy?.code,
            type = params.type?.code,
            key = key
        )
        logger.d { "#nearBy : response=$response" }
    }

    override fun toString() = "${PlacesClientImpl::class.simpleName}(key=[ PROTECTED ], client=$client, api=$api)"
}