package com.example.animation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ValueChange(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        var isRounded by remember{
            mutableStateOf(false)
        }

        val borderRadius by animateIntAsState(
            targetValue = if (isRounded) 100 else 0,
            label = "border radius",
            animationSpec = tween(
                durationMillis = 3000,
                delayMillis = 200
            )
//            animationSpec = spring(
//                dampingRatio = Spring.DampingRatioMediumBouncy,
//                stiffness = Spring.StiffnessLow
//            )
        )
        Card (
            modifier = Modifier
                .clickable(
                    onClick = {isRounded = !isRounded}
                )
                .padding(10.dp)
                .size(150.dp)
                .clip(RoundedCornerShape(borderRadius))


        ){
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ){
                Text(text = "Make Circle")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ValueChangePreview(){
    ValueChange()
}