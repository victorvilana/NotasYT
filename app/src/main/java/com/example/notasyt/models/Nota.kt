package com.example.notasyt.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID
import kotlin.time.ExperimentalTime


@Entity(tableName = "notas_tbl")
data class Nota @OptIn(ExperimentalTime::class) constructor(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val titulo: String,
    val descripcion: String,
    //val fecha : LocalDateTime = LocalDateTime.now()
    val fecha: Date = Date.from(Instant.now())
)
