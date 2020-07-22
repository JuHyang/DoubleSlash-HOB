package hob.spring.service;

import hob.spring.model.User;
import hob.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User get(final String id){
        return userRepository.findById(id).orElse(null);
    }

    public User create(final User user){
        if (user == null) {
            throw new NullPointerException("user account cannot be null");
        }
        return userRepository.insert(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
