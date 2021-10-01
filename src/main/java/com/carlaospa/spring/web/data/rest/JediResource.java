package com.carlaospa.spring.web.data.rest;

import com.carlaospa.spring.web.data.excepition.JediNotFoundException;
import com.carlaospa.spring.web.data.model.Jedi;
import com.carlaospa.spring.web.data.repository.JediRepository;
import com.carlaospa.spring.web.data.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediService jediService;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi(){

        return jediService.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi>  getJedi(@PathVariable("id") Long id){
        final Jedi jedi = jediService.findById(id);
        return ResponseEntity.ok(jedi);
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi){
        return jediService.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi dto){

        return ResponseEntity.ok(jediService.update(dto, id));
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){

       jediService.delete(id);
    }


}
