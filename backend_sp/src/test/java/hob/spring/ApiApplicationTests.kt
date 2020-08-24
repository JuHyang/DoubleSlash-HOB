package hob.spring

import hob.spring.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApiApplicationTests {
    @Autowired
    private val userService = UserService()
    @Test
    fun api() {
//        userService.subscribeHob("test-user", 1)
//        userService.subscribeHob("test-user", 2)
//        userService.subscribeHob("test-user", 3)
        println(userService.cancelHob("test-user", 3))
        println(userService.cancelHob("test-user", 4))
    }
}