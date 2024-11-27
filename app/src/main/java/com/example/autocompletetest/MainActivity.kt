package com.example.autocompletetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.autocompletetest.ui.theme.AutocompleteTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AutocompleteTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TextAreaInputField(
                        "Enter text",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextAreaInputField(
    label: String,
    modifier: Modifier = Modifier
) {
    var uiStateWithSelection by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        modifier = modifier.fillMaxSize(),
        value = uiStateWithSelection,
        onValueChange = {
            uiStateWithSelection = it
        },
        label = {
            Text(text = label)
        },
        singleLine = false
    )
}

@Preview(showBackground = true)
@Composable
fun TextAreaInputFieldPreview() {
    AutocompleteTestTheme {
        TextAreaInputField("TextAreaInputField")
    }
}