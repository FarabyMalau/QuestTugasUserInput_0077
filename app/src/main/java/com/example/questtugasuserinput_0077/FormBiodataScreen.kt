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