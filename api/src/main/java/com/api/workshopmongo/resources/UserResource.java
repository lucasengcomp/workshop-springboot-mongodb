package com.api.workshopmongo.resources;

import com.api.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria", "maria@email.com");
        User lucas = new User("2", "Lucas", "lucas@email.com");
        List<User> list = new ArrayList<>();

        list.addAll(Arrays.asList(maria, lucas));

        return ResponseEntity.ok(list);
    }
}
