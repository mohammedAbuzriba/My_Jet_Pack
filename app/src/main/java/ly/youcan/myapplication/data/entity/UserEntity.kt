package ly.youcan.myapplication.data.entity

import ly.youcan.myapplication.data.database.UserDbModel
import java.io.Serializable

data class UserEntity(
    val id: Int,
    val name: String,
    val email: String,
    val phonNumber: String,
    val password: String,
) : Serializable {

    fun convertToModelDb(): UserDbModel {
        return UserDbModel(
            name = this.name,
            id = this.id,
            phonNumber = this.phonNumber,
            email = this.email,
            password = this.password
        )
    }
}