package com.example.customerdemo.customer;

import com.example.customerdemo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConf {
    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Value("${info.app-author}")
    private String authorName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp){
        return args -> {
            System.out.println("Command Line Runner Started");
            System.out.println(authorName);
            System.out.println(environment.getProperty("info.app.version"));
            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepo = "+ useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
