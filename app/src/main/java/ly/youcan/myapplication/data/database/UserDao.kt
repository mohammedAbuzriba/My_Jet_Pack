package ly.youcan.myapplication.data.database

import androidx.room.*
import ly.youcan.myapplication.data.database.UserDbModel

@Dao
interface UserDao {
    @Query("SELECT * FROM usertb")
    suspend fun getallUser(): List<UserDbModel>
    @Query("SELECT * FROM usertb  WHERE email=:email AND password=:password ")
    suspend fun login(email: String,password:String): UserDbModel
    @Insert(onConflict = 1)
    suspend fun inserUser(vararg user: UserDbModel)
    @Update()
    suspend fun updateUser(vararg user: UserDbModel)
    @Query("DELETE FROM usertb")
    suspend fun deleteallUser(): Unit

    @Delete
    suspend fun deleteUser(user: UserDbModel)


}