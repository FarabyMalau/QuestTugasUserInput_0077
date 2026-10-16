@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.example.questtugasuserinput_0077

@Composable
fun FormBiodataScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            containerColor = colorResource(R.color.putih)
        ) { innerPadding ->
            Box(modifier = Modifier.fillMaxSize().padding(innerPadding))
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
    }
}