package domain.com.email.email.application.example.services

import domain.com.email.email.application.example.dtos.UserDTO
import domain.com.email.email.application.example.dtos.UserLoginDTO
import domain.com.email.email.application.example.dtos.UserSignDTO
import domain.com.email.email.application.example.entities.User
import domain.com.email.email.application.example.projections.IUser
import domain.com.email.email.application.example.repository.UserRepository
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

import java.util.regex.Pattern
@Service
class UserService(private val userRepository:UserRepository,private val sendEmail:JavaMailSender):IUser {

    override fun signIn(user: UserSignDTO) {
        if(user!=null && user.email!=null){
            if(isEmailValid(user.email)){
                userRepository.save(user.toEntity())
            }
        }
    }

    override fun login(userLogin: UserLoginDTO): UserDTO {

       var user:User=userRepository.loginUser(userLogin.email,userLogin.password)

        var userDTO:UserDTO=UserDTO(user.name,user.email)
        if(this.sendEmail(userLogin)){
            println("sucessso")
        }
        return userDTO

    }

    override fun sendEmail(user: UserLoginDTO): Boolean {
        var msg = SimpleMailMessage()
        msg.setTo(user.email);
        msg.setText(
            "Prezado " + user.password
                    + " Enviando email a partir do java Spring boot "
        )

        try {
            sendEmail.send(msg)
            return true
        } catch (ex: MailException) {
            // simply log it and go on...
            System.err.println(ex.cause);
        }
        return false
    }

    private fun isEmailValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"
        val pattern = Pattern.compile(emailRegex)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}


