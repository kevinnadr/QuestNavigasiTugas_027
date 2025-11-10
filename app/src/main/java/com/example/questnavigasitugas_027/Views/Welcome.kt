package com.example.questnavigasitugas_027.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
}