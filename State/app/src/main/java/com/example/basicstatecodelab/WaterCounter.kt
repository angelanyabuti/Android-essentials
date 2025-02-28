package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(16.dp)) {
        //changes to count are now tracked by compose
        var count by remember { mutableStateOf(0) }
        if (count > 0) {
            //This text is present when the button is clicked and count is greater than 0
            //And absent otherwise
            Text(
                text = "You've had $count glasses.",
            )
        }
            Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10)  {
                Text("Add one")

            }

    }
}