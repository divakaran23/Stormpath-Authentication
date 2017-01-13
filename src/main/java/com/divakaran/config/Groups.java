package com.divakaran.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Divakaran Jeyachandran - djeyachandran@expedia.com
 */
@Component
public class Groups {

    public final String ADMIN;

    @Autowired
    public Groups(Environment environment) {
        ADMIN = environment.getProperty("stormpath.authorized.group.admin");
    }

//    @Autowired
//    public Groups(@Value("${stormpath.authorized.group.admin}") String groupUrl) {
//        ADMIN = groupUrl;
//    }
}
