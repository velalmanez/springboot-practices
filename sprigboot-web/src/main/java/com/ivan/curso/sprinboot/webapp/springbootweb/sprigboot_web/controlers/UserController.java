package com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.controlers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.models.User;



@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "User Details");
        model.addAttribute("user", "Aleks Ivan");
        model.addAttribute("email", "aleks@example.com");

        return "details";
    }
     
    @GetMapping("/details-mapping")
    public String detailsMapping(Map<String, Object> model) {
        model.put("title", "User Details with Mapping");
        model.put("user", "Aleks Ivan");
        model.put("email", "aleks@example.com");

        return "detailsMapping";
    }

    @GetMapping("/details_v2")
    public String details_v2(Model model) {
        User user = new User("Aleks Ivan", "Velazquez");
        user.setEmail("aleks@example.com");
        model.addAttribute("title", "User Details");
        model.addAttribute("user", user);
     
        return "detail_v2";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {

        model.addAttribute("title", "Listado Usuarios");
     
        return "listUsers";
    }

    // datos globales para todo el controlador
    @ModelAttribute("users")
    public List<User> usersModel(){
        return Arrays.asList(
            new User("Aleks Ivan", "Velazquez"),
            new User("Juan Jose", "Velazquez", "juan@correo.com"),
            new User("Maribel", "Arriaga"),
            new User("Victor", "Velazquez", "victor@correo.com")
        );

    }
}
