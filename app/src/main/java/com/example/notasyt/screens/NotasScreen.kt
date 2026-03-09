package com.example.notasyt.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.notasyt.components.NotaButton
import com.example.notasyt.components.NotasImputText
import com.example.notasyt.models.Nota
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasScreen(
    onAddNota: (Nota) -> Unit,
    onRemoveNota: (Nota) -> Unit,
    onGetAllNotas: () -> Unit,


    notas: List<Nota>
) {
    //Título de la nota
    var titulo by remember {
        mutableStateOf("")
    }

    //Descripción de la nota
    var descripcion by remember {
        mutableStateOf("")
    }

    Column(

    ) {
        TopAppBar(
            title = { Text("Mis Notas Personales") },
            actions = {
                Icon(
                    Icons.Rounded.Notifications,
                    contentDescription = "Notificaciones"
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Imputs de las notas
            NotasImputText(
                text = titulo,
                label = "Escribe un título para esta nota",
                maxLines = 1,
                onTextChange = {
                    titulo = it
                }

            )

            NotasImputText(
                text = descripcion,
                label = "Escribe tu nota",
                maxLines = 2,
                onTextChange = {
                    descripcion = it
                }

            )

            NotaButton(
                text = "Guardar Nota",
                onClick = {
                    //Guardar solo si no hay valores vacíos
                    if (titulo.isNotEmpty() && descripcion.isNotEmpty()) {
                        onAddNota(Nota(titulo = titulo, descripcion = descripcion))

                        titulo = ""
                        descripcion = ""
                    }
                }
            )

            HorizontalDivider(
                modifier = Modifier.padding(10.dp),
                DividerDefaults.Thickness,
                DividerDefaults.color
            )

            LazyColumn() {
                items(notas) { nota ->
                    ItemNota(
                        nota = nota,
                        onDelete = {
                            onRemoveNota(it)
                        }
                    )


                }
            }
        }

    }
}

@Composable
fun ItemNota(
    nota: Nota,
    onDelete: (Nota) -> Unit
) {
//    Box(
//        modifier = Modifier
//            .padding(4.dp)
//            .background(
//                color = Color.Black,
//                shape = RoundedCornerShape(24.dp)
//            )
//            .fillMaxWidth()
//    )


    Surface(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        color = Color.LightGray,
        shape = RoundedCornerShape(24.dp)
    )


    {


        Row(
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 6.dp)
                    .weight(1f)

            ) {
                Text(text = nota.titulo)
                Text(text = nota.descripcion)
                Text(text = formatoFecha(nota.fecha.time))

            }
            IconButton(onClick = {onDelete(nota)}) {
                Icon(Icons.Rounded.Delete, contentDescription = "Eliminar Nota")
            }
        }
    }
}

fun formatoFecha(time : Long) : String {
    val fecha = Date(time)
    val format = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault())
    return format.format(fecha)
}
