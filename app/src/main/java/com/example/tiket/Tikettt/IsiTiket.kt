package com.example.tiket.Tikettt

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IsiTiket() {

    // Mengambil Context seperti pada modul
    val context = LocalContext.current
    val hargaTiket = 25000
    var jumlahTiket by remember {
        mutableIntStateOf(1)
    }

    val totalBayar = hargaTiket * jumlahTiket

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Pemesanan Tiket",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Pesan tiket dengan mudah!",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Harga Tiket
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Harga Tiket",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = formatRupiah(hargaTiket),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = "per tiket",
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Jumlah Tiket
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Jumlah Tiket",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(
                        onClick = {
                            if (jumlahTiket > 1) {
                                jumlahTiket--
                            }
                        }
                    ) {
                        Text(
                            text = "−",
                            fontSize = 24.sp
                        )
                    }

                    Text(
                        text = jumlahTiket.toString(),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Button(
                        onClick = {
                            jumlahTiket++
                        }
                    ) {
                        Text(
                            text = "+",
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Total Bayar
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Total Bayar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = formatRupiah(totalBayar),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // Reset
        Button(
            onClick = {
                jumlahTiket = 1

                Toast.makeText(
                    context,
                    "Jumlah tiket direset",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "RESET",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun formatRupiah(nominal: Int): String {
    return "Rp" + String.format("%,d", nominal)
        .replace(',', '.')
}