package com.meedra.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "postcard.encrypt")
@Data
@Component
public class EncryptorConfig {
    private int issuerNumbers;
    private String url;
    private String userName;
    private String password;
}
