package com.alisanguo.config;


import com.offbytwo.jenkins.JenkinsServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class JenkinsServerConfig {

    private String jenkinsUrl = "http://47.101.66.118:8080/";

    private String jenkinsUser = "admin";

    private String jenkinsPassword = "admin123";

    @Bean
    public JenkinsServer getJenkinsClient() throws URISyntaxException {
        JenkinsServer jenkins = new JenkinsServer(new URI(jenkinsUrl), jenkinsUser, jenkinsPassword);
        return jenkins;
    }
}
