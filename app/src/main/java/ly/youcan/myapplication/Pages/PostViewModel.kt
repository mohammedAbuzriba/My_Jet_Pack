package ly.youcan.myapplication.Pages

import ApiPostRepositoryImp
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ly.umbrella.roomapplications.data.repository.ApiPostRepository
import ly.youcan.myapplication.core.Recourc
import ly.youcan.myapplication.data.ServerApi.model.Post
import ly.youcan.myapplication.data.entity.UserEntity

class PostViewModel: ViewModel() {
    val postRepository = ApiPostRepositoryImp()
    var currentState = Recourc.Inti<Post>()
    var state = MutableStateFlow<Recourc<Post>>(currentState)

    fun getAllPost(){
        viewModelScope.launch(Dispatchers.IO){
            postRepository.getAllposts().onEach(){
                state.value = it
            }.launchIn(this)
        }
    }
}