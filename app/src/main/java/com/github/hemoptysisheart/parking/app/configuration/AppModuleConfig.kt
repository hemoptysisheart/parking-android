package com.github.hemoptysisheart.parking.app.configuration

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.hemoptysisheart.parking.core.model.*
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

//    @Provides
//    @Singleton
//    fun provideLocationTrackerModel(@ApplicationContext context: Context): LocationTrackerModel {
//        Log.v(TAG, "#provideLocationTrackerModel args : context=$context")
//
//        val client = LocationServices.getFusedLocationProviderClient(context)
//        Log.v(TAG, "#provideLocationTrackerModel : client=$client")
//
//        val model = LocationTrackerModelImpl(client)
//        model.start()
//
//        Log.v(TAG, "#provideLocationTrackerModel return : $model")
//        return model
//    }

    @Provides
    @Singleton
    fun providePlaceModel(): PlaceModel = PlaceModelImpl()

    @Provides
    @Singleton
    fun provideTestModel(): TestModel {
        Log.v(TAG, "#provideTestModel called.")
        return TestModel()
    }

//    @Provides
//    @Singleton
//    fun provideTestModel2(@ApplicationContext context: Context): TestModel2 {
//        Log.v(TAG, "#provideTestModel2 args : context=$context")
//        return TestModel2(context)
//    }
}
