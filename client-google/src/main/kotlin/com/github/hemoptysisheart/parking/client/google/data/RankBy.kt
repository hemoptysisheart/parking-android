package com.github.hemoptysisheart.parking.client.google.data

enum class RankBy(
    val code: String
) {
    /**
     * 중요도. 사용할 경우, [NearbySearchParams.radius]를 설정해야 한다.
     */
    PROMINENCE("prominence"),

    /**
     * 거리. 검색 위치에서 가까운 순서로 검색한다. [NearbySearchParams.keyword] 혹은 [NearbySearchParams.type]을 설정해야 하고, [NearbySearchParams.radius]는 사용할 수 없다.
     */
    DISTANCE("distance")
}
