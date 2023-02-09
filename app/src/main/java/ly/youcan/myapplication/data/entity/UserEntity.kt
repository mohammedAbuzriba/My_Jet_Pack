package ly.youcan.myapplication.data.entity

import ly.youcan.myapplication.core.database.UserDbModel
import java.io.Serializable

data class UserEntity (
      val id:Int,
     val name:String,
     val phonNumber:String
):Serializable{
    fun convertToModelDb(): UserDbModel {
        return UserDbModel(name = this.name, id = this.id, phonNumber = this.phonNumber, bbb = "", city = "")
    }
}