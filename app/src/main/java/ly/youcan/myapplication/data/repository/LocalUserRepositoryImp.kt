package ly.youcan.myapplication.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ly.umbrella.roomapplications.data.repository.LocalUserRepository
import ly.youcan.myapplication.core.Recourc
import ly.youcan.myapplication.core.database.UserDb
import ly.youcan.myapplication.data.entity.UserEntity

class LocalUserRepositoryImps: LocalUserRepository {
  private  var database = UserDb.initDb(null)
    override suspend fun getallUSer(): Flow<Recourc<List<UserEntity>>> {
        return flow {
            emit(Recourc.Loading<List<UserEntity>>())
         var listuser= database.getuserDao().getallUser()
            emit(Recourc.Success<List<UserEntity>>(data = listuser.map { it.converToEntity() }))
        }

    }
    override suspend fun insertUser(user: UserEntity) {
        database.getuserDao().inserUser(user.convertToModelDb())

    }
}