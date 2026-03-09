package com.example.notasyt.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notasyt.models.Nota
import kotlinx.coroutines.flow.Flow

@Dao
interface NotasDataBaseDao {
    @Query("SELECT * from notas_tbl")
    fun getNotas(): Flow<List<Nota>>

    @Query("SELECT * from notas_tbl where id =:id")
    suspend fun getNotaById(id: String): Nota

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNota(nota: Nota)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNota(nota: Nota)

    @Delete
    suspend fun deleteNota(nota: Nota)

    @Query("DELETE from notas_tbl")
    suspend fun deleteAllNotas()
}
