package com.scaler.productservice1.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate createRestTemplateBean(){
        return new RestTemplate();
    }
}

//we use it in service class to make api calls to external services.
//Create a single Bean of it, store it some where, I'll reuse it.
//Spring create va single bean.
//@Configuration - tells spring that this class contains bean definitions/ marks as a special class
//@Bean - tells spring that this method will return a bean instance.
