package com.api.workshopmongo.services;

import com.api.workshopmongo.domain.Post;
import com.api.workshopmongo.repository.PostRepository;
import com.api.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

//    public List<Post> findByTitle(String text) {
//        return repository.findByTitleContainingIgnoreCase(text);
//    }

    public List<Post> searchTitle(String text) {
        return repository.searchTitile(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 100);
        return repository.fullSearch(text, minDate, maxDate);
    }
}