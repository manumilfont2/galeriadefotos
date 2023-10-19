package com.example.galeriadefotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galeriadefotos.ui.theme.GaleriadefotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriadefotosTheme {



            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun AppGaleriaDeFotos() {
    var galeria by remember { mutableStateOf(1) }
    val imagem = when (galeria) {
        1 -> R.drawable.imagem17
        2 -> R.drawable.imagem2
        else -> R.drawable.imagem16
    }
    Box() {


        Image(
            painter = painterResource(id = R.drawable.fundo4),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            alpha = 0.5F
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imagem),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        end = 15.dp,
                        bottom = 40.dp
                    )
                    .size(470.dp),
                contentScale = ContentScale.Crop,


                )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        if (galeria > 1) {
                            galeria--
                        } else {
                            galeria = 3
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RoundedCornerShape(7.dp)
                ) {
                    Text(
                        text = "<- Anterior",
                        fontFamily = FontFamily.Monospace
                    )
                }
                Button(
                    onClick = {
                        if (galeria < 3) {
                            galeria++
                        } else {
                            galeria = 1
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape= RoundedCornerShape(7.dp)
                ) {
                    Text(
                        text = "Próximo ->",
                        fontFamily = FontFamily.Monospace
                    )
                }
            }
        }
    }
}



