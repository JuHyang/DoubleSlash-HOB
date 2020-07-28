package hob.spring.controller

import hob.spring.model.Hob
import hob.spring.service.HobService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HobController {
    @Autowired
    private val hobService = HobService()

    @GetMapping("/api/hob/A")
    fun hob(): String {
        return "hob"
    }

    @GetMapping("/api/hob") // hob content 제공
    fun getHobContent(
            @RequestParam(value = "index", required = true) index: Int,
            @RequestParam(value = "type", required = true) type: Int): String {
        return "hob content"
    }

    @GetMapping("/api/hob/reg") // 수강중인 hob content 제공
    fun getRegisteredHobContent(
            @RequestParam(value = "index", required = true) index: Int): String {
        return "hob content"
    }

    @GetMapping("/api/hob/pick") // 찜한 hob content 제공
    fun getPickedHobContent(
            @RequestParam(value = "index", required = true) index: Int): String {
        return "hob content"
    }

    @GetMapping("/api/hob/fin") // 수강완료 한 hob content 제공
    fun getFinishedHobContent(
            @RequestParam(value = "index", required = true) index: Int): String {
        return "hob content"
    }

    @GetMapping("/in") // 테스트 컨트롤러
    fun setUser(): String {
        val user = Hob()
        try {
            hobService.create(user)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "ok"
    }

}