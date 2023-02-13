package ly.youcan.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ly.youcan.myapplication.Pages.NavigatePage.navigatePage
import ly.youcan.myapplication.data.database.UserDb

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        UserDb.initDb(this)
        super.onCreate(savedInstanceState)
        setContent {
            navigatePage()
        }
    }
}



