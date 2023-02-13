package ly.youcan.myapplication.data.database.repository

import android.annotation.SuppressLint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ly.umbrella.roomapplications.data.repository.LocalUserRepository
import ly.youcan.myapplication.core.Recourc
import ly.youcan.myapplication.data.database.UserDb
import ly.youcan.myapplication.data.entity.UserEntity

class LocalUserRepositoryImps : LocalUserRepository {
    private var database = UserDb.initDbRepo()

    @SuppressLint("SuspiciousIndentation")
    override suspend fun getallUSer(): Flow<Recourc<List<UserEntity>>> {
        return flow {
            emit(Recourc.Loading<List<UserEntity>>())
            var listuser = database.getuserDao().getallUser()
            emit(Recourc.Success<List<UserEntity>>(data = listuser.map { it.converToEntity() }))
        }
    }

    override suspend fun login(email: String, password: String): Flow<Recourc<UserEntity>> {
        return flow {
            emit(Recourc.Loading<UserEntity>())
            try {
                var user = database.getuserDao().login(email,password)
                emit(Recourc.Success<UserEntity>(data = user.converToEntity()))
            }catch (e:Exception){
                emit(Recourc.Error("Not found "))
            }



        }
    }

    override suspend fun insertUser(user: UserEntity) {
        database.getuserDao().inserUser(user.convertToModelDb())

    }

    override suspend fun updateUser(user: UserEntity) {
        database.getuserDao().updateUser(user.convertToModelDb())
    }

    override suspend fun deleteallUser() {
        database.getuserDao().deleteallUser()
    }

    override suspend fun deleteUser(user: UserEntity) {
        database.getuserDao().deleteUser(user.convertToModelDb())
    }
}