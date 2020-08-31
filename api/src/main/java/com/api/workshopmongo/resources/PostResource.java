package com.api.workshopmongo.resources;

import com.api.workshopmongo.domain.Post;
import com.api.workshopmongo.resources.util.URL;
import com.api.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

//    @RequestMapping(value="/titlesearch", method=RequestMethod.GET)
//    public ResponseEntity<List<Post>> findTitle(@RequestParam(value = "text", defaultValue = "") String text) {
//        text = URL.decodeParam(text);
//        List<Post> list = service.findByTitle(text);
//        return ResponseEntity.ok().body(list);
//    }

    @RequestMapping(value="/titlesearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> searchTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.searchTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
