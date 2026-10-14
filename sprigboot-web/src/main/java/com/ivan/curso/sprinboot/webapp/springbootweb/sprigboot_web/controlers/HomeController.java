package com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class HomeController {
    
    // Redirect recarga la pagina y pierde los parametros del
    @GetMapping({"", "/"})
    public String baseRoute(){
        return "redirect:/details";
    }
   
    // Forward despacha el controlador indicado pero mantiene 
    // los parametro del request sin recargar la pagina
    @GetMapping("/home")
    public String home(){
        return "forward:/list";
    }
}
