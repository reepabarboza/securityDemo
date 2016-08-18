package com.reepa.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pradeep on 14-06-2016.
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    //@Secured("{ROLE_USER,ROLE_GUEST}")
    @RequestMapping("/list")
    public String list(){
        return "list posts...";
    }

    @Secured("{ROLE_USER,ROLE_GUEST}")
    @RequestMapping("/drafts")
    public String drafts(){
        return "draft posts...";
    }

    @Secured("{ROLE_ADMIN}")
    @RequestMapping("/add")
    public String addPost(){
        return "add posts...";
    }
}
