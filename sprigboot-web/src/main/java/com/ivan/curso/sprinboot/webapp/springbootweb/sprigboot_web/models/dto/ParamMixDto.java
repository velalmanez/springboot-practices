package com.ivan.curso.sprinboot.webapp.springbootweb.sprigboot_web.models.dto;

public class ParamMixDto {
    private String message;
    private Integer code;

    public String getMessage(){
        return message;
    }

    public Integer getCode() {
        return code;
    }  

    public void setMessage(String message){
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
