package com.example.notasyt.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.notasyt.components.NotaButton
import com.example.notasyt.components.NotasImputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasScreen() {
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

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
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
                        //Por desarrollar: Guardar la nota
                        titulo = ""
                        descripcion = ""
                    }
                }
            )


        }

    }
}