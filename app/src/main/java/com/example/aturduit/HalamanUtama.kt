package com.example.aturduit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HalamanUtama {
    @Composable
    fun MainScreen (){
        Column(
            modifier =  Modifier
                .padding(10.dp)
        ) {
            Header()
            // Grafik
            Text(
                text = "Jumlah uang anda : 0",
            ) //Saldo anda
            Row (
                modifier = Modifier
                    .padding(3.dp)
            ){
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Tambah Pemasukan")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Tambah Pengeluaran")
                }
            }

            RiwayatList(riwayat)
        }
    }

    @Composable
    fun Header(
    ) {
        Column(
            modifier = Modifier.padding(2.dp)
        ) {
            Text(
                text = "Login sebagai Nama",
                fontSize = 24.sp
            )
        }
    }

    @Composable
    fun RiwayatList(riwayat: List<Riwayat>) {
        if (riwayat.isNotEmpty()) {
            LazyColumn {
                items(riwayat) { riwayatItem ->
                    RiwayatCard(riwayatItem)
                }
            }
        } else {
            Box(contentAlignment = Alignment.Center) {
                Text("No people to greet :(")
            }
        }
    }

    @Composable
    fun RiwayatCard(
        riwayatItem: Riwayat
    ){

        Card (
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column (modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Pendapatan ${riwayatItem.jumlah}",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Tanggal ${riwayatItem.tanggal}",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontStyle = FontStyle.Italic
                        )
                    )
                }
            }
        }
    }
    data class Riwayat(
        val jumlah: Int,
        val tanggal: String
    )

    val riwayat = listOf(
        Riwayat(jumlah = 100000, tanggal = "2023-11-27"),
        Riwayat(jumlah = 200000, tanggal = "2023-11-28"),
        Riwayat(jumlah = 200000, tanggal = "2023-11-28"),
        Riwayat(jumlah = 200000, tanggal = "2023-11-28"),
        Riwayat(jumlah = 200000, tanggal = "2023-11-28"),
        Riwayat(jumlah = 300000, tanggal = "2023-11-29")
    )
}