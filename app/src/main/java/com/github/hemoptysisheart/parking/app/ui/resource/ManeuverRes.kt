package com.github.hemoptysisheart.parking.app.ui.resource

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.github.hemoptysisheart.parking.core.R.drawable.ic_ferry
import com.github.hemoptysisheart.parking.core.R.drawable.ic_ferry_train
import com.github.hemoptysisheart.parking.core.R.drawable.ic_fork_left
import com.github.hemoptysisheart.parking.core.R.drawable.ic_fork_right
import com.github.hemoptysisheart.parking.core.R.drawable.ic_keep_left
import com.github.hemoptysisheart.parking.core.R.drawable.ic_keep_right
import com.github.hemoptysisheart.parking.core.R.drawable.ic_merge
import com.github.hemoptysisheart.parking.core.R.drawable.ic_ramp_left
import com.github.hemoptysisheart.parking.core.R.drawable.ic_ramp_right
import com.github.hemoptysisheart.parking.core.R.drawable.ic_roundabout_left
import com.github.hemoptysisheart.parking.core.R.drawable.ic_roundabout_right
import com.github.hemoptysisheart.parking.core.R.drawable.ic_straight
import com.github.hemoptysisheart.parking.core.R.drawable.ic_turn_left
import com.github.hemoptysisheart.parking.core.R.drawable.ic_turn_right
import com.github.hemoptysisheart.parking.core.R.drawable.ic_turn_sharp_left
import com.github.hemoptysisheart.parking.core.R.drawable.ic_turn_sharp_right
import com.github.hemoptysisheart.parking.core.R.drawable.ic_turn_slight_left
import com.github.hemoptysisheart.parking.core.R.drawable.ic_turn_slight_right
import com.github.hemoptysisheart.parking.core.R.drawable.ic_uturn_left
import com.github.hemoptysisheart.parking.core.R.drawable.ic_uturn_right
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_ferry
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_ferry_train
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_fork_left
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_fork_right
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_keep_left
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_keep_right
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_merge
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_ramp_left
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_ramp_right
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_roundabout_left
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_roundabout_right
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_straight
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_turn_left
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_turn_right
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_turn_sharp_left
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_turn_sharp_right
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_turn_slight_left
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_turn_slight_right
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_uturn_left
import com.github.hemoptysisheart.parking.core.R.string.domain_maneuver_uturn_right
import com.github.hemoptysisheart.parking.domain.route.Maneuver

enum class ManeuverRes(
        val maneuver: Maneuver,
        @StringRes val label: Int,
        @DrawableRes val icon: Int
) {
    TURN_SLIGHT_LEFT(Maneuver.TURN_SLIGHT_LEFT, domain_maneuver_turn_slight_left, ic_turn_slight_left),
    TURN_SHARP_LEFT(Maneuver.TURN_SHARP_LEFT, domain_maneuver_turn_sharp_left, ic_turn_sharp_left),
    TURN_LEFT(Maneuver.TURN_LEFT, domain_maneuver_turn_left, ic_turn_left),
    TURN_SLIGHT_RIGHT(Maneuver.TURN_SLIGHT_RIGHT, domain_maneuver_turn_slight_right, ic_turn_slight_right),
    TURN_SHARP_RIGHT(Maneuver.TURN_SHARP_RIGHT, domain_maneuver_turn_sharp_right, ic_turn_sharp_right),
    KEEP_RIGHT(Maneuver.KEEP_RIGHT, domain_maneuver_keep_right, ic_keep_right),
    KEEP_LEFT(Maneuver.KEEP_LEFT, domain_maneuver_keep_left, ic_keep_left),
    UTURN_LEFT(Maneuver.UTURN_LEFT, domain_maneuver_uturn_left, ic_uturn_left),
    UTURN_RIGHT(Maneuver.UTURN_RIGHT, domain_maneuver_uturn_right, ic_uturn_right),
    TURN_RIGHT(Maneuver.TURN_RIGHT, domain_maneuver_turn_right, ic_turn_right),
    STRAIGHT(Maneuver.STRAIGHT, domain_maneuver_straight, ic_straight),
    RAMP_LEFT(Maneuver.RAMP_LEFT, domain_maneuver_ramp_left, ic_ramp_left),
    RAMP_RIGHT(Maneuver.RAMP_RIGHT, domain_maneuver_ramp_right, ic_ramp_right),
    MERGE(Maneuver.MERGE, domain_maneuver_merge, ic_merge),
    FORK_LEFT(Maneuver.FORK_LEFT, domain_maneuver_fork_left, ic_fork_left),
    FORK_RIGHT(Maneuver.FORK_RIGHT, domain_maneuver_fork_right, ic_fork_right),
    FERRY(Maneuver.FERRY, domain_maneuver_ferry, ic_ferry),
    FERRY_TRAIN(Maneuver.FERRY_TRAIN, domain_maneuver_ferry_train, ic_ferry_train),
    ROUNDABOUT_LEFT(Maneuver.ROUNDABOUT_LEFT, domain_maneuver_roundabout_left, ic_roundabout_left),
    ROUNDABOUT_RIGHT(Maneuver.ROUNDABOUT_RIGHT, domain_maneuver_roundabout_right, ic_roundabout_right);

    companion object {
        operator fun get(ordinal: Int) = values()[ordinal]

        operator fun get(name: String) = valueOf(name)

        operator fun get(maneuver: Maneuver) = values().first { maneuver == it.maneuver }
    }
}
