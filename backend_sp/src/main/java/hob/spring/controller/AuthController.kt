package hob.spring.controller

import hob.spring.model.User
import hob.spring.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController {
    @Autowired
    private val userService = UserService()

    @GetMapping("/api/auth")
    fun auth(): String {
        return "auth"
    }

    @GetMapping("/api/in") // 테스트 컨트롤러
    fun setUser(): String {
        val user = User(
                id = "asdasdasd",
                age = "12",
                mail = "asd",
                name = "asdasd",
                sex = "M"
        )
        try {
            userService.create(user)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "ok"
    }
}