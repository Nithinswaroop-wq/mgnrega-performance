package com.example.Mgnrega.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Modelmapperconfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
