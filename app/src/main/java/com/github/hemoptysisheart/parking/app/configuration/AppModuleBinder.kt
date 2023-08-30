package com.github.hemoptysisheart.parking.app.configuration

import com.github.hemoptysisheart.parking.core.model.GlobalChannel
import com.github.hemoptysisheart.parking.core.model.GlobalChannelConsumer
import com.github.hemoptysisheart.parking.core.model.GlobalChannelImpl
import com.github.hemoptysisheart.parking.core.model.PlaceModel
import com.github.hemoptysisheart.parking.core.model.PlaceModelImpl
import com.github.hemoptysisheart.parking.core.model.RouteModel
import com.github.hemoptysisheart.parking.core.model.RouteModelImpl
import com.github.hemoptysisheart.parking.core.repository.PlaceRepository
import com.github.hemoptysisheart.parking.core.repository.PlaceRepositoryImpl
import com.github.hemoptysisheart.parking.core.repository.RouteRepository
import com.github.hemoptysisheart.parking.core.repository.RouteRepositoryImpl
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
    abstract fun bindPlaceModel(model: PlaceModelImpl): PlaceModel

    @Binds
    @Singleton
    abstract fun bindRouteModel(model: RouteModelImpl): RouteModel

    @Binds
    @Singleton
    abstract fun bindPlaceRepository(repository: PlaceRepositoryImpl): PlaceRepository

    @Binds
    @Singleton
    abstract fun bindRouteRepository(repository: RouteRepositoryImpl): RouteRepository
}