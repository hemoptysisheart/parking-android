package com.github.hemoptysisheart.parking.app.configuration

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.hemoptysisheart.parking.core.model.*
import com.github.hemoptysisheart.parking.core.repository.LocationRepository
import com.github.hemoptysisheart.parking.core.repository.LocationRepositoryImpl
import com.github.hemoptysisheart.parking.core.room.configuration.ParkingRoomConfiguration
import com.github.hemoptysisheart.parking.core.room.dao.LocationDao
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
    fun provideLocationRepository(dao: LocationDao): LocationRepository {
        val repository = LocationRepositoryImpl(dao)
        Log.i(TAG, "#provideLocationRepository return : $repository")
        return repository
    }

    @Provides
    @Singleton
    fun provideLocationModel(repository: LocationRepository): LocationModel {
        val model = LocationModelImpl(repository)
        Log.i(TAG, "#provideLocationModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun provideSensorControllerModel(
        @ApplicationContext context: Context,
        locationModel: LocationModel
    ): SensorControllerModel {
        val model = SensorControllerModelImpl(LocationServices.getFusedLocationProviderClient(context), locationModel)
        Log.i(TAG, "#provideSensorControllerModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun providePlaceModel(): PlaceModel {
        val model = PlaceModelImpl()
        Log.i(TAG, "#providePlaceModel return : $model")
        return model
    }
}
