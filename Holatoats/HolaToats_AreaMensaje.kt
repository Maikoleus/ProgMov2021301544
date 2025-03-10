package com.example.holatoats

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { UIPrincipal() }
    }
}

@Composable
fun UIPrincipal() {
    val contexto = LocalContext.current
    var cadTxtnombre by rememberSaveable { mutableStateOf("") }
    var cadlblMensaje by rememberSaveable { mutableStateOf("AREA DEL MENSAJE") }

    fun btnSakudar_click(){
        cadlblMensaje = "HOLA $cadTxtnombre"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Nombre:", style = MaterialTheme.typography.bodyLarge)

        OutlinedTextField(
            value = cadTxtnombre,
            onValueChange = { cadTxtnombre = it },
            label = { Text("¿Como te llamas?") },
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        Button(
            onClick = { btnSakudar_click()},
            modifier = Modifier.padding(top = 16.dp)

        ) {
            Text("Saludar!")
        }
        Text(cadlblMensaje)
    }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion() {
    UIPrincipal()
}