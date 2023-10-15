package domain.com.email.email.application.example.dtos


import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull

class UserDTO(@field:NotNull(message = "Invalid input") val name:String,
@field:Email(message = "Invalid input") val email:String,
) {


}