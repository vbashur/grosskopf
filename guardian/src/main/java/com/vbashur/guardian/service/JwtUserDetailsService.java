package com.vbashur.guardian.service;

import com.vbashur.guardian.UserRepository;
import com.vbashur.guardian.model.ImmutableUserDTO;
import com.vbashur.guardian.model.UserDTO;
import com.vbashur.guardian.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDao user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
//        if ("javainuse".equals(username)) {
//            System.out.println(">>>load by user name = " + username);
//            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
    }

    public UserDao save(UserDTO user) {
        UserDao newUser = new UserDao();
        newUser.setUsername(user.username());
        newUser.setPassword(bcryptEncoder.encode(user.password()));
        return userRepository.save(newUser);
    }

}