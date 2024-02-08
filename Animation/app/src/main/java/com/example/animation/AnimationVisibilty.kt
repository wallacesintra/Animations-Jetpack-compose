package com.example.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationVisibility(
    modifier: Modifier = Modifier
){
//    AnimatedVisibility - animates appearance and disappearance of its content.
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var visible by remember{
            mutableStateOf(false)
        }
        Card(
            modifier = Modifier
                .padding(10.dp)
                .size(100.dp)
                .fillMaxWidth()
                .clickable(
                    onClick = { visible = !visible }
                )
//                .background(Color.Red)

        ) {
            Text(
//                text = "Make Visible",
                text = if (!visible) "Make Visible" else "disappear",
                modifier = Modifier
                    .padding(10.dp)
                )
        }

        AnimatedVisibility(
            visible = visible,
//            enter = slideInHorizontally() + fadeIn(),
//            exit = slideOutHorizontally() + fadeOut()
        ) {
            Card1(
                modifier = Modifier.animateEnterExit(
////                    enter = slideInHorizontally(),
//                    enter= scaleIn(),
//                    exit = slideOutHorizontally()
                )
            )
        }
    }

}

@Composable
fun Card1(
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)

        ) {
            Text(text = "Its visible")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAnimation(){
    Card1()
}