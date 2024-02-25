package com.example.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.intent.ui.theme.IntentTheme

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val email = intent.getStringExtra("EMAIL")

            IntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box (
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Greeting2(email)
                    }

                }
            }
        }
    }
}

@Composable
fun ButIntent() {
    var context = LocalContext.current
    var intent = remember {
        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/aaron-joju/"))
    }
    Box(modifier = Modifier.fillMaxWidth()
        .clip(CircleShape)
        .padding(horizontal = 20.dp, vertical = 5.dp)
        .clickable { context.startActivity(intent) }
        .background(Color.Black)){

        Text(text = "Linkedin", color = Color.White, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun Greeting2(name: String?, modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        ButIntent()
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    IntentTheme {
        Greeting2("Android")
    }
}