package domain.com.email.email.application.example.projections

import domain.com.email.email.application.example.dtos.UserDTO
import domain.com.email.email.application.example.dtos.UserLoginDTO
import domain.com.email.email.application.example.dtos.UserSignDTO
import domain.com.email.email.application.example.entities.User

interface IUser {
     fun signIn(User:UserSignDTO)

     fun login(UserLogin:UserLoginDTO): UserDTO

     fun sendEmail(user: UserLoginDTO):Boolean
}