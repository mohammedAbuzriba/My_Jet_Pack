package ly.youcan.myapplication.Pages.loginPage

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ly.youcan.myapplication.Pages.CounterPage.conterPage

data class User(var name:String,var pass:String)
@Composable
fun loginpage(){
    var user  = remember {
        mutableStateOf<User>(User("",""))
    }
    var name  = remember {
        mutableStateOf("")
    }

    var pass  by remember {
        mutableStateOf("")
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
                Text(text = "user :${user.value.name} \npass: ${user.value.pass}",fontSize = 25.sp, color = Color.Blue)
                //Text(text = user.name,fontSize = 30.sp, color = Color.Blue)
            }


            TextField(value = name.value, onValueChange = {
                name.value = it

               // Log.d("testbtn",  user.name)
            })
            Spacer(modifier = Modifier.height(100.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

               TextField(value = pass, onValueChange = {
                   pass = it

               })

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {

                    user.value.name = name.value
                    user.value.pass = pass
                    name.value=""

                },modifier = Modifier
                    .padding(20.dp)
                    .size(150.dp, 60.dp)) {
                    Text(text = "Login",fontSize = 30.sp)
                }

            }
        }
    }


}

//
//@Preview(showBackground = true)
//@Composable
//fun Previewloginpage() {
//    loginpage()
//}