package com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.controlers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.models.User;
import com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.models.dto.UserDto;


@RestController
@RequestMapping("/api/users")
public class UserRestControler {

    @GetMapping("/details-rest")
    public Map<String, Object> details() {
        User user = new User("Aleks", "aleks@example.com");
        Map<String, Object> response = new HashMap<>();
        response.put("title", "User Details");
        response.put("user", user);

        return response;
    }

     @GetMapping("/details-dto")
    public UserDto detailsDto() {
        
        User user = new User("Aleks Ivan", "aleks@example.com");
        UserDto userDto = new UserDto();
        userDto.setTitle("User Details with DTO");
        userDto.setUser(user);

        return userDto;
    }

    @GetMapping("/list")    
    public List<User> list(){
        User user1 = new User("Aleks", "aleks@example.com");
        User user2 = new User("Ivan", "Ivan@example.com");
        User user3 = new User("Juan", "Juan@example.com");
        User user4 = new User("Jose", "Jose@example.com");

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        return  users;
    }
     
}
