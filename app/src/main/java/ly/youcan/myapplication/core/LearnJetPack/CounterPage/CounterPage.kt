package ly.youcan.myapplication.core.LearnJetPack.CounterPage

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun conterPage(){
    var counter  by remember {
        mutableStateOf(0)
    }
    Scaffold{
        it.calculateTopPadding()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp, 50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            Spacer(modifier = Modifier.height(100.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {


                Text(text = counter.toString(),fontSize = 50.sp, color = Color.Blue)
            }
            Spacer(modifier = Modifier.height(100.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Button(onClick = {


                    counter++
                    },modifier = Modifier

                    .size(120.dp, 80.dp)) {
                    Text(text = "+",fontSize = 30.sp)

                    Log.d("testbtn", counter.toString())
                }
                Button(onClick = {
                    counter--
                    Log.d("testbtn", counter.toString())
                                 },modifier = Modifier

                    .size(120.dp, 80.dp)) {
                    Text(text = "-",fontSize = 30.sp)
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    counter=0
                },modifier = Modifier
                    .padding(20.dp)
                    .size(120.dp, 80.dp)) {
                    Text(text = "0",fontSize = 30.sp)
                }
            }
        }
    }
 

}

//@Preview(showBackground = true)
//@Composable
//fun PreviewMessageCard() {
//    conterPage()
//}