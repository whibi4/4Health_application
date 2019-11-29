package com.yobitrust.forhealth_app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = userRepository.findByEmail(email);
        return user;
    }

    public void editName(AppUser user , String name){
        user.setName(name);
        this.userRepository.save(user);
    }

    public void editBirthdate(AppUser user , String birthdate){
        user.setBirthdate(birthdate);
        this.userRepository.save(user);
    }

    public void editBlood_type(AppUser user , String blood_type){
        user.setBlood_type(blood_type);
        this.userRepository.save(user);
    }

    public void editGender(AppUser user , String gender){
        user.setGender(gender);
        this.userRepository.save(user);
    }

    public void editHeight(AppUser user , String height){
        user.setHeight(height);
        this.userRepository.save(user);
    }

    public void editWeight(AppUser user , String weight){
        user.setWeight(weight);
        this.userRepository.save(user);
    }


    public void save(AppUser user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        this.userRepository.save(user);
    }



    public List<AppUser> findAll() {
        return userRepository.findAll();
    }
}
