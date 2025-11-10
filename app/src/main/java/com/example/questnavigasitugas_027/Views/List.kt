package com.example.questnavigasitugas_027.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.questnavigasitugas_027.Data
import com.example.questnavigasitugas_027.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    listData: List<Data>,
    onBrndBtnClick: () -> Unit,
    onFormsBtnClick: () -> Unit
){
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = {
                    Text(
                        text = "LIST DATA DIRI",
                        modifier = Modifier.padding(start = 107.dp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Transparent,
                )
            )
        },
        bottomBar ={
            BottomAppBar(
                containerColor = Color.Transparent,
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Button(onClick = onBrndBtnClick) {
                        Text(text = stringResource(id = R.string.list_beranda))
                    }
                    Button(onClick = onFormsBtnClick) {
                        Text(text = stringResource(id = R.string.list_formulir))
                    }
                }
            }
        }
    ) {}
}