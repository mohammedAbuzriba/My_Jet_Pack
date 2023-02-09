package ly.youcan.myapplication

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ly.youcan.myapplication.Pages.CounterPage.conterPage
import ly.youcan.myapplication.Pages.UserPage.UserPage
import ly.youcan.myapplication.Pages.loginPage.loginpage
import ly.youcan.myapplication.core.database.UserDb

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        UserDb.initDb(this)
        super.onCreate(savedInstanceState)
        setContent {
            //conterPage()
            //loginpage()
            UserPage()
        }
    }

}


data class MessageText(val author:String,val body:String)
//@Composable
//fun MessageCard(name: String) {
//    Text(text = "Hello $name")
//}


@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    conterPage()
}




