package com.yobitrust.forhealth_app;

import com.yobitrust.forhealth_app.security.AppUser;
import com.yobitrust.forhealth_app.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/edit")
public class userEditConfidentielsController extends BaseController  {

    @Autowired
    private UserService userService ;

    @GetMapping(value = {"","/"})
    public ResponseEntity<AppUser> getUser (){
        AppUser user = getCurrentUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AppUser> updateName(@PathVariable("name") String name){
        AppUser user = getCurrentUser();
        userService.editName(user,name);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/birthdate/{birdate}")
    public ResponseEntity<AppUser> updateBirthdate(@PathVariable("birthdate") String birthdate){
        AppUser user = getCurrentUser();
        userService.editBirthdate(user,birthdate);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/blood_type/{blood_type}")
    public ResponseEntity<AppUser> updateBlood_type(@PathVariable("blood_type") String blood_type){
        AppUser user = getCurrentUser();
        userService.editBlood_type(user ,blood_type);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<AppUser> updateGender(@PathVariable("gender") String gender){
        AppUser user = getCurrentUser();
        userService.editGender(user ,gender);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/height/{height}")
    public ResponseEntity<AppUser> updateHeight(@PathVariable("height") String height){
        AppUser user = getCurrentUser();
        userService.editHeight(user ,height);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/weight/{weight}")
    public ResponseEntity<AppUser> updateWeight(@PathVariable("weight") String weight){
        AppUser user = getCurrentUser();
        userService.editWeight(user ,weight);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
