package com.scaler.productservice1.commons;

import com.scaler.productservice1.dtos.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Setter
@Getter
@Component
public class AuthCommons {
    private static RestTemplate restTemplate;
    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public static boolean ValidateToken(String tokenValue){
        //call the user service to validate token
        try {//getforObject returns just Body but Entity returns Body+Headers+Response
            UserDto responseEntity = restTemplate.getForObject(
                    "http://localhost:8080/users/validate/" + tokenValue,
                    UserDto.class);

            if (responseEntity == null) {
                return false;
            }
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
