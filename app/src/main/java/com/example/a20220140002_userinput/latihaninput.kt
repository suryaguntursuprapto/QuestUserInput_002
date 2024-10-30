package com.example.a20220140002_userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun latihaninput(modifier: Modifier = Modifier)
{
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var emailsv by remember { mutableStateOf("") }
    var notelponsv by remember { mutableStateOf("") }
    var alamatsv by remember { mutableStateOf("") }
    var memilihJKsv by remember { mutableStateOf("") }
    val listJK:List<String> = listOf("Laki-Laki", "Perempuan")

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("Biodata", fontSize = 20.sp, fontWeight = FontWeight.Bold,)
        Spacer(modifier = Modifier.padding(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = {Text("Nama")},
            placeholder = { Text("Masukkan Nama Anda") }
        )


        Row {
            listJK.forEach{item->
                Row (modifier = Modifier.selectable(
                    selected = memilihJK == item,
                    onClick = {memilihJK = item}
                ), verticalAlignment = Alignment.CenterVertically)
                {
                    RadioButton(
                        selected = memilihJK == item,
                        onClick = {
                            memilihJK = item
                        }
                    )
                    Text(item)
                }
            }
        }

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = {Text("Email")},
            placeholder = { Text("Masukkan Email Anda") }
        )

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = notelpon,
            onValueChange = {notelpon = it},
            label = {Text("No HP")},
            placeholder = { Text("Masukkan No HP Anda") }
        )

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = {Text("Alamat")},
            placeholder = { Text("Masukkan Alamat Anda") }
        )

        Button (onClick = {
                namasv = nama
                memilihJKsv = memilihJK
                notelponsv = notelpon
                emailsv = email
                alamatsv = alamat
        }) {
            Text("Submit")
        }

        ElevatedCard(colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier.fillMaxWidth(),
        ) {
            DetailSurat(judul = "Nama", isinya = namasv)
            DetailSurat(judul = "Gender", isinya = memilihJKsv)
            DetailSurat(judul = "Email", isinya = email)
            DetailSurat(judul = "No HP", isinya = notelponsv)
            DetailSurat(judul = "Alamat", isinya = alamatsv)
        }
    }
}

@Composable
fun DetailSurat(
    judul: String, isinya: String
){
    Column (
        modifier = Modifier.fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Row (modifier = Modifier.fillMaxWidth().padding(top = 2.dp)){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.8f))
            Text(text = isinya,
                modifier = Modifier.weight(2f))
        }
    }
}

