package com.github.hemoptysisheart.parking.core.client.google

import com.github.hemoptysisheart.domain.d
import com.github.hemoptysisheart.domain.logger

class PlacesClientImpl(config: PlacesClientConfig) : PlacesClient {
    override fun nearBy(params: NearbyParams) {
        logger.d { "#nearBy args : params=$params" }
    }
}
