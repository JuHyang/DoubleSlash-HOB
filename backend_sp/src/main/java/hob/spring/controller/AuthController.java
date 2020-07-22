package hob.spring.controller;

import hob.spring.model.User;
import hob.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/in")
    public String setUser() {
        User user = new User();
        user.setAge("12");
        user.setName("12");
        user.setMail("12");
        user.setSex("M");
        try {
            userService.create(user);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @GetMapping("out")
    public String getUser() {
        List<User> users = userService.getAll();
        for (User user : users) {
            System.out.println(user.getSex());
            System.out.println(user.getAge());
            System.out.println(user.getMail());
            System.out.println(user.getName());
        }
        return "ok";
    }
}
