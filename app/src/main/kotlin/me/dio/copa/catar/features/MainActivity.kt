package me.dio.copa.catar.features

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.dio.copa.catar.R
import me.dio.copa.catar.ui.theme.Copa2022Theme
import me.dio.copa.catar.ui.theme.Shapes

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Copa2022Theme {

                val state by viewModel.state.collectAsState()
                Log.d("State result", state.toString())
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.secondary,
                            title = {
                                Text("Partidas")
                            }
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                ) { paddingValues ->
                    LazyColumn(
                        contentPadding = PaddingValues(4.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .background(
                                color = MaterialTheme.colors.primary
                            ),


                        ) {
                        items(100) {
                            val contador = it + 1
                            CardGames(contador)
                        }
                    }
                }
            }
        }
    }

}


@Composable
fun CardGames(number: Int) {
    Card(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.secondary,
        shape = Shapes.medium,
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)


        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.escudo_cbf),
                    contentDescription = "Escudo da seleção anfitriã",
                    modifier = Modifier
                        .size(48.dp)
                        .border(BorderStroke(1.dp, MaterialTheme.colors.secondary))
                        .clip(CircleShape),
                    contentScale = ContentScale.Fit

                )
                Text(
                    text = "BRA",
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold

                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "VS",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "00:00",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "Arena Pernambuco",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Column {
                Image(
                    painter = painterResource(id = R.drawable.escudo_din),
                    contentDescription = "Escudo da seleção visitante",
                    modifier = Modifier.size(54.dp),
                    contentScale = ContentScale.Fit

                )
                Text(
                    text = "DIN",
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold

                )
            }

        }
        /* Row(
             verticalAlignment = Alignment.Bottom,
             horizontalArrangement = Arrangement.Start
         ) {
             Text(
                 text = "Fase de Grupos $number",
                 modifier = Modifier.padding(16.dp),
                 color = MaterialTheme.colors.secondary,
                 fontSize = 8.sp

             )
         }*/

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    CardGames(1)
}
/*@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    Copa2022Theme {
        Greeting("Android")
    }
}*/
