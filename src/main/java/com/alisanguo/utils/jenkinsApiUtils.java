package com.alisanguo.utils;

import com.offbytwo.jenkins.JenkinsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class jenkinsApiUtils {

    @Autowired
    private JenkinsServer jenkinsServer;

}
