package ly.youcan.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ly.youcan.myapplication.core.Recourc
 import ly.youcan.myapplication.data.entity.UserEntity
import ly.youcan.myapplication.data.database.repository.LocalUserRepositoryImps

class UserView() : ViewModel() {
   private val userrepository = LocalUserRepositoryImps()
    private var currnetState = Recourc.Inti<List<UserEntity>>()
    val state = MutableStateFlow<Recourc<List<UserEntity>>>(currnetState)

    fun getUsers() {
        //insertUser()
        viewModelScope.launch {
            userrepository.getallUSer().onEach {
                delay(2000)
                state.value = it
            }.launchIn(viewModelScope)
        }

    }
    fun getAllUsers() {
        //insertUser()
        viewModelScope.launch {
            userrepository.getallUSer().collect {
                delay(2000)
                state.value = it
            }
        }

    }

//    fun insertUser() {
//        viewModelScope.launch {
//            for (i in 1..10){
//                userrepository.insertUser(
//                    UserEntity(
//                        id = i,
//                        name = "new $i",
//                        phonNumber = "09100000000$i",
//                        email = "",
//                        password = ""
//                    )
//                )
//            }
//        }
//
//    }
}