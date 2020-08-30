package com.api.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import com.api.workshopmongo.domain.User;
import com.api.workshopmongo.dto.UserDTO;
import com.api.workshopmongo.repository.UserRepository;
import com.api.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User inser(User obj) {
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}