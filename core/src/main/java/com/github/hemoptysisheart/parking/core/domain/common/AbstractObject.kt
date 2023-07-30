package com.github.hemoptysisheart.parking.core.domain.common

import com.github.hemoptysisheart.parking.domain.common.Identifier
import com.github.hemoptysisheart.parking.domain.common.Object

abstract class AbstractObject(
    override val id: Identifier
) : Object