package com.github.hemoptysisheart.parking.app.configuration

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.hemoptysisheart.parking.BuildConfig
import com.github.hemoptysisheart.parking.core.client.google.MapsClient
import com.github.hemoptysisheart.parking.core.client.google.MapsClientImpl
import com.github.hemoptysisheart.parking.core.client.google.PlacesClientConfig
import com.github.hemoptysisheart.parking.core.model.*
import com.github.hemoptysisheart.parking.domain.ExecutionPreferences
import com.github.hemoptysisheart.parking.domain.InstallPreferences
import com.github.hemoptysisheart.parking.domain.Preferences
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
        private const val TAG = "AppModuleConfig"
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
        Log.i(TAG, "#provideSharedPreferences args : context=$context")
        val sharedPreferences = EncryptedSharedPreferences.create(
            context,
            "com.github.hemoptysisheart.parking.encryptedSharedPreferences",
            MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        Log.i(TAG, "#provideSharedPreferences return : $sharedPreferences")
        return sharedPreferences
    }

    @Provides
    @Singleton
    fun provideMapsClient(timeProvider: TimeProvider): MapsClient {
        val config = PlacesClientConfig(
            key = BuildConfig.GOOGLE_MAPS_PLATFORM_API_KEY,
            timeProvider = timeProvider,
            useDefaultLocale = true,
            debug = BuildConfig.DEBUG
        )
        val client = MapsClientImpl(config)

        Log.i(TAG, "#provideMapsClient return : $client")
        return client
    }

    @Provides
    @Singleton
    fun providePreferencesModel(sharedPreferences: SharedPreferences): Preferences {
        val model = PreferencesModel(sharedPreferences)
        Log.i(TAG, "#providePreferencesModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun provideExecutionPreferencesModel(preferences: Preferences): ExecutionPreferences = preferences.execution

    @Provides
    @Singleton
    fun provideInstallPreferencesModel(preferences: Preferences): InstallPreferences = preferences.install

    @Provides
    @Singleton
    fun provideLocationModel(@ApplicationContext context: Context): LocationModel {
        val client = LocationServices.getFusedLocationProviderClient(context)
        val model = LocationModelImpl(client)

        Log.i(TAG, "#provideLocationModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun provideGeoSearchModel(mapsClient: MapsClient, timeProvider: TimeProvider): GeoSearchModel {
        val model = GeoSearchModelImpl(mapsClient, timeProvider)
        Log.i(TAG, "#provideGeoSearchModel return : $model")
        return model
    }
}
