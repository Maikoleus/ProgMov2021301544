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
    var cadTxtlblOp1 by remember { mutableStateOf("") }
    var cadTxtlblOp2 by remember { mutableStateOf("") }
    var cadTxtlblOp3 by remember { mutableStateOf("") }

    fun btnLimpiar_click(){
        cadTxtlblOp1=""
        cadTxtlblOp2=""
        cadTxtlblOp3=""
    }
    fun btnSumae_click() {
        val Op1 = cadTxtlblOp1.toIntOrNull()?:0
        val Op2 = cadTxtlblOp2.toIntOrNull()?:0
        cadTxtlblOp3 = (Op1+Op2).toString()
    }

 Column( Modifier.fillMaxSize().padding(16.dp), Arrangement.Top, Alignment.CenterHorizontally){
     Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround){
         Text("Op1", Modifier.weight(1f))
         Text("Op2", Modifier.weight(1f))
         Text("Op3", Modifier.weight(1f))

     }
     Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround){
         TextField(value = cadTxtlblOp1, onValueChange = {cadTxtlblOp1 = it}, Modifier.weight(1f))
         Text("+", Modifier.weight(1f))

         TextField(value = cadTxtlblOp2, onValueChange = {cadTxtlblOp2 = it}, Modifier.weight(1f))
         Text("=", Modifier.weight(1f))

         TextField(value = cadTxtlblOp3, onValueChange = {cadTxtlblOp3 = it}, Modifier.weight(1f))
     }
     Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround){
     Button(onClick = {btnLimpiar_click()}, Modifier.weight(1.5f)) {
         Text("Limpiar")
     }
         Button(onClick = {btnSumae_click()}, Modifier.weight(1.5f)) {
             Text("Sumar")
         }

     }
 }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion() {
    UIPrincipal()
}