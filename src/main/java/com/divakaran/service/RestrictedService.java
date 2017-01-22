package com.divakaran.service;

import com.stormpath.sdk.account.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author Divakaran Jeyachandran - djeyachandran@expedia.com
 */
@Service
public class RestrictedService {

    @PreAuthorize("hasAuthority(@groups.ADMIN) and hasPermission('say', 'hello')")
    public String validateUser(Account account) {
        String message = "Hello, " + account.getFullName() +
                ". You have been given access to this page";
        return message;
    }
}
