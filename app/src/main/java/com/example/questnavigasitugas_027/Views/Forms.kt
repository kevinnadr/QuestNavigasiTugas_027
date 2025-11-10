package com.example.questnavigasitugas_027.Views

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
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
}