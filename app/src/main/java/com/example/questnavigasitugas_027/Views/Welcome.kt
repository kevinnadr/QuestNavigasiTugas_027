package com.example.questnavigasitugas_027.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_027.R

@Composable
fun WelcomeScreen(
    onMskBtnClick: () -> Unit
){
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.black),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 140.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Selamat Datang",
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.LightGray,
        )
        Spacer(modifier = Modifier.padding(top = 50.dp))

        Image(
            painter = painterResource(id = R.drawable.logo1),
            contentDescription = stringResource(id = R.string.welcome_logo_desc),
            modifier = Modifier.size(300.dp) ,
        )
        Spacer(modifier = Modifier.padding(bottom = 30.dp))

        Text(
            text = stringResource(id = R.string.welcome_nama_mahasiswa),
            fontSize = 24.sp,
            color = Color.LightGray,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))

        Text(
            text = stringResource(id = R.string.welcome_nim_mahasiswa),
            fontSize = 22.sp,
            color = Color.LightGray,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(bottom = 40.dp))
        Button(
            onClick = onMskBtnClick,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding( start = 55.dp, end = 55.dp)
                .height(height = 50.dp),
        ) {
            Text(text = stringResource(id = R.string.welcome_masuk))
        }
    }
}
