package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsersRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void createUser(User user) {
        usersRepository.save(user);
    }

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    public User findByUsername(String username) {
        return usersRepository.findById(username).orElse(null);
    }

    public List<User> findAllByName(String name) {
        return usersRepository.findAllByName(name);
    }

}