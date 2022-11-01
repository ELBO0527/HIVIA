package com.example.hibia.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "file.upload")
public class FileUploadProperties {

//    private String location;
//
//    public FileUploadProperties(String location) {
//        this.location = location;
//    }
}
