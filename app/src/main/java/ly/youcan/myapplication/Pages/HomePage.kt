package ly.youcan.myapplication.Pages.loginPage

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import ly.youcan.myapplication.Pages.UserViewModel
import ly.youcan.myapplication.R
import ly.youcan.myapplication.core.Recourc
import ly.youcan.myapplication.data.entity.UserEntity

@Composable
fun HomePage(navController: NavHostController) {
    val vm: UserViewModel = viewModel<UserViewModel>()
    val state = vm.stateList.collectAsState().value
    //vm.getAllUsers()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        it.calculateTopPadding()
        Column(
            modifier = Modifier
                .fillMaxSize(),

//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = {
                    vm.getAllUsers()
                }
            )
            {
                Text(text = stringResource(id = R.string.get_User), fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.size(30.dp))


            when (state) {
                is Recourc.Loading<List<UserEntity>> -> {

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CircularProgressIndicator()
                    }

                }
                is Recourc.Success<List<UserEntity>> -> {



                    LazyColumn(content = {
                        items(state.data!!.size) { index ->
                            UserItem(user = state.data!![index],navController)
                        }
                    })
                }
                is Recourc.Error<List<UserEntity>> -> {

                }
                else -> {

                }
            }

        }
    }
}

@Composable
fun UserItem(user: UserEntity,navController: NavHostController) {
    val vm: UserViewModel = viewModel<UserViewModel>()
    Card(modifier = Modifier
        .background(Color.White)
        .padding(10.dp)
        .fillMaxWidth(0.95f)
        .clickable {
            navController.navigate("UserInfo_page/${user.id}/${user.name}/${user.email}/${user.phonNumber}/${user.password}")
        },
        elevation = 4.dp,
    ){
        Row(  modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F6F8))
            .padding(4.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(R.drawable.a),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(100.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )

            Column {
                Text(text = "name: ${user.name}",fontSize = 14.sp)
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "email: ${user.email}",fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "phone: ${user.phonNumber}",fontSize = 14.sp)
            }
            IconButton(onClick = {
                vm.deleteUser(user)
                vm.getAllUsers()
            }) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription ="delete" )
                
            }
        }
    }
}