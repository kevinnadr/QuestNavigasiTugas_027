package com.example.questnavigasitugas_027

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class Data(
    val nama: String,
    val jenisKelamin: String,
    val statusPerkawinan: String,
    val alamat: String
)

data class DataUiState(
    val listData: List<Data> = emptyList()
)
private fun listData(): List<Data> {
    return listOf(
        Data(
            nama = "Asroni Sukirman",
            jenisKelamin = "Laki-laki",
            statusPerkawinan = "DUDA",
            alamat = "Sleman"
        ),
        Data(
            nama = "Aprilia Kumianti",
            jenisKelamin = "Perempuan",
            statusPerkawinan = "TIDAK KAWIN",
            alamat = "Bantul"
        ),
        Data(
            nama = "Haris Setyawan",
            jenisKelamin = "Laki-laki",
            statusPerkawinan = "KAWIN",
            alamat = "Jogja"
        ),
        Data(
            nama = "A Sukirman",
            jenisKelamin = "Laki-laki",
            statusPerkawinan = "DUDA",
            alamat = "Sleman"
        ),
        Data(
            nama = "A Kumianti",
            jenisKelamin = "Perempuan",
            statusPerkawinan = "TIDAK KAWIN",
            alamat = "Bantul"
        ),
        Data(
            nama = "A Setyawan",
            jenisKelamin = "Laki-laki",
            statusPerkawinan = "KAWIN",
            alamat = "Jogja"
        )
    )
}

class DataView : ViewModel() {

    private val _uiState = MutableStateFlow(DataUiState(listData = listData()))
    val uiState: StateFlow<DataUiState> = _uiState.asStateFlow()

    fun addData(Data: Data) {
        _uiState.update { currentState ->
            currentState.copy(
                listData = currentState.listData + Data
            )
        }
    }
}