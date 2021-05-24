package com.example.freefire;

import com.example.freefire.entity.Role;
import com.example.freefire.entity.User;
import com.example.freefire.repository.RoleRepository;
import com.example.freefire.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class FreefireApplication {
    final private RoleRepository roleRepository;
    final private UserRepository userRepository;
    final private PasswordEncoder passwordEncoder;
    @Autowired
    public FreefireApplication(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(FreefireApplication.class, args);
    }
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            if(roleRepository.findAll()==null||roleRepository.findAll().size()<1) {
                Role roleAdmin= new Role();
                roleAdmin.setFlagDelete("0");
                roleAdmin.setName("admin");
                roleRepository.save(roleAdmin);

            }

            if(userRepository.findAll()==null||userRepository.findAll().size()<1) {
                User user= new User();
                user.setUsername("admin");
                List<Role> roles= new ArrayList<>();
                roles.add(roleRepository.getRoleByName("admin"));
                user.setRoles(roles);
                user.setFlagDelete(false);
                user.setPassword(passwordEncoder.encode("Nam155122@"));
                userRepository.save(user);
            }
        };
    }
}
