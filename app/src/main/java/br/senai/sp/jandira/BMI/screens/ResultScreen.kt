package br.senai.sp.jandira.BMI.screens



import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.BMI.R
import br.senai.sp.jandira.BMI.model.BmiStatus
import br.senai.sp.jandira.BMI.model.bmiCalculator
import br.senai.sp.jandira.BMI.screens.componentes.BmiLevels
import java.util.Locale

@Composable
fun ResultScreen(controleDeNavegacao: NavHostController?) {


    val context = LocalContext.current
    val userFile =  context.getSharedPreferences("user_file", Context.MODE_PRIVATE)

    val userAge = userFile.getInt("user_age", 0)
    val userWeight = userFile.getInt("user_weight", 0)
    val userHeight = userFile.getInt("user_height", 0)


    val resultBmi = bmiCalculator(userWeight, userHeight.toDouble())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(color = 0xFF001477),
                        Color(color = 0xFF4407A8)
                    )
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.result),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(5f),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp),
                        shape = CircleShape,
                        border = BorderStroke(5.dp, color = resultBmi.color),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            val bmiValues = resultBmi.bmiValues.second
                            Text(
                                text = String.format(Locale.getDefault(),"%.1f", bmiValues),
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 35.sp
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "${resultBmi.bmiValues.first}",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                    Card(
                        modifier = Modifier
                            .width(300.dp)
                            .height(80.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.age),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userAge",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                            VerticalDivider()
                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.weight),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userWeight",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                            VerticalDivider()
                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.high),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userHeight",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp) // espaçamento entre os itens
                    )


                    {

                        BmiLevels(
                            leftText = stringResource(R.string.underweight),
                            rightText = "< " + String.format(Locale.getDefault(), "%.1f", 18.5),
                            bulletBackground = colorResource(R.color.light_blue),
                            background = if (resultBmi.status == BmiStatus.UNDER_WEIGHT) colorResource(R.color.light_blue) else Color.Transparent
                        )
                        BmiLevels(
                            leftText = stringResource(R.string.normal),
                            rightText = String.format(Locale.getDefault(), "%.1f", 18.6) + " - " + String.format(Locale.getDefault(), "%.1f", 24.9),
                            bulletBackground = colorResource(R.color.light_green),
                            background = if (resultBmi.status == BmiStatus.NORMAL) colorResource(R.color.light_green) else Color.Transparent
                        )
                        BmiLevels(
                            leftText = stringResource(R.string.overweight),
                            rightText = String.format(Locale.getDefault(), "%.1f", 25.0) + " - " + String.format(Locale.getDefault(), "%.1f", 29.9),
                            bulletBackground = colorResource(R.color.yellow),
                            background = if (resultBmi.status == BmiStatus.OVER_WEIGHT) colorResource(R.color.yellow) else Color.Transparent
                        )
                        BmiLevels(
                            leftText = stringResource(R.string.obesity1),
                            rightText = String.format(Locale.getDefault(), "%.1f", 30.0) + " - " + String.format(Locale.getDefault(), "%.1f", 34.9),
                            bulletBackground = colorResource(R.color.light_orange),
                            background = if (resultBmi.status == BmiStatus.OBESITY_1) colorResource(R.color.light_orange) else Color.Transparent
                        )
                        BmiLevels(
                            leftText = stringResource(R.string.obesity2),
                            rightText = String.format(Locale.getDefault(), "%.1f", 35.0) + " - " + String.format(Locale.getDefault(), "%.1f", 39.9),
                            bulletBackground = colorResource(R.color.dark_orange),
                            background = if (resultBmi.status == BmiStatus.OBESITY_2) colorResource(R.color.dark_orange) else Color.Transparent
                        )
                        BmiLevels(
                            leftText = stringResource(R.string.obesity3),
                            rightText = "> " + String.format(Locale.getDefault(), "%.1f", 40.0),
                            bulletBackground = colorResource(R.color.red),
                            background = if (resultBmi.status == BmiStatus.OBESITY_3) colorResource(R.color.red) else Color.Transparent
                        )
                    }
                    HorizontalDivider(modifier = Modifier
                        .padding(vertical = 30.dp))
                    Button(
                        onClick = {
                            controleDeNavegacao?.navigate("user_data")
                        },
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(color = 0xFF1D0150)
                        )
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxSize(),
                            textAlign = TextAlign.Center,
                            text = stringResource(R.string.newCalculate),
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    ResultScreen(null)
}