package ly.umbrella.roomapplications.data.repository

import kotlinx.coroutines.flow.Flow
import ly.youcan.myapplication.core.Recourc
import ly.youcan.myapplication.data.ServerApi.model.Post


interface ApiPostRepository {
    suspend fun getAllposts():Flow<Recourc<Post>>
}