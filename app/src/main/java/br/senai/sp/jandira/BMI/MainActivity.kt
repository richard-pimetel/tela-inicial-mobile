package br.senai.sp.jandira.BMI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.BMI.screens.HomeScreens
import br.senai.sp.jandira.BMI.screens.ResultScreen
import br.senai.sp.jandira.BMI.ui.theme.BMITheme
import br.senai.sp.jandira.BMI.userDataScreens.userDataScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMITheme {
                val controleDeNavegacao = rememberNavController()
                NavHost(
                    navController = controleDeNavegacao,
                    startDestination = "home"

                ){
                    composable(route = "home"){ HomeScreens(controleDeNavegacao)}
                    composable(route = "user_data"){ userDataScreens(controleDeNavegacao) }
                    composable(route = "bmi_result"){ ResultScreen(controleDeNavegacao) }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMITheme {
        Greeting("Android")
    }
}