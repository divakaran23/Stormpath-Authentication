/**
 * Copyright 2017 Expedia, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.divakaran.controller;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Divakaran Jeyachandran
 */
@RestController
public class UserDetailsController {

    private AccountResolver accountResolver;

    @Autowired
    public UserDetailsController(AccountResolver accountResolver) {
        Assert.notNull(accountResolver);
        this.accountResolver = accountResolver;
    }

    @RequestMapping(value = "/tokenDetails")
    public String getTokenInformation(HttpServletRequest request) {
        Account account = accountResolver.getAccount(request);
        return account.getEmail() + " / " + account.getUsername() + " / " + account.getHref();
    }
}
