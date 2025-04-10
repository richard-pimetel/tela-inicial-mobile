package br.senai.sp.jandira.BMI.screens.componentes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.BMI.model.Bmi

@Composable
fun BmiLevels(modifier: Modifier = Modifier) {
    Row {
        Card (){
            modifier = Modifier
                .size(20.dp),
            shape = CircleShape
        }
        Card (){
            Row {
                Text(text = "Left text")
                Text(text = "Right text")
            }
        }
    }
}