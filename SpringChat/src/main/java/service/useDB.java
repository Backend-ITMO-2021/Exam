package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class useDB {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(useDB.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods() {
        User users = new User();
        users.setUsername("ruf");
        users.setPassword("ruf");
        userService.createUser(users);

//        userService.findAll().forEach(it -> System.out.println(it));
//
//        userService.findAllByName("Smith").forEach(it -> System.out.println(it));
    }
}
