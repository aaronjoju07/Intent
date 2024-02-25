# Intent-Program

Welcome to Intent-Program, an Android Kotlin Jetpack Compose application showcasing the implementation of explicit and implicit intents. This app is built using the modern Jetpack Compose framework, featuring a login page, a profile page, and seamless integration with a LinkedIn profile.
## Features

1. **Login Page:**
   - Users can input their credentials to access the main features of the application.

2. **Profile Page:**
   - Upon successful login, users are directed to a profile page displaying personalized details.

3. **Explicit Intent:**
   - The app utilizes explicit intents to navigate between the login and profile pages, showcasing the explicit triggering of specific components.

4. **Implicit Intent:**
   - Integration with the LinkedIn profile using implicit intent, allowing users to access external content beyond the app's scope.

5. **LinkedIn Profile Integration:**
   - Users can seamlessly navigate to the LinkedIn profile associated with the app through implicit intent.

## Getting Started

Follow these steps to get the project up and running on your local machine.

### Prerequisites

- Android Studio
- Android SDK
- Emulator or Android device

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/aaronjoju07/Intent.git
   ```

2. Open the project in Android Studio.

3. Run the app on an emulator or Android device.

## Explicit Intent - MainActivity
```bash
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
   ```
## Calling and Passing Values - Activity2
```bash
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
```
## Implicit Intent - Activity2
```bash
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

   ```
## Usage

1. Launch the app on your Android device or emulator.

2. Navigate through the login and profile pages using explicit intents.

3. Experience the seamless integration with LinkedIn profiles using implicit intents.

## Contributing

Contributions are welcome! Feel free to open issues, submit pull requests, or suggest new features.
