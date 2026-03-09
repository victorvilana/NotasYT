package com.example.notasyt.models

import java.time.LocalDateTime
import java.util.UUID

data class Nota(
    val id: UUID = UUID.randomUUID(),
    val titulo: String,
    val descripcion: String,
    val fecha : LocalDateTime = LocalDateTime.now()
)
