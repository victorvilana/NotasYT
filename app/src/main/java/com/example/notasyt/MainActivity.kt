package com.example.notasyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notasyt.data.NotaDataSource
import com.example.notasyt.models.Nota
import com.example.notasyt.screens.NotaViewModel
import com.example.notasyt.screens.NotasScreen
import com.example.notasyt.ui.theme.NotasYTTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotasYTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val notaViewModel : NotaViewModel by viewModels()
                        //val listaNotas = notaViewModel.getAllNotas()
                        val listaNotas = notaViewModel.listaNotas.collectAsState().value

                        NotasScreen(
                            //notas = NotaDataSource().loadNotas(),
                            notas = listaNotas,
                            onAddNota = {
                                notaViewModel.addNota(it)
                            },
                            onRemoveNota = {
                                notaViewModel.removeNota(it)
                            },

                            onGetAllNotas = {
                                notaViewModel.getAllNotas()
                            }

                        )
                    }

                }
            }
        }
    }
}
