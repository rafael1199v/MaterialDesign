package com.example.materialdesigndemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialdesigndemo.ui.theme.MaterialDesignDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialDesignDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ButtonExample(
                            text = "Boton",
                            modifier = Modifier,
                            action = { println("Click") }
                        )

                        CardExample(
                            title = "Title",
                            content = "Content",
                            modifier = Modifier.width(100.dp)
                                .height(100.dp)
                        )

                        NavigationBarExample(
                            modifier = Modifier
                        )

                        ScrollListExample(
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonExample(
    text: String,
    modifier: Modifier = Modifier,
    action: () -> Unit
) {
    FilledTonalButton (
        modifier = modifier,
        onClick = action
    ) {
        Text(text = text)
    }
}

@Composable
fun CardExample(
    modifier: Modifier = Modifier,
    title: String,
    content: String
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title)
            Text(text = content)
        }
    }
}

@Composable
fun NavigationBarExample(
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = true,
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            },
            label = {
                Text(text = "Home")
            },
            onClick = {
                println("Home")
            }
        )
        NavigationBarItem(
            selected = false,
            icon = {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Task")
            },
            label = {
                Text(text = "Tasks")
            },
            onClick = {
                println("Tasks")
            }
        )
    }
}

@Composable
fun ScrollListExample(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(50) { index ->
            Button(
                onClick = {},
            ) {
                Text(
                    text = "Button"
                )
            }
        }
    }
}

