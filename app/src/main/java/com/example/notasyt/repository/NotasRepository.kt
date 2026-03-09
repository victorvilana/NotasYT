package com.example.notasyt.repository

import com.example.notasyt.data.NotasDataBaseDao
import com.example.notasyt.models.Nota
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NotasRepository @Inject constructor(
    //Se inyecta el objeto NotasDataBaseDao
    private val notasDataBaseDao: NotasDataBaseDao
) {

    suspend fun addNota(nota: Nota) = notasDataBaseDao.insertNota(nota)
    suspend fun updateNota(nota: Nota) = notasDataBaseDao.updateNota(nota)
    suspend fun deleteNota(nota: Nota) = notasDataBaseDao.deleteNota(nota)
    suspend fun deleteAllNotas() = notasDataBaseDao.deleteAllNotas()

    fun getAllNotas(): Flow<List<Nota>>
    = notasDataBaseDao.getNotas().flowOn(Dispatchers.IO).conflate()

}