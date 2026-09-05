package dev.com.example.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.com.example.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                 ImcCalculator()

              }
            }
        }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloComposeForm(){
    var name by remember { mutableStateOf(value = "") }
    var birthDate by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(title = {Text("Hola ESAN")})
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding( paddingValues = padding)
                .fillMaxSize(),
             verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Text("Bienvenido a Curso de Desarrollo móviles")
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = {Text("Nombre")}
            )
            OutlinedTextField(
                value = birthDate,
                onValueChange = {birthDate = it},
                label = {Text("Nombre")}
            )
            Button(
                onClick = {},
                enabled = name.isNotEmpty() && birthDate.isNotEmpty()
            ) {
                Text("Enviar")
            }
        }
        }
    }
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImcCalculator(){
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Scaffold(
        topBar = {TopAppBar(title = {Text("Calculadora de IMC")} )}
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = peso,
                onValueChange = {peso = it},
                label = {Text("Peso (Kg)")}
            )
            OutlinedTextField(
                value = altura,
                onValueChange = {altura = it},
                label = {Text("Altura (m) ")}
            )

            Button(
                onClick = {
                    val peso = peso.toDoubleOrNull()
                    val altura = altura.toDoubleOrNull()
                    if (peso != null && altura != null && altura > 0.0) {
                        resultado = "Tu Imc es: %2f".format(peso / (altura * altura))
                    } else {
                        resultado = "Valores invalidos"
                    }
                }
            ) {
                Text("Calcula tu IMC")
            }

            if (resultado.isNotEmpty()){
                Text(resultado)
            }


        }





    }


    
}
