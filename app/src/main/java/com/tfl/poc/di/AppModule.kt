package com.tfl.poc.di


import com.tfl.poc.data.remote.TFLApi
import com.tfl.poc.data.repository.TFLRepositoryImpl
import com.tfl.poc.domain.repository.TFLRepository
import com.tfl.poc.utility.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTFLApi(): TFLApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TFLApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: TFLApi): TFLRepository {
        return TFLRepositoryImpl(api)
    }
}