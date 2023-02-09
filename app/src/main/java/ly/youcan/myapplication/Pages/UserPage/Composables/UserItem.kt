package ly.youcan.myapplication.Pages.UserPage.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ly.youcan.myapplication.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp
import ly.youcan.myapplication.data.entity.UserEntity

@Composable
fun UserItem(user: UserEntity) {
    Card(modifier = Modifier.background(Color.White).padding(10.dp), elevation = 8.dp){
        Row(  modifier = Modifier
            .fillMaxSize().background(Color(0xFFEAE3F1)).padding(4.dp).padding(10.dp)) {
            Image(
                painter = painterResource(R.drawable.a),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(100.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = user.name,fontSize = 20.sp)
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = user.phonNumber,fontSize = 20.sp)
            }
        }
    }
}