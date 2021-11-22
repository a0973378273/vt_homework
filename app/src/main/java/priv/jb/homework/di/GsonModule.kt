package priv.jb.homework.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GsonModule{
    @Singleton
    @Provides
    fun getGson() : Gson{
        return Gson()
    }
}