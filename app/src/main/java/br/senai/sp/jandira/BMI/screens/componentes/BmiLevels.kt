package br.senai.sp.jandira.BMI.screens.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.BMI.R

@Composable
fun BmiLevels(leftText: String = "", rightText: String = "", background: Color = Color.Transparent,
              bulletBackground: Color = (colorResource(R.color.light_blue))){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Card(
            modifier = Modifier
                .size(20.dp),
            shape = CircleShape,
            colors = CardDefaults.cardColors(
                containerColor = bulletBackground
            )
        ) {  }
        Spacer(modifier = Modifier.width(8.dp))
        Card(
            modifier = Modifier
                .fillMaxSize()
                .height(20.dp),
            colors = CardDefaults.cardColors(background),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row (modifier = Modifier.fillMaxWidth()
                .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(leftText)
                Text(rightText)
            }
        }

    }
}

@Preview
@Composable
private fun BmiLevelsPreview(){
    BmiLevels()
}