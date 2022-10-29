package com.github.hemoptysisheart.parking.app.configuration

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.hemoptysisheart.core.model.LocationModel
import com.github.hemoptysisheart.core.model.LocationModelImpl
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModuleConfig {
    companion object {
        private val TAG = AppModuleConfig::class.simpleName
    }

    @Provides
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
    fun provideFusedLocationProviderClient(@ApplicationContext context: Context): FusedLocationProviderClient {
        Log.v(TAG, "#provideFusedLocationProviderClient args : context=$context")

        val client = LocationServices.getFusedLocationProviderClient(context)

        Log.v(TAG, "#provideFusedLocationProviderClient return : $client")
        return client
    }

    @Provides
    fun provideLocationModel(locationProviderClient: FusedLocationProviderClient): LocationModel {
        val model = LocationModelImpl(locationProviderClient)
        model.init()
        return model
    }
}
