package com.example.intent

import android.content.Context
import android.content.Intent
import android.graphics.Paint.Align
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intent.ui.theme.IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Greeting("Login Activity")
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$name!",
            modifier = modifier
        )
        LoginPage()
    }
}

@Composable
fun ButtonIntent() {
    var context = LocalContext.current
    var intent = remember {
        Intent(Intent.ACTION_VIEW,Uri.parse("https://gemini.google.com/"))
    }
    Box(modifier = Modifier
        .clip(CircleShape)
        .padding(horizontal = 20.dp, vertical = 5.dp)
        .clickable { context.startActivity(intent) }
        .background(Color.Black)){

    Text(text = "Implicit", color = Color.White, modifier = Modifier.padding(16.dp))
    }
}
@Composable
fun ButtonEIntent(email: String, password: String) {
    var context = LocalContext.current
    var intent = remember {
        Intent(context, Activity2::class.java).apply {  putExtra("EMAIL", email) }
    }
    Text(
        text = "Login",
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .clickable {
                if (email == "admin" && password == "admin") {
                    intent.putExtra("EMAIL", email)
                    context.startActivity(intent)
                } else {
                    Toast
                        .makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            .background(Color.Black)
            .padding(16.dp)
    )
}



@Composable
fun LoginPage() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Image(painter = painterResource(id = R.drawable.profile), contentDescription ="profile" )

    TextField(
        modifier =Modifier.fillMaxWidth(),
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") }
    )
    TextField(
        modifier =Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { password = it },
        label = { Text("password") },
        visualTransformation = PasswordVisualTransformation()
    )
    ButtonEIntent(email,password)

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntentTheme {
        Greeting("Android")
    }
}