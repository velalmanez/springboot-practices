package com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.models.dto.ParamDto;
import com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController 
@RequestMapping ("/api/params")
public class RequestParamsController {

    // Una parametro con valor por defecto en request
    @GetMapping ("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "No message") String message){
        ParamDto param = new ParamDto();
        param.setMessage(message != null ? message : "No message");
        return param;
    }

    // Dos parametros 
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDto param = new ParamMixDto();
        param.setMessage(text);
        param.setCode(code);
        return param;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        
        Integer code = 0;
        try{
            code = Integer.parseInt(request.getParameter("code"));
        }
        catch(NumberFormatException e){
            code = 0;
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("text"));
        return params;
    }
    
    
}
