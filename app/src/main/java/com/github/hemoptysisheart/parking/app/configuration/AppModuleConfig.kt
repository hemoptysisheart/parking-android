package com.github.hemoptysisheart.parking.app.configuration

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.hemoptysisheart.parking.BuildConfig
import com.github.hemoptysisheart.parking.core.model.GeoSearchModel
import com.github.hemoptysisheart.parking.core.model.GeoSearchModelImpl
import com.github.hemoptysisheart.parking.core.model.LocationModel
import com.github.hemoptysisheart.parking.core.model.LocationModelImpl
import com.github.hemoptysisheart.util.TimeProvider
import com.github.hemoptysisheart.util.TruncatedTimeProvider
import com.google.android.gms.location.LocationServices
import com.google.maps.GeoApiContext
import com.google.maps.metrics.OpenCensusRequestMetricsReporter
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
    fun provideLocationModel(@ApplicationContext context: Context): LocationModel {
        val client = LocationServices.getFusedLocationProviderClient(context)
        val model = LocationModelImpl(client)

        Log.i(TAG, "#provideLocationModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun provideGeoSearchModel(timeProvider: TimeProvider): GeoSearchModel {
        val gmpContext = GeoApiContext.Builder()
            .apiKey(BuildConfig.GOOGLE_MAPS_PLATFORM_API_KEY)
            .requestMetricsReporter(OpenCensusRequestMetricsReporter())

        val model = GeoSearchModelImpl(gmpContext.build(), timeProvider)
        Log.i(TAG, "#provideGeoSearchModel return : $model")
        return model
    }
}
