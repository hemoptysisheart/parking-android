package com.github.hemoptysisheart.parking.app.configuration

import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.LocationModelImpl
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
    abstract fun bindLocationModel(model: LocationModelImpl): LocationModel
}
