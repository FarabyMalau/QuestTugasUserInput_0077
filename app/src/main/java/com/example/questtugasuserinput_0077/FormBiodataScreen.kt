@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.example.questtugasuserinput_0077

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.remember
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@Composable
fun FormBiodataScreen() {
    var namaDepan by rememberSaveable { mutableStateOf("") }
    var namaBelakang by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var tglLahir by rememberSaveable { mutableStateOf("") }
    var tampilDatePicker by remember { mutableStateOf(false) }
    val bentukForm = RoundedCornerShape(
        topStart = dimensionResource(R.dimen.radius_form),
        topEnd = dimensionResource(R.dimen.radius_form)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            containerColor = colorResource(R.color.putih)
        ) { innerPadding ->
            HeaderGambar(modifier = Modifier.padding(innerPadding))
        }
        if (tampilDatePicker) {
            val datePickerState = rememberDatePickerState()
            val formatTanggal = SimpleDateFormat(
                stringResource(R.string.format_tanggal),
                Locale.getDefault()
            ).apply {
                timeZone = TimeZone.getTimeZone(stringResource(R.string.zona_waktu))
            }

            DatePickerDialog(
                onDismissRequest = { tampilDatePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        datePickerState.selectedDateMillis?.let {
                            tglLahir = formatTanggal.format(Date(it))
                        }
                        tampilDatePicker = false
                    }) {
                        Text(stringResource(R.string.tombol_ok))
                    }
                },
                dismissButton = {
                    TextButton(onClick = { tampilDatePicker = false }) {
                        Text(stringResource(R.string.tombol_batal))
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = dimensionResource(R.dimen.jarak_atas_form),
                    bottom = dimensionResource(R.dimen.jarak_bawah_form)
                )
                .shadow(dimensionResource(R.dimen.elevasi_form), bentukForm)
                .background(colorResource(R.color.putih), bentukForm)
                .padding(dimensionResource(R.dimen.padding_form))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.jarak_sedang))
            ) {
                Text(
                    text = stringResource(R.string.judul_form),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.ungu_judul),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = stringResource(R.string.subjudul_form),
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(R.color.abu_subjudul),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.jarak_sedang))
                ) {
                    FieldBiodata(
                        value = namaDepan,
                        onValueChange = { namaDepan = it },
                        labelRes = R.string.hint_nama_depan,
                        modifier = Modifier.weight(1f)
                    )
                    FieldBiodata(
                        value = namaBelakang,
                        onValueChange = { namaBelakang = it },
                        labelRes = R.string.hint_nama_belakang,
                        modifier = Modifier.weight(1f)
                    )
                    FieldBiodata(
                        value = email,
                        onValueChange = { email = it },
                        labelRes = R.string.hint_email,
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.jarak_sedang))
                    ) {
                        OutlinedTextField(
                            value = tglLahir,
                            onValueChange = {},
                            readOnly = true,
                            singleLine = true,
                            label = { Text(stringResource(R.string.hint_tgl_lahir)) },
                            trailingIcon = {
                                IconButton(onClick = { tampilDatePicker = true }) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = stringResource(R.string.deskripsi_ikon_kalender)
                                    )
                                }
                            },
                            shape = RoundedCornerShape(dimensionResource(R.dimen.radius_field)),
                            modifier = Modifier.weight(1f)
                        )
                        // dropdown Experience ditambahkan di Commit 20
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderGambar(modifier: Modifier = Modifier) {
    val jumlahHalaman = integerResource(R.integer.jumlah_halaman_header)
    val pagerState = rememberPagerState { jumlahHalaman }

    Box(modifier = modifier) {
        HorizontalPager(state = pagerState) {
            Image(
                painter = painterResource(R.drawable.bg_header),
                contentDescription = stringResource(R.string.deskripsi_gambar_header),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.tinggi_header))
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(dimensionResource(R.dimen.jarak_sedang)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.jarak_dot))
        ) {
            repeat(jumlahHalaman) { index ->
                val warna = if (pagerState.currentPage == index)
                    R.color.warna_dot_aktif else R.color.warna_dot_nonaktif
                Box(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.ukuran_dot))
                        .clip(CircleShape)
                        .background(colorResource(warna))
                )
            }
        }
    }
}

@Composable
fun FieldBiodata(
    value: String,
    onValueChange: (String) -> Unit,
    labelRes: Int,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(labelRes)) },
        singleLine = true,
        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_field)),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = modifier
    )
}