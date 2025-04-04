package br.com.dio.apirest.service.impl;

import br.com.dio.apirest.domain.model.User;
import br.com.dio.apirest.domain.repository.UserRepository;
import br.com.dio.apirest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber()))
            throw new IllegalArgumentException("Account number already exists!");
        return userRepository.save(user);
    }
}
