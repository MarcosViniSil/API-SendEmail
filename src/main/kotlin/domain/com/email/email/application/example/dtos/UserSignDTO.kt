package domain.com.email.email.application.example.dtos

import domain.com.email.email.application.example.entities.User
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull

class UserSignDTO (@field:NotNull(message = "Invalid input") val name:String,
                   @field:Email(message = "Invalid input") val email:String,
                   @field:NotNull(message = "Invalid input") val password:String
) {

    fun toEntity(): User = User(name=this.name,email=this.email,password=this.password)
}