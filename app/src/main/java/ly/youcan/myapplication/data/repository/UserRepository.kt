package ly.umbrella.roomapplications.data.repository

import kotlinx.coroutines.flow.Flow
import ly.youcan.myapplication.core.Recourc
import ly.youcan.myapplication.data.entity.UserEntity

interface LocalUserRepository {
    suspend fun getallUSer(): Flow<Recourc<List<UserEntity>>>
 suspend  fun insertUser(user: UserEntity)

}