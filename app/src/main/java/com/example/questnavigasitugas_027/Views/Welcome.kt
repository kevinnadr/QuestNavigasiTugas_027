package com.example.questnavigasitugas_027.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.questnavigasitugas_027.R

@Composable
fun WelcomeScreen(
    onMskBtnClick: () -> Unit
){
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.redcanvas),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 140.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){}
}