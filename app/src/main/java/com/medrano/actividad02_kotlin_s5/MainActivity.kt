package com.medrano.actividad02_kotlin_s5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.medrano.actividad02_kotlin_s5.ui.theme.Actividad02_Kotlin_S5Theme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad02_Kotlin_S5Theme {
                comparadorContadores()
            }
        }
    }
}

@Composable
fun comparadorContadores() {
    var contEphemeral by remember { mutableStateOf(0) }
    var contPersistente by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Comparando estados",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6200EA),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        //Contador con remenber
        Text("Ephemeral (remember): $contEphemeral")
        Button(
            onClick = {
                contEphemeral++
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("+1")
        }

        Spacer(modifier = Modifier.height(24.dp))

        //Contador con rememberSaveable
        Text("Persistente (rememberSaveable): $contPersistente")
        Button(
            onClick = {
                contPersistente++
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("+1")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Rota la pantalla y observa qué contador se reinicia.",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth()

        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    comparadorContadores()
}