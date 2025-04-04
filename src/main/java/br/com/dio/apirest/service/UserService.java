package br.com.dio.apirest.service;

import br.com.dio.apirest.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);
}
