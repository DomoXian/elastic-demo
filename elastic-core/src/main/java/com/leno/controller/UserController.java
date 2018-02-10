package com.leno.controller;

import com.leno.model.request.UserRequest;
import com.leno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>TODO</p>
 *
 * @author: XianGuo
 * @date: 2018年01月22日
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getUserList.json")
    public Object getUserList(@RequestBody @Validated UserRequest userRequest) {
        return userService.getUserList(userRequest);
    }

    @PostMapping("/searchMatch.json")
    public Object searchMatch(@RequestParam String userName) {
        return userService.searchMatchByName(userName);
    }

    @PostMapping("/searchTerm.json")
    public Object searchTerm(@RequestParam String userName) {
        return userService.searchTermByName(userName);
    }

    @PostMapping("/searchMatchPhrase.json")
    public Object searchMatchPhrase(@RequestParam String userName) {
        return userService.searchMatchPhraseByName(userName);
    }


}
