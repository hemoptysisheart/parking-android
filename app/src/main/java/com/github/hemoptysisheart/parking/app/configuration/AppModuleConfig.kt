package com.github.hemoptysisheart.parking.app.configuration

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.hemoptysisheart.parking.core.model.*
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
        Log.i(TAG, "#provideSharedPreferences args : context=$context")

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
    fun provideLocationModel(): LocationModel = LocationModelImpl()

    @Provides
    @Singleton
    fun provideLocationTrackerModel(
        @ApplicationContext context: Context,
        locationModel: LocationModel
    ): LocationTrackerModel {
        Log.v(TAG, "#provideLocationTrackerModel args : context=$context, locationModel=$locationModel")

        val client = LocationServices.getFusedLocationProviderClient(context)
        val model = LocationTrackerModelImpl(client, locationModel)

        Log.v(TAG, "#provideLocationTrackerModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun providePlaceModel(): PlaceModel = PlaceModelImpl()
}
