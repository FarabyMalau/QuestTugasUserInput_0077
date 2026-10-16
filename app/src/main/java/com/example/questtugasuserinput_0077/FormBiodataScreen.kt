@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.example.questtugasuserinput_0077

@Composable
fun FormBiodataScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            containerColor = colorResource(R.color.putih)
        ) { innerPadding ->
            HeaderGambar(modifier = Modifier.padding(innerPadding))
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