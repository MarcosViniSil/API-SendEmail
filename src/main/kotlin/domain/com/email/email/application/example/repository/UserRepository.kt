package domain.com.email.email.application.example.repository

import domain.com.email.email.application.example.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query



interface UserRepository:JpaRepository<User,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tb_User AS u WHERE u.tb_email = :email AND u.tb_password = :password")
    fun loginUser(email:String,password:String):User
}