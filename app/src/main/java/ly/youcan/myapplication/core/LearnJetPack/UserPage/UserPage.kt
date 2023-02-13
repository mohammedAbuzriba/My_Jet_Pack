package ly.youcan.myapplication.core.LearnJetPack.UserPage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ly.youcan.myapplication.core.LearnJetPack.UserPage.Composables.UserItem
import ly.youcan.myapplication.UserView
import ly.youcan.myapplication.core.Recourc
import ly.youcan.myapplication.data.entity.UserEntity


@Composable
fun UserPage() {
    val vm:UserView= viewModel<UserView>()
    //val vm: UserViewModel by viewModel()
    val state = vm.state.collectAsState().value
//    val state by remember {
//        mutableStateOf<Recourc<List<UserEntity>>>(Recourc.Inti<List<UserEntity>>())
//    }

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
                Text(text = "Click", fontSize = 30.sp)
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
                            UserItem(user = state.data!![index])
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


