package domain.com.email.email.application.example.controllers

import domain.com.email.email.application.example.dtos.UserDTO
import domain.com.email.email.application.example.dtos.UserLoginDTO
import domain.com.email.email.application.example.dtos.UserSignDTO
import domain.com.email.email.application.example.services.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
class UserController(private val userService:UserService) {

    @PostMapping("/sign")
    fun saveCredit(@RequestBody @Valid userSignDTO: UserSignDTO): ResponseEntity<String> {
        this.userService.signIn(userSignDTO)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Customer ${userSignDTO.email} saved!")
    }

    @PostMapping("/login")
    fun findAllByCustomerId(@RequestBody user:UserLoginDTO) : UserDTO {
       return this.userService.login(user)
    }
}