package com.unimerch.unimerch.service;

import com.unimerch.unimerch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.unimerch.unimerch.entity.User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password((userObj.getPassword()))
//                    .roles(getRole(userObj))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }

//        public User updateStudentPassword(Long id, String password) {
//
//            User user1 = repository.findById(id)      .orElseThrow() -> new NoSuchElementException("USER IS NOT FOUND"));
//
//            String encodedPassword = passwordEncoder.encode(password);
//
//            user1.setPassword(encodedPassword);
//
//            return repository.save(user1);


        }
    }


//    private String[] getRole(User user) {
//        if (user.getRole() == null) {
//            return new String[] {"USER"};
//        }
//        return user.getRole().split(regex: ",");
//    }
//}
