package com.github.hemoptysisheart.parking.core.model

import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.core.util.AndroidMessageException
import javax.inject.Inject

class GlobalChannelImpl @Inject constructor() : GlobalChannel, GlobalChannelConsumer {
    companion object {
        private val LOGGER = AndroidLogger(GlobalChannelImpl::class)
    }

    override lateinit var progressConsumer: GlobalChannelConsumer.Consumer<Int>

    override lateinit var exceptionConsumer: GlobalChannelConsumer.Consumer<AndroidMessageException>

    override fun reportProgress(weight: Int) {
        progressConsumer(weight)
    }

    override fun reportException(exception: AndroidMessageException) {
        exceptionConsumer(exception)
    }

    override fun toString() =
        "GlobalChannelImpl(progressConsumer=$progressConsumer, exceptionConsumer=$exceptionConsumer)"
}
