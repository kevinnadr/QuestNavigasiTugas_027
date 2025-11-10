package com.example.questnavigasitugas_027.Views

import android.R.attr.data
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.unit.dp
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

        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 10.dp, bottom = 40.dp)

        ) {
            Column(
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 40.dp)
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text(stringResource(id = R.string.form_label_nama)) },
                    placeholder = { Text(stringResource(id = R.string.form_placeholder_nama)) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))


                Text(
                    text = stringResource(id = R.string.form_label_jk),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    listJenisKelamin.forEach { jk ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = (jenisKelamin == jk),
                                    onClick = { jenisKelamin = jk }
                                )
                                .padding(end = dimensionResource(id = R.dimen.padding_medium))
                        ) {
                            RadioButton(
                                selected = (jenisKelamin == jk),
                                onClick = { jenisKelamin = jk }
                            )
                            Text(text = jk)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))


                ExposedDropdownMenuBox(
                    expanded = isDropdownExpanded,
                    onExpandedChange = { isDropdownExpanded = it },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = statusPerkawinan ?: "Pilih status kawin",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text(stringResource(id = R.string.form_label_status)) },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDropdownExpanded)
                        },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = isDropdownExpanded,
                        onDismissRequest = { isDropdownExpanded = false }
                    ) {
                        listStatus.forEach { status ->
                            DropdownMenuItem(
                                text = { Text(status) },
                                onClick = {
                                    statusPerkawinan = status
                                    isDropdownExpanded = false
                                }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
}