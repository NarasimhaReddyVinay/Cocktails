package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.cocktail.api.ApiService
import com.example.cocktail.data.Repository
import com.example.cocktail.data.RepositoryImpl
import com.example.cocktail.model.FavoriteDao
import com.example.cocktail.model.FavoriteDatabase
import com.example.cocktail.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun getApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(ApiService::class.java)

    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun provideRepository(@ApplicationContext context: Context): Repository {
        return  RepositoryImpl(getApiService(),provideNotesDao(provideAppDatabase(context)))
    }

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase:FavoriteDatabase):FavoriteDao
            =noteDatabase.favoriteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):FavoriteDatabase
            = Room.databaseBuilder(
        context,
        FavoriteDatabase::class.java,
        "notes_db")
        .fallbackToDestructiveMigration()
        .build()

}