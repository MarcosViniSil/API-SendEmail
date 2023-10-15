package domain.com.email.email.application.example.entities

import jakarta.persistence.*
@Entity(name="tb_User")
class User( @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
            @Column(name="tb_name") var name:String="",
            @Column(name="tb_email")var email:String="",
            @Column(name="tb_password") var password:String="")