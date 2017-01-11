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

    @Value("${stormpath.authorized.group.admin}")
    private String groupUrl;

    @Autowired
    public Groups(Environment environment) {
        ADMIN = groupUrl;
    }
}
