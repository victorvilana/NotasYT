package com.example.notasyt.di

import android.content.Context
import androidx.room.Room
import com.example.notasyt.data.NotasDataBase
import com.example.notasyt.data.NotasDataBaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module

object AppModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NotasDataBase
    = Room.databaseBuilder(
        context,
        NotasDataBase::class.java,
        "notas_db"
    )
        .fallbackToDestructiveMigration(false)
        .build()

    @Singleton
    @Provides
    fun provideNotasDao(notasDataBase: NotasDataBase): NotasDataBaseDao
    = notasDataBase.notasDao()

}
