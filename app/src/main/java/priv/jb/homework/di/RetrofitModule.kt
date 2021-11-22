package priv.jb.homework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import priv.jb.homework.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule  {
    private val url = "https://us-central1-lithe-window-713.cloudfunctions.net"
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun provideApi(retrofit : Retrofit) : Api {
        return retrofit.create(Api::class.java)
    }
}