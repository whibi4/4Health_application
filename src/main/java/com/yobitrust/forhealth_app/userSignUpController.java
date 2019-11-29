package com.yobitrust.forhealth_app;

import com.yobitrust.forhealth_app.security.AppUser;
import com.yobitrust.forhealth_app.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/sign")
public class userSignUpController {

    @Autowired
    private UserService userService;

    @PostMapping(value = {"","/"})
    public ResponseEntity<Void> creatUser(@Valid @RequestBody AppUser user){
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
