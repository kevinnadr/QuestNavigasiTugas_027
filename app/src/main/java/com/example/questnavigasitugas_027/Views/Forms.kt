package com.example.questnavigasitugas_027.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.questnavigasitugas_027.Data
import com.example.questnavigasitugas_027.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    onSmbtBtnClick: (Data) -> Unit,
    onKmblBtnClick: () -> Unit
) {


    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    val listJenisKelamin = listOf(
        stringResource(id = R.string.form_jk_pria),
        stringResource(id = R.string.form_jk_wanita)
    )
    var jenisKelamin by remember { mutableStateOf<String?>(null) }

    val listStatus = listOf(
        stringResource(id = R.string.form_status_1),
        stringResource(id = R.string.form_status_2),
        stringResource(id = R.string.form_status_3),
        stringResource(id = R.string.form_status_4)
    )
    var statusPerkawinan by remember { mutableStateOf<String?>(null) }
    var isDropdownExpanded by remember { mutableStateOf(false) }


    var showDataKosongAlert by remember { mutableStateOf(false) }
    var showKonfirmasiAlert by remember { mutableStateOf(false) }
    var dataToConfirm by remember { mutableStateOf<Data?>(null) }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.black),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(id = R.string.form_judul),
            style = MaterialTheme.typography.headlineMedium,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
        )
    }
}