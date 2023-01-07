package com.github.hemoptysisheart.parking.app.configuration

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.hemoptysisheart.parking.BuildConfig
import com.github.hemoptysisheart.parking.core.client.google.PlacesClient
import com.github.hemoptysisheart.parking.core.client.google.PlacesClientConfig
import com.github.hemoptysisheart.parking.core.client.google.PlacesClientImpl
import com.github.hemoptysisheart.parking.core.model.*
import com.github.hemoptysisheart.parking.core.repository.LocationRepository
import com.github.hemoptysisheart.parking.core.repository.LocationRepositoryImpl
import com.github.hemoptysisheart.parking.core.repository.MapStateRepository
import com.github.hemoptysisheart.parking.core.repository.MapStateRepositoryImpl
import com.github.hemoptysisheart.parking.core.room.configuration.ParkingRoomConfiguration
import com.github.hemoptysisheart.parking.core.room.dao.LocationDao
import com.github.hemoptysisheart.parking.core.room.dao.MapStateDao
import com.github.hemoptysisheart.util.TimeProvider
import com.github.hemoptysisheart.util.TruncatedTimeProvider
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModuleConfig {
    companion object {
        private val TAG = AppModuleConfig::class.simpleName
    }

    @Provides
    @Singleton
    fun provideTimeProvider(): TimeProvider {
        val provider = TruncatedTimeProvider()
        Log.i(TAG, "#provideTimeProvider return : $provider")
        return provider
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        val sharedPreferences = EncryptedSharedPreferences.create(
            context,
            "com.github.hemoptysisheart.parking.encryptedSharedPreferences",
            MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        Log.i(TAG, "#provideSharedPreferences return : $sharedPreferences")
        return sharedPreferences
    }

    @Provides
    @Singleton
    fun providePlacesClient(timeProvider: TimeProvider): PlacesClient {
        val config = PlacesClientConfig(
            key = BuildConfig.MAPS_API_KEY,
            useDefaultLocale = true,
            timeProvider = timeProvider,
            debug = BuildConfig.DEBUG
        )
        val client = PlacesClientImpl(config)
        Log.i(TAG, "#providePlacesClient return : $client")
        return client
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ParkingRoomConfiguration {
        val room = Room.databaseBuilder(context, ParkingRoomConfiguration::class.java, "parking")
            .build()
        Log.i(TAG, "#provideDatabase return : $room")
        return room
    }

    @Provides
    @Singleton
    fun provideLocationDao(room: ParkingRoomConfiguration): LocationDao {
        val dao = room.locationDao()
        Log.i(TAG, "#provideLocationDao return : $dao")
        return dao
    }

    @Provides
    @Singleton
    fun provideMapStateDao(room: ParkingRoomConfiguration): MapStateDao {
        val dao = room.mapStateDao()
        Log.i(TAG, "#provideMapStateDao return : $dao")
        return dao
    }

    @Provides
    @Singleton
    fun provideLocationRepository(dao: LocationDao): LocationRepository {
        val repository = LocationRepositoryImpl(dao)
        Log.i(TAG, "#provideLocationRepository return : $repository")
        return repository
    }

    @Provides
    @Singleton
    fun provideMapStateRepository(dao: MapStateDao): MapStateRepository {
        val repository = MapStateRepositoryImpl(dao)
        Log.i(TAG, "#provideMapStateRepository return : $repository")
        return repository
    }

    @Provides
    @Singleton
    fun provideLocationModel(repository: LocationRepository, timeProvider: TimeProvider): LocationModel {
        val model = LocationModelImpl(repository, timeProvider)
        Log.i(TAG, "#provideLocationModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun provideSensorControllerModel(
        @ApplicationContext context: Context,
        locationModel: LocationModel,
        timeProvider: TimeProvider
    ): SensorControllerModel {
        val model = SensorControllerModelImpl(
            LocationServices.getFusedLocationProviderClient(context),
            locationModel,
            timeProvider
        )
        Log.i(TAG, "#provideSensorControllerModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun providePlaceModel(timeProvider: TimeProvider, placesClient: PlacesClient): PlaceModel {
        val model = PlaceModelImpl(timeProvider, placesClient)
        Log.i(TAG, "#providePlaceModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun provideMapModel(repository: MapStateRepository): MapModel {
        val model = MapModelImpl(repository)
        Log.i(TAG, "#provideMapModel return : $model")
        return model
    }
}
