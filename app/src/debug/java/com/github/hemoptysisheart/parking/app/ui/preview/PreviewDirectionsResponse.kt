package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.core.client.google.response.*

@Suppress("NonAsciiCharacters")
object PreviewDirectionsResponse {
    val RESPONSE_DRIVING_新宿駅_ECOLO_PARK_KABUKICHO_29 = DirectionsResponse(
        routes = listOf(
            DirectionsRouteResp(
                bounds = BoundsResp(
                    LatLngLiteralResp(35.6982605, 139.7074366),
                    LatLngLiteralResp(35.6896586, 139.7028543)
                ),
                copyrights = "Map data ©2023",
                legs = listOf(
                    DirectionsLegResp(
                        endAddress = "2-chōme-32-13 Kabukichō, Shinjuku City, Tokyo 160-0021 일본",
                        endLocation = LatLngLiteralResp(35.6978576, 139.7032374),
                        startAddress = "3-chōme-35-2 Shinjuku, Shinjuku City, Tokyo 160-0022 일본",
                        startLocation = LatLngLiteralResp(35.6896586, 139.7028543),
                        steps = listOf(
                            DirectionsStepResp(
                                duration = TextValueObjectResp("1분", 30.0),
                                endLocation = LatLngLiteralResp(35.68983950000001, 139.7041772),
                                html = "<b>甲州街道</b>/<wbr/><b>国道20号</b>에서 <b>동쪽</b>으로 출발",
                                polyline = DirectionsPolylineResp("ksyxEyutsYGq@AQAQCe@C[Cc@Eu@EW"),
                                startLocation = LatLngLiteralResp(35.6896586, 139.7028543),
                                travelMode = "DRIVING",
                                distance = TextValueObjectResp("0.1 km", 121.0)
                            ),
                            DirectionsStepResp(
                                duration = TextValueObjectResp("4분", 260.0),
                                endLocation = LatLngLiteralResp(35.6979063, 139.7074366),
                                html = "<b>新宿四丁目（交差点）</b>에서 <b>좌회전</b>하여 <b>明治通り</b>/<wbr/><b>都道305号</b>에 진입",
                                polyline = DirectionsPolylineResp("otyxEc~tsY]Qs@c@QI[QSMYQ]WEC_@SQKAAIEo@YUKIGA?CAIEECKEMGGCeB{@IGKE_@SAA_@QOIYOUKECKEKGUKQIKAC?]MQGOEiBUc@GSCa@EaAQy@M}AUYE{@IWEMAMAy@K_@EQCkBUa@G"),
                                startLocation = LatLngLiteralResp(35.68983950000001, 139.7041772),
                                travelMode = "DRIVING",
                                distance = TextValueObjectResp("1.0 km", 954.0),
                                maneuver = "turn-left"
                            ),
                            DirectionsStepResp(
                                duration = TextValueObjectResp("2분", 95.0),
                                endLocation = LatLngLiteralResp(35.6981806, 139.7032972),
                                html = "<b>新宿七丁目（交差点）</b>에서 <b>좌회전</b>하여 <b>職安通り</b>/<wbr/><b>都道302号</b>에 진입 (<b>Kitashinjuku</b> 표지)",
                                polyline = DirectionsPolylineResp("}f{xEorusYIrAAP?HGz@AXEj@?FKvAC`@IjAAPAHE^?BAL?HAN?LAL?L?T?J?L@X?F@L?H@FHvB"),
                                startLocation = LatLngLiteralResp(35.6979063, 139.7074366),
                                travelMode = "DRIVING",
                                distance = TextValueObjectResp("0.4 km", 377.0),
                                maneuver = "turn-left",
                            ),
                            DirectionsStepResp(
                                duration = TextValueObjectResp("1분", 16.0),
                                endLocation = LatLngLiteralResp(35.6978576, 139.7032374),
                                html = "<b>좌회전</b><div style=\"font-size:0.9em\">목적지는 길의 오른쪽에 있습니다.</div>",
                                polyline = DirectionsPolylineResp("sh{xEsxtsYH@L@J@TDD?"),
                                startLocation = LatLngLiteralResp(35.6981806, 139.7032972),
                                travelMode = "DRIVING",
                                distance = TextValueObjectResp("36 m", 36.0),
                                maneuver = "turn-left",
                            )
                        ),
                        viaWaypoint = listOf(),
                        distance = TextValueObjectResp("1.5 km", 1488.0),
                        duration = TextValueObjectResp("7분", 401.0),
                    )
                ),
                overviewPolyline = DirectionsPolylineResp("ksyxEyutsYO{BG_AKmA_CqAqA{@oCuAeDaBsCwA_Ac@OAo@UqDg@{F{@uFo@mC]KdBOjCc@lGErBB|@@PHvBH@XBZD"),
                summary = "明治通り/都道305号을(를) 지나 職安通り/都道302号",
                warnings = listOf(),
                waypointOrder = listOf(),
            )
        ),
        status = "OK",
        geocodedWaypoints = listOf(
            DirectionsGeocodedWaypointResp(
                geocoderStatus = "OK",
                placeId = "ChIJ8cP67dqMGGARH5RKvNbBjYc",
                types = listOf("street_address")
            ),
            DirectionsGeocodedWaypointResp(
                geocoderStatus = "OK",
                placeId = "ChIJX13CrEaNGGARP7TB4u26SMk",
                types = listOf("establishment", "parking", "point_of_interest")
            )
        )
    )

