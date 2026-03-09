package com.example.notasyt.data

import com.example.notasyt.models.Nota

class NotaDataSource {
    fun loadNotas(): List<Nota>{
        return listOf(
            Nota(titulo = "Ir al doctor", descripcion = "Agendar la cita al 0982210760"),

            Nota(titulo = "Llamar a casa de mis padres", descripcion = "Consultar como les está yendo con la terapia"),

            Nota(titulo = "Arreglar el baño", descripcion = "Comprar líquido que permita destapar el baño"),

            )
    }
}