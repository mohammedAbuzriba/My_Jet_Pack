package ly.youcan.myapplication.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ly.youcan.myapplication.core.basemodols.BaseModel
import ly.youcan.myapplication.data.entity.UserEntity

@Entity(tableName = "usertb")
data class UserDbModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name= "id")  val id:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "email")  val email:String,
    @ColumnInfo(name = "phone_number")  val phonNumber:String,
    @ColumnInfo(name = "password")  val password:String

): BaseModel<UserDbModel, UserEntity>(){
    override fun converToEntity(): UserEntity {
       return UserEntity(id=this.id,name=this.name,phonNumber=this.phonNumber, email = this.email, password = this.password)
    }

}

