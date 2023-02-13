package ly.youcan.myapplication.Pages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ly.youcan.myapplication.core.Recourc
 import ly.youcan.myapplication.data.entity.UserEntity
import ly.youcan.myapplication.data.database.repository.LocalUserRepositoryImps

class UserViewModel() : ViewModel() {
   private val userrepository = LocalUserRepositoryImps()
    private var currnetStateList = Recourc.Inti<List<UserEntity>>()
    private var currnetState = Recourc.Inti<UserEntity>()
    val stateList = MutableStateFlow<Recourc<List<UserEntity>>>(currnetStateList)
    val state = MutableStateFlow<Recourc<UserEntity>>(currnetState)

//    fun getUsers() {
//        insertUser()
//        viewModelScope.launch {
//            userrepository.getallUSer().onEach {
//                delay(2000)
//                state.value = it
//            }.launchIn(viewModelScope)
//        }
//    }

    fun getAllUsers() {
        viewModelScope.launch {
            userrepository.getallUSer().collect {
                stateList.value = it
            }
        }
    }

    fun login(email: String,password:String) {
        viewModelScope.launch {
            userrepository.login(email = email, password = password).collect {
                state.value = it
            }
        }
    }

    fun insertUser(userEntity: UserEntity) {
        viewModelScope.launch {

            userrepository.insertUser(userEntity)


//            for (i in 11..20){
//                userrepository.insertUser(UserEntity(0,"test:$i","test$i","09171508$i","$i"))
//            }

        }

    }

    fun updateUser(userEntity: UserEntity) {
        viewModelScope.launch {

            userrepository.updateUser(
                userEntity
            )
        }

    }

    fun deleteUser(userEntity: UserEntity) {
        viewModelScope.launch {

            userrepository.deleteUser(
                userEntity
            )
        }

    }

    fun deleteallUser() {
        viewModelScope.launch {
            userrepository.deleteallUser()
        }

    }
}