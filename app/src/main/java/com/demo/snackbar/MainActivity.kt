package com.demo.snackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.snackbar.ui.theme.SnackBarTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scaffoldState = rememberScaffoldState()
                    Scaffold(
                        scaffoldState = scaffoldState
                    ) {
                        CreateSnackBar(scaffoldState = scaffoldState)
                    }
                }
            }
        }
    }
}

@Composable
fun CreateSnackBar(scaffoldState: ScaffoldState){
    
    val scope = rememberCoroutineScope()
    
    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(vertical = 20.dp),
    horizontalArrangement = Arrangement.Center){
        Button(onClick = { 
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Hey, How are you?")
            }
        }) {
            Text(text = "Show SnackBar")
            
        }
    }
}
