package com.api.workshopmongo.services;

import com.api.workshopmongo.domain.User;
import com.api.workshopmongo.repository.UserRepository;
import com.api.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user = repository.findOne(id);
        if (user == null) {
            throw new ObjectNotFoundException("Usuário não encontrado!");
        }
        return user;
    }
}