    val RESPONSE_WALKING_ECOLO_PARK_KABUKICHO_29_패밀리마트_카부키쵸키타점 = DirectionsResponse(
        routes = listOf(
            DirectionsRouteResp(
                bounds = BoundsResp(
                    northEast = LatLngLiteralResp(35.6980957, 139.7032697),
                    southWest = LatLngLiteralResp(35.697859, 139.7026791)
                ),
                copyrights = "Map data ©2023",
                legs = listOf(
                    DirectionsLegResp(
                        endAddress = "2-chōme-32-7 Kabukichō, Shinjuku City, Tokyo 160-0021 일본",
                        endLocation = LatLngLiteralResp(35.6980353, 139.7026791),
                        startAddress = "2-chōme-32-13 Kabukichō, Shinjuku City, Tokyo 160-0021 일본",
                        startLocation = LatLngLiteralResp(35.697859, 139.7032213),
                        steps = listOf(
                            DirectionsStepResp(
                                duration = TextValueObjectResp("1분", 26.0),
                                endLocation = LatLngLiteralResp(35.6980957, 139.7032697),
                                html = "<b>職安通り</b>/<wbr/><b>都道302号</b> 방면 <b>북쪽</b>으로 걷기",
                                polyline = DirectionsPolylineResp("sf{xEcxtsYEAUCKAGA"),
                                startLocation = LatLngLiteralResp(35.697859, 139.7032213),
                                travelMode = "WALKING",
                                distance = TextValueObjectResp("36 m", 36.0)
                            ),
                            DirectionsStepResp(
                                duration = TextValueObjectResp("1분", 44.0),
                                endLocation = LatLngLiteralResp(35.698043, 139.7026796),
                                html = "<b>좌회전</b>하여 <b>職安通り</b>/<wbr/><b>都道302号</b>에 진입",
                                polyline = DirectionsPolylineResp("ch{xEmxtsYJtB"),
                                startLocation = LatLngLiteralResp(35.6980957, 139.7032697),
                                travelMode = "WALKING",
                                distance = TextValueObjectResp("60 m", 60.0),
                                maneuver = "turn-left"
                            ),
                            DirectionsStepResp(
                                duration = TextValueObjectResp("1분", 7.0),
                                endLocation = LatLngLiteralResp(35.6980353, 139.7026791),
                                html = "<b>좌회전</b>하여 <b>3番通り</b>에 진입<div style=\"font-size:0.9em\">목적지는 길의 왼쪽에 있습니다.</div>",
                                polyline = DirectionsPolylineResp("wg{xEwttsY"),
                                startLocation = LatLngLiteralResp(35.698043, 139.7026796),
                                travelMode = "WALKING",
                                distance = TextValueObjectResp("9 m", 9.0),
                                maneuver = "turn-left"
                            )
                        ),
                        viaWaypoint = listOf(),
                        distance = TextValueObjectResp("0.1 km", 105.0),
                        duration = TextValueObjectResp("1분", 77.0)
                    )
                ),
                overviewPolyline = DirectionsPolylineResp(points = "sf{xEcxtsYo@IJtB"),
                summary = "職安通り/都道302号",
                warnings = listOf("도보 경로는 베타 서비스입니다. 주의 – 이 경로에는 인도 또는 보행 경로가 누락되었을 수도 있습니다."),
                waypointOrder = listOf()
            )
        ),
        status = "OK",
        geocodedWaypoints = listOf(
            DirectionsGeocodedWaypointResp(
                geocoderStatus = "OK",
                placeId = "ChIJX13CrEaNGGARP7TB4u26SMk",
                types = listOf("establishment", "parking", "point_of_interest")
            ),
            DirectionsGeocodedWaypointResp(
                geocoderStatus = "OK",
                placeId = "ChIJN2hXkieNGGARWPSysdlRajE",
                types = listOf("convenience_store", "establishment", "food", "point_of_interest", "store")
            )
        )
    )
}
