package com.github.hemoptysisheart.parking.app.configuration

import com.github.hemoptysisheart.parking.core.model.GlobalChannel
import com.github.hemoptysisheart.parking.core.model.GlobalChannelConsumer
import com.github.hemoptysisheart.parking.core.model.GlobalChannelImpl
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.core.model.PlaceModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinder {
    @Binds
    @Singleton
    abstract fun bindGlobalChannel(channel: GlobalChannelImpl): GlobalChannel

    @Binds
    @Singleton
    abstract fun bindGlobalChannelConsumer(channel: GlobalChannelImpl): GlobalChannelConsumer

    @Binds
    @Singleton
    abstract fun bindPlaceModelImpl(model: PlaceModelImpl): PlaceModel
}