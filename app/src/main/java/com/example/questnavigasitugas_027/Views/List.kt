package com.example.questnavigasitugas_027.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        modifier = Modifier.padding(start = 77.dp),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.LightGray,
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
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.black),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 1f
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(start = 15.dp, end = 15.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
                ) {
                    items(listData) { data ->
                        dataCard(data = data)
                    }
                }
            }
        }
    }
}

@Composable
fun InfoItem(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.padding(top = 6.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}


@Composable
fun dataCard(data: Data) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.card_elevation)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
        ) {
            Column(modifier = Modifier.weight(1f).padding(top = 20.dp).padding(start = 25.dp)) {
                InfoItem(
                    label = stringResource(id = R.string.list_label_nama),
                    value = data.nama,
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
                InfoItem(
                    label = stringResource(id = R.string.list_label_status),
                    value = data.statusPerkawinan
                )
            }
            Spacer(modifier = Modifier.padding(bottom = 100.dp, top = 20.dp))
            Column(modifier = Modifier.weight(1f).padding(top = 20.dp).padding(start = 30.dp)) {
                InfoItem(
                    label = stringResource(id = R.string.list_label_jk),
                    value = data.jenisKelamin,
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
                InfoItem(
                    label = stringResource(id = R.string.list_label_alamat),
                    value = data.alamat
                )
            }
        }
    }
}