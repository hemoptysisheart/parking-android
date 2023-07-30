package com.github.hemoptysisheart.parking.app.configuration

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.hemoptysisheart.parking.BuildConfig
import com.github.hemoptysisheart.parking.core.model.*
import com.github.hemoptysisheart.parking.core.util.AndroidLogger
import com.github.hemoptysisheart.parking.domain.app.Preferences
import com.github.hemoptysisheart.util.TimeProvider
import com.github.hemoptysisheart.util.TruncatedTimeProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModuleProvider {
    companion object {
        private const val TAG = "AppModuleConfig"
        private val LOGGER = AndroidLogger(TAG)
    }

    @Provides
    @Singleton
    fun provideMapsClient(): com.github.hemoptysisheart.parking.client.google.MapsClient {
        val config = com.github.hemoptysisheart.parking.client.google.PlacesClientConfig(
            key = BuildConfig.GOOGLE_MAPS_PLATFORM_API_KEY,
            useDefaultLocale = true,
            debug = BuildConfig.DEBUG
        )
        val client = com.github.hemoptysisheart.parking.client.google.MapsClientImpl(config)

        LOGGER.i("#provideMapsClient return : $client")
        return client
    }

    @Provides
    @Singleton
    fun provideTimeProvider(): TimeProvider {
        val provider = TruncatedTimeProvider()
        LOGGER.i("#provideTimeProvider return : $provider")
        return provider
    }

    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context, timeProvider: TimeProvider): Preferences {
        val sharedPreferences = EncryptedSharedPreferences.create(
            context,
            "com.github.hemoptysisheart.parking.sharedPreferences",
            MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        val model = PreferencesModel(sharedPreferences, timeProvider)
        LOGGER.i("#providePreferencesModel return : $model")
        return model
    }

    @Provides
    @Singleton
    fun provideExecutionPreferences(preferences: Preferences) = preferences.execution

    @Provides
    @Singleton
    fun provideInstallPreferences(preferences: Preferences) = preferences.install

    @Provides
    @Singleton
    fun provideWizardPreferences(preferences: Preferences) = preferences.wizard
}
