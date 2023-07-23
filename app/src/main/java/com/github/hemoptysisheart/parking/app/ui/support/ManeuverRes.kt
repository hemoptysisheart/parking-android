package com.github.hemoptysisheart.parking.app.ui.support

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.github.hemoptysisheart.parking.R.string.*
import com.github.hemoptysisheart.parking.domain.deprecate.Maneuver

/**
 * [Maneuver]의 UI용 리소스 정보.
 */
enum class ManeuverRes(
    val maneuver: Maneuver,
    val imageVector: ImageVector,
    @StringRes val description: Int
) {
    TURN_SLIGHT_LEFT(Maneuver.TURN_SLIGHT_LEFT, Icons.Default.TurnSlightLeft, domain_maneuver_turn_slight_left),
    TURN_SHARP_LEFT(Maneuver.TURN_SHARP_LEFT, Icons.Default.TurnSharpLeft, domain_maneuver_turn_sharp_left),
    TURN_LEFT(Maneuver.TURN_LEFT, Icons.Default.TurnLeft, domain_maneuver_turn_left),
    TURN_SLIGHT_RIGHT(Maneuver.TURN_SLIGHT_RIGHT, Icons.Default.TurnSlightRight, domain_maneuver_turn_slight_right),
    TURN_SHARP_RIGHT(Maneuver.TURN_SHARP_RIGHT, Icons.Default.TurnSharpRight, domain_maneuver_turn_sharp_right),

    /**
     * TODO 아이콘 변경.
     */
    KEEP_RIGHT(Maneuver.KEEP_RIGHT, Icons.Default.NorthEast, domain_maneuver_keep_right),

    /**
     * TODO 아이콘 변경.
     */
    KEEP_LEFT(Maneuver.KEEP_LEFT, Icons.Default.NorthWest, domain_maneuver_keep_left),
    UTURN_LEFT(Maneuver.UTURN_LEFT, Icons.Default.UTurnLeft, domain_maneuver_uturn_left),
    UTURN_RIGHT(Maneuver.UTURN_RIGHT, Icons.Default.UTurnRight, domain_maneuver_uturn_right),
    TURN_RIGHT(Maneuver.TURN_RIGHT, Icons.Default.TurnRight, domain_maneuver_turn_right),
    STRAIGHT(Maneuver.STRAIGHT, Icons.Default.Straight, domain_maneuver_straight),
    RAMP_LEFT(Maneuver.RAMP_LEFT, Icons.Default.RampLeft, domain_maneuver_ramp_left),
    RAMP_RIGHT(Maneuver.RAMP_RIGHT, Icons.Default.RampRight, domain_maneuver_ramp_right),
    MERGE(Maneuver.MERGE, Icons.Default.Merge, domain_maneuver_merge),
    FORK_LEFT(Maneuver.FORK_LEFT, Icons.Default.ForkLeft, domain_maneuver_fork_left),
    FORK_RIGHT(Maneuver.FORK_RIGHT, Icons.Default.ForkRight, domain_maneuver_fork_right),

    /**
     * TODO 아이콘 변경.
     */
    FERRY(Maneuver.FERRY, Icons.Default.DirectionsBoat, domain_maneuver_ferry),

    /**
     * TODO 아이콘 변경.
     */
    FERRY_TRAIN(Maneuver.FERRY_TRAIN, Icons.Default.DirectionsTransit, domain_maneuver_ferry_train),
    ROUNDABOUT_LEFT(Maneuver.ROUNDABOUT_LEFT, Icons.Default.RoundaboutLeft, domain_maneuver_roundabout_left),
    ROUNDABOUT_RIGHT(Maneuver.ROUNDABOUT_RIGHT, Icons.Default.RoundaboutRight, domain_maneuver_roundabout_right);

    companion object {
        private val MANEUVER_MAP = values().associateBy { it.maneuver }

        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(maneuver: Maneuver) = MANEUVER_MAP[maneuver]
            ?: throw IllegalArgumentException("illegal maneuver : maneuver=$maneuver")
    }
}
