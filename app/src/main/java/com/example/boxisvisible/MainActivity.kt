package com.example.boxisvisible

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import com.example.boxisvisible.ui.theme.BoxIsVisibleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxIsVisibleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyBox1()
                }
            }
        }
    }
}


// Desaparece y no vuelve
@Composable
fun Mybox(){
    var isVisible by remember { mutableStateOf(true) }
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable { isVisible = !isVisible }
            .run {
                if (isVisible) this else Modifier.size(20.dp)
            }
    ) {
        // Contenido de tu Box
    }

}
@Composable
fun MyBox1() {
    var isVisible by remember { mutableStateOf(true) }
    Box(
        Modifier
            .fillMaxSize()
            .background(if (isVisible) Color.Red else Color.Transparent)
            .clickable { isVisible = !isVisible }
    ) {
        Text(text = "Esto es una caja(box) que aparece y desaparece según pinches")
    }
}
// Aparece y vuele a aparecer

