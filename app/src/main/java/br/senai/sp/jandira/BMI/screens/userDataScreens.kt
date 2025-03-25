package br.senai.sp.jandira.BMI.userDataScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance

import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.BMI.R

@Composable
fun userDataScreens(controleDeNavegacao: NavHostController?) {
    var inputAge = remember {
        mutableStateOf(value = "")
    }

    var inputWeight = remember {
        mutableStateOf(value = "")
    }

    var inputHeight = remember {
        mutableStateOf(value = "")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(Color(0xFF0E2AAD), Color(0xFF000000))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Hi !",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 46.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(800.dp)
                    .padding(bottom = 0.dp),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(130.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    2.dp, Brush.linearGradient(
                                        listOf(Color(0xFF002CFF), Color(0xFF0035FD))
                                    )
                                ),
                                elevation = CardDefaults.elevatedCardElevation(2.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.homem),
                                    contentDescription = stringResource(id = R.string.logo),
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp, 5.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(
                                    0xFF0818A4
                                )
                                )
                            ) {
                                Text(text = stringResource(R.string.male), fontSize = 16.sp, color = Color.White)
                            }
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(130.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    2.dp, Brush.linearGradient(
                                        listOf(Color(0xFF002CFF), Color(0xFF0035FD))
                                    )
                                ),
                                elevation = CardDefaults.elevatedCardElevation(2.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.mulher),
                                    contentDescription = stringResource(id = R.string.logo),
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp, 5.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(
                                    0xFF082FA4
                                )
                                )
                            ) {
                                Text(text = stringResource(R.string.female), fontSize = 16.sp, color = Color.White)
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .padding(8.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedTextField(
                            value = inputAge.value,
                            onValueChange = {nome ->
                                inputAge.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            shape = RoundedCornerShape(12.dp),
                            label = { Text(stringResource(R.string.age)) },
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.Numbers, contentDescription = "Ícone de Idade")
                            },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )

                        OutlinedTextField(
                            value = inputWeight.value,
                            onValueChange = {nome ->
                                inputWeight.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            shape = RoundedCornerShape(12.dp),
                            label = { Text(stringResource(R.string.weight)) },
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.Balance, contentDescription = "Ícone de Peso")
                            },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )

                        OutlinedTextField(
                            value = inputHeight.value,
                            onValueChange = {nome ->
                                inputHeight.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp,),
                            shape = RoundedCornerShape(12.dp),
                            label = { Text(stringResource(R.string.height)) },
                            leadingIcon = {
                                Icon(imageVector = Icons.Default.Height, contentDescription = "Ícone de altura")
                            },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )
                        )
                    }

                    Button(
                        onClick = {
                            controleDeNavegacao?.navigate("bmi_result")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding( 12.dp, 5.dp),
                        border = BorderStroke(
                            5.dp, Brush.linearGradient(
                                listOf(Color(0xFF080BA4), Color(0xFF8898FF))
                            )
                        ),
                        elevation = ButtonDefaults.buttonElevation(5.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF0818A4)),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(text = stringResource(R.string.buttonCalculate), fontSize = 25.sp)
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun userDataScreensPreview() {
    userDataScreens(null)
}

