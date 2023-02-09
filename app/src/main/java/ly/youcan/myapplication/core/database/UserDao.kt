package ly.youcan.myapplication.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ly.youcan.myapplication.core.database.UserDbModel

@Dao
interface UserDao {
    @Query("SELECT * FROM usertb")
  suspend  fun getallUser():List<UserDbModel>
    @Insert(onConflict = 1)
   suspend fun inserUser(vararg user: UserDbModel)
    @Delete
    fun deleteUser(user: UserDbModel)


}