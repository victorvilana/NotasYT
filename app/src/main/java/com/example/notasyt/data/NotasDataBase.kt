package com.example.notasyt.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notasyt.models.Nota

@Database(entities = [Nota::class], version = 1, exportSchema = false)

@TypeConverters(Converters::class)
abstract class NotasDataBase: RoomDatabase() {
    abstract fun notasDao(): NotasDataBaseDao
}