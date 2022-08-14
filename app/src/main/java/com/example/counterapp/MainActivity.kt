package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun AppBar(title: String) {
    Box {
        TopAppBar (title = {Text(title)})
    }

}


@Composable
fun HomeScreen(){

    val count = remember{ mutableStateOf(value = 0)}
    CounterAppTheme {
        Scaffold(
            topBar = { AppBar("Counter")},
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { count.value = count.value+ 1},
                    content = { Icon(Icons.Rounded.Add, "Add to Counter")}
                )
            }
        ) {
           Column(
               modifier = Modifier.fillMaxSize(),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
           ) {
               Text("Click the FAB button to increment its value")
               Text("${count.value}", fontSize = 20.sp)
           }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen()
}







