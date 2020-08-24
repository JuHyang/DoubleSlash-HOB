package hob.spring.controller

import hob.spring.model.User
import hob.spring.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth/*")
class AuthController {
    @Autowired
    private val userService = UserService()

    @GetMapping // 페이지 확인
    fun auth(): String {
        return "auth"
    }

    @PostMapping("/reg") // 회원가입
    fun registration(@RequestBody user: User): String {
        try {
            userService.create(user)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "ok"
    }
}