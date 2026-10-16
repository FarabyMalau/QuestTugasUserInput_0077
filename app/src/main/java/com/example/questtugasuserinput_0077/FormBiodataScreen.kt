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

@Composable
fun FormBiodataScreen() {
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
                // isi form ditambahkan di commit berikutnya
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