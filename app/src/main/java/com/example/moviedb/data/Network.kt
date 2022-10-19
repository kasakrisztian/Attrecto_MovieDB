package com.example.moviedb.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object Network {
    private fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private fun provideMoshiConverterFactory() = MoshiConverterFactory.create(provideMoshi())

    private fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .client(provideOkHttpClient())
        .baseUrl("https://www.omdbapi.com/")
        .addConverterFactory(provideMoshiConverterFactory())
        .build()

    fun provideMoviesApi(): MoviesApi = provideRetrofit().create()
}