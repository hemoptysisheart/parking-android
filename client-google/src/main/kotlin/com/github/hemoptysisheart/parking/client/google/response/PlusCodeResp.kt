package com.github.hemoptysisheart.parking.client.google.response

import com.google.gson.annotations.SerializedName

/**
 * [PlusCode](https://developers.google.com/maps/documentation/places/web-service/search-nearby#PlusCode)
 */
data class PlusCodeResp(
        @SerializedName("global_code")
        var globalCode: String? = null,
        @SerializedName("compound_code")
        var compoundCode: String? = null
)