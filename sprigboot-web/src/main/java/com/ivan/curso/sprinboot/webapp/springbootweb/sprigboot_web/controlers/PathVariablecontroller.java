package com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.controlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.models.User;
import com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController 
@RequestMapping("/api/var")
public class PathVariablecontroller {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
 
    @Value("#{${config.valuesMap}.product}")
    private String product;
    
    @Value("#{${config.valuesMap}.price}")
    private Long price;

    private final Environment env;


    PathVariablecontroller(Environment env) {
        this.env = env;
    }


    // Uso de ruta variable con un parametro
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;    
    }

    // uso de multiples parametros en ruta variable
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id ) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }
    
    @PostMapping("/create")
    public User create(@RequestBody  User user) {
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        //  env retorna el valor de la llave siempre como string
        json.put("message2", env.getProperty("config.message"));
        //  get property con sobre carga de cosntructor para devolver el dato en un tipo especifico
        json.put("code2", env.getProperty("config.code", Long.class));
        
        return json;
    }
    
    
}
