package com.idrunk.services;


import com.idrunk.exceptions.RecordNotFoundException;
import com.idrunk.exceptions.UsernameAlreadyExistsException;
import com.idrunk.models.Authority;
import com.idrunk.models.User;
import com.idrunk.repositories.UserRepository;
import com.idrunk.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements com.idrunk.services.UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Collection<User> getUsers() {

        return userRepository.findAll();

    }

    @Override
    public Optional<User> getUser(String username) {

        return userRepository.findById(username);

    }

    @Override
    public boolean userExists(String username) {

        return userRepository.existsById(username);

    }

    @Override
    public String createUser(User user) {

        if(userExists(user.getUsername())) {
            throw new UsernameAlreadyExistsException("Deze gebruikersnaam bestaat al, log in met de huidige gebruikersnaam of verzin een nieuwe");
        }

        String randomString = RandomStringGenerator.generateAlphaNumeric(20);

        user.setApikey(randomString);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.getAuthorities().clear();

        user.addAuthority(new Authority(user.getUsername(),"ROLE_USER"));

        User newUser = userRepository.save(user);

        return newUser.getUsername();

    }

    @Override
    public void deleteUser(String username) {

        userRepository.deleteById(username);

    }

    @Override
    public void updateUser(String username, User newUser) {

        if (!userRepository.existsById(username)) throw new RecordNotFoundException();

        User user = userRepository.findById(username).get();

        user.setPassword(newUser.getPassword());

        userRepository.save(user);

    }

    @Override
    public Set<Authority> getAuthorities(String username) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);

        User user = userRepository.findById(username).get();

        return user.getAuthorities();

    }

    @Override
    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);

        User user = userRepository.findById(username).get();

        user.addAuthority(new Authority(username, authority));

        userRepository.save(user);
    }

    @Override
    public void removeAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);

        User user = userRepository.findById(username).get();

        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();

        user.removeAuthority(authorityToRemove);

        userRepository.save(user);

    }

    @Override
    public void uploadMenu(String username, MultipartFile file) throws IOException {
        var optionalUser = userRepository.findById(username);
        if (optionalUser.isPresent()) {
            var user = optionalUser.get();
            user.setMenu(file.getBytes());
            userRepository.save(user);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public byte[] getMenu(String username) {
        var optionalUser = userRepository.findById(username);
        if (optionalUser.isPresent()) {
            return optionalUser.get().getMenu();
        } else {
            throw new RecordNotFoundException();
        }
    }


}