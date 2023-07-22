@file:Suppress("NonAsciiCharacters")

package com.github.hemoptysisheart.parking.app.ui.preview

import com.github.hemoptysisheart.parking.domain.*
import java.time.Duration
import java.util.*

val ROUTE_新宿駅_패밀리마트_카부키쵸키타점 = Route(
    UUID.randomUUID(),
    LOCATION_신주쿠역,
    LOCATION_ECOLO_PARK_KABUKICHO_29,
    LOCATION_패밀리마트_카부키쵸키타점
).apply {
    driving = PartialRoute(
        summary = "DRIVE_신주쿠역_TO_ECOLO_PARK_KABUKICHO_29",
        bounds = GeoBounds(
            northEast = GeoLocation(35.6982605, 139.7074366),
            southWest = GeoLocation(35.6896586, 139.7028543)
        ),
        overview = OVERVIEW_DRIVE_신주쿠역_TO_ECOLO_PARK_KABUKICHO_29,
        legList = listOf(
            NaviLeg(
                start = GeoLocation(35.689123, 139.7004754),
                end = GeoLocation(35.6978576, 139.7032374),
                distance = 1711.0,
                stepList = listOf(
                    NaviStep(
                        start = GeoLocation(35.689123, 139.7004754),
                        end = GeoLocation(35.68983950000001, 139.7041772),
                        distance = 344.0,
                        duration = Duration.parse("PT1M6S"),
                        guideText = "<b>甲州街道</b>/<wbr/><b>国道20号</b>에서 <b>동쪽</b>으로 출발",
                        polyline = listOf(
                            GeoLocation(35.68912, 139.70048),
                            GeoLocation(35.68914, 139.70057),
                            GeoLocation(35.689240000000005, 139.70110000000003),
                            GeoLocation(35.689260000000004, 139.70121),
                            GeoLocation(35.6893, 139.70141),
                            GeoLocation(35.689310000000006, 139.70143000000002),
                            GeoLocation(35.689310000000006, 139.70145000000002),
                            GeoLocation(35.68945, 139.702),
                            GeoLocation(35.68947, 139.70206000000002),
                            GeoLocation(35.68948, 139.70211),
                            GeoLocation(35.689510000000006, 139.70223000000001),
                            GeoLocation(35.689550000000004, 139.70237),
                            GeoLocation(35.68956, 139.70241000000001),
                            GeoLocation(35.68957, 139.70244000000002),
                            GeoLocation(35.68959, 139.70251000000002),
                            GeoLocation(35.68961, 139.70263),
                            GeoLocation(35.689620000000005, 139.70265),
                            GeoLocation(35.68963, 139.70270000000002),
                            GeoLocation(35.68963, 139.70273),
                            GeoLocation(35.68966, 139.70285),
                            GeoLocation(35.6897, 139.7031),
                            GeoLocation(35.689710000000005, 139.70319),
                            GeoLocation(35.68972, 139.70328),
                            GeoLocation(35.68974, 139.70347),
                            GeoLocation(35.68976, 139.70361),
                            GeoLocation(35.689780000000006, 139.70379),
                            GeoLocation(35.68981, 139.70406),
                            GeoLocation(35.689840000000004, 139.70418)
                        ), maneuver = null
                    ),
                    NaviStep(
                        start = GeoLocation(35.68983950000001, 139.7041772),
                        end = GeoLocation(35.6979063, 139.7074366),
                        distance = 954.0,
                        duration = Duration.parse("PT4M28S"),
                        guideText = "<b>新宿四丁目（交差点）</b>에서 <b>좌회전</b>하여 <b>明治通り</b>/<wbr/><b>都道305号</b>에 진입",
                        polyline = listOf(
                            GeoLocation(35.689840000000004, 139.70418),
                            GeoLocation(35.68999, 139.70427),
                            GeoLocation(35.690250000000006, 139.70445),
                            GeoLocation(35.690340000000006, 139.70450000000002),
                            GeoLocation(35.69048, 139.70459000000002),
                            GeoLocation(35.690580000000004, 139.70466000000002),
                            GeoLocation(35.69071, 139.70475000000002),
                            GeoLocation(35.69086, 139.70487),
                            GeoLocation(35.69089, 139.70489),
                            GeoLocation(35.691050000000004, 139.70499),
                            GeoLocation(35.691140000000004, 139.70505),
                            GeoLocation(35.69115, 139.70506),
                            GeoLocation(35.6912, 139.70509),
                            GeoLocation(35.69144, 139.70522000000003),
                            GeoLocation(35.69155, 139.70528000000002),
                            GeoLocation(35.6916, 139.70532),
                            GeoLocation(35.691610000000004, 139.70532),
                            GeoLocation(35.69163, 139.70533),
                            GeoLocation(35.691680000000005, 139.70536),
                            GeoLocation(35.69171, 139.70538000000002),
                            GeoLocation(35.691770000000005, 139.70541),
                            GeoLocation(35.691840000000006, 139.70545),
                            GeoLocation(35.691880000000005, 139.70547000000002),
                            GeoLocation(35.69239, 139.70577),
                            GeoLocation(35.692440000000005, 139.70581),
                            GeoLocation(35.6925, 139.70584000000002),
                            GeoLocation(35.692660000000004, 139.70594),
                            GeoLocation(35.69267, 139.70595),
                            GeoLocation(35.69283, 139.70604),
                            GeoLocation(35.692910000000005, 139.70609000000002),
                            GeoLocation(35.69304, 139.70617000000001),
                            GeoLocation(35.69315, 139.70623),
                            GeoLocation(35.693180000000005, 139.70625),
                            GeoLocation(35.69324, 139.70628000000002),
                            GeoLocation(35.6933, 139.70632),
                            GeoLocation(35.69341, 139.70638000000002),
                            GeoLocation(35.6935, 139.70643),
                            GeoLocation(35.693560000000005, 139.70644000000001),
                            GeoLocation(35.693580000000004, 139.70644000000001),
                            GeoLocation(35.69373, 139.70651),
                            GeoLocation(35.69382, 139.70655000000002),
                            GeoLocation(35.693900000000006, 139.70658),
                            GeoLocation(35.694430000000004, 139.70669),
                            GeoLocation(35.694610000000004, 139.70673000000002),
                            GeoLocation(35.69471, 139.70675),
                            GeoLocation(35.694880000000005, 139.70678),
                            GeoLocation(35.69521, 139.70687),
                            GeoLocation(35.6955, 139.70694),
                            GeoLocation(35.69597, 139.70705),
                            GeoLocation(35.6961, 139.70708000000002),
                            GeoLocation(35.696400000000004, 139.70713),
                            GeoLocation(35.69652, 139.70716000000002),
                            GeoLocation(35.69659, 139.70717000000002),
                            GeoLocation(35.69666, 139.70718000000002),
                            GeoLocation(35.69695, 139.70724),
                            GeoLocation(35.69711, 139.70727000000002),
                            GeoLocation(35.6972, 139.70729),
                            GeoLocation(35.69774, 139.7074),
                            GeoLocation(35.69791, 139.70744000000002)
                        ),
                        maneuver = Maneuver.TURN_LEFT
                    ),
                    NaviStep(
                        start = GeoLocation(35.6979063, 139.7074366),
                        end = GeoLocation(35.6981806, 139.7032972),
                        distance = 377.0,
                        duration = Duration.parse("PT1M35S"),
                        guideText = "<b>新宿七丁目（交差点）</b>에서 <b>좌회전</b>하여 <b>職安通り</b>/<wbr/><b>都道302号</b>에 진입 (<b>Kitashinjuku</b> 표지)",
                        polyline = listOf(
                            GeoLocation(35.69791, 139.70744000000002),
                            GeoLocation(35.69796, 139.70702),
                            GeoLocation(35.697970000000005, 139.70693),
                            GeoLocation(35.697970000000005, 139.70688),
                            GeoLocation(35.698010000000004, 139.70658),
                            GeoLocation(35.69802, 139.70645000000002),
                            GeoLocation(35.69805, 139.70623),
                            GeoLocation(35.69805, 139.70619000000002),
                            GeoLocation(35.69811, 139.70575000000002),
                            GeoLocation(35.698130000000006, 139.70558),
                            GeoLocation(35.69818, 139.70520000000002),
                            GeoLocation(35.698190000000004, 139.70511000000002),
                            GeoLocation(35.6982, 139.70506),
                            GeoLocation(35.69823, 139.7049),
                            GeoLocation(35.69823, 139.70488),
                            GeoLocation(35.698240000000006, 139.70481),
                            GeoLocation(35.698240000000006, 139.70476000000002),
                            GeoLocation(35.69825, 139.70468000000002),
                            GeoLocation(35.69825, 139.70461),
                            GeoLocation(35.698260000000005, 139.70454),
                            GeoLocation(35.698260000000005, 139.70447000000001),
                            GeoLocation(35.698260000000005, 139.70436),
                            GeoLocation(35.698260000000005, 139.70430000000002),
                            GeoLocation(35.698260000000005, 139.70423000000002),
                            GeoLocation(35.69825, 139.7041),
                            GeoLocation(35.69825, 139.70406),
                            GeoLocation(35.698240000000006, 139.70399),
                            GeoLocation(35.698240000000006, 139.70394000000002),
                            GeoLocation(35.69823, 139.7039),
                            GeoLocation(35.69818, 139.7033)
                        ),
                        maneuver = Maneuver.TURN_LEFT
                    ),
                    NaviStep(
                        start = GeoLocation(35.6981806, 139.7032972),
                        end = GeoLocation(35.6978576, 139.7032374),
                        distance = 36.0,
                        duration = Duration.parse("PT16S"),
                        guideText = "<b>좌회전</b><div style=\"font-size:0.9em\">목적지는 길의 오른쪽에 있습니다.</div>",
                        polyline = listOf(
                            GeoLocation(35.69818, 139.7033),
                            GeoLocation(35.698130000000006, 139.70329),
                            GeoLocation(35.698060000000005, 139.70328),
                            GeoLocation(35.698, 139.70327),
                            GeoLocation(35.69789, 139.70324000000002),
                            GeoLocation(35.697860000000006, 139.70324000000002)
                        ),
                        maneuver = Maneuver.TURN_LEFT
                    )
                )
            )
        )
    )
    walking = PartialRoute(
        summary = "WALKING_ECOLO_PARK_KABUKICHO_29_TO_패밀리마트_카부키쵸키타점",
        bounds = GeoBounds(
            northEast = GeoLocation(35.6980957, 139.7032697),
            southWest = GeoLocation(35.697859, 139.7026791)
        ),
        overview = OVERVIEW_WALKING_ECOLO_PARK_KABUKICHO_29_TO_패밀리마트_카부키쵸키타점,
        legList = listOf(
            NaviLeg(
                start = GeoLocation(35.697859, 139.7032213),
                end = GeoLocation(35.6980353, 139.7026791),
                distance = 105.0,
                stepList = listOf(
                    NaviStep(
                        start = GeoLocation(35.697859, 139.7032213),
                        end = GeoLocation(35.6980957, 139.7032697),
                        distance = 36.0,
                        duration = Duration.parse("PT26S"),
                        guideText = "<b>職安通り</b>/<wbr/><b>都道302号</b> 방면 <b>북쪽</b>으로 걷기",
                        polyline = listOf(
                            GeoLocation(35.697860000000006, 139.70322000000002),
                            GeoLocation(35.69789, 139.70323000000002),
                            GeoLocation(35.698, 139.70325000000003),
                            GeoLocation(35.698060000000005, 139.70326),
                            GeoLocation(35.698100000000004, 139.70327)
                        ),
                        maneuver = null
                    ),
                    NaviStep(
                        start = GeoLocation(35.6980957, 139.7032697),
                        end = GeoLocation(35.698043, 139.7026796),
                        distance = 60.0,
                        duration = Duration.parse("PT44S"),
                        guideText = "<b>좌회전</b>하여 <b>職安通り</b>/<wbr/><b>都道302号</b>에 진입",
                        polyline = listOf(
                            GeoLocation(35.698100000000004, 139.70327),
                            GeoLocation(35.698040000000006, 139.70268000000002)
                        ),
                        maneuver = Maneuver.TURN_LEFT
                    ),
                    NaviStep(
                        start = GeoLocation(35.698043, 139.7026796),
                        end = GeoLocation(35.6980353, 139.7026791),
                        distance = 9.0,
                        duration = Duration.parse("PT7S"),
                        guideText = "<b>좌회전</b>하여 <b>3番通り</b>에 진입<div style=\"font-size:0.9em\">목적지는 길의 왼쪽에 있습니다.</div>",
                        polyline = listOf(
                            GeoLocation(35.698040000000006, 139.70268000000002)
                        ),
                        maneuver = Maneuver.TURN_LEFT
                    )
                )
            )
        )
    )
}
