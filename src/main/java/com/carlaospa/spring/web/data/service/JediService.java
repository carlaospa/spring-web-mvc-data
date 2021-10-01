package com.carlaospa.spring.web.data.service;

import com.carlaospa.spring.web.data.excepition.JediNotFoundException;
import com.carlaospa.spring.web.data.model.Jedi;
import com.carlaospa.spring.web.data.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    private JediRepository repository;

    public List<Jedi> findAll() {
        return repository.findAll();
    }

    public Jedi findById(Long id) {

        final Optional<Jedi> jedi = repository.findById(id);
        if (jedi.isPresent()){
            return jedi.get();
        }else {
            throw new JediNotFoundException();
        }
    }

    public Jedi save(Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi update(final Jedi dto, final Long id) {

        final Optional<Jedi> jediSalvo = repository.findById(id);
        final Jedi jedi;

        if (jediSalvo.isPresent()){
            jedi = jediSalvo.get();
        }else{
            throw new JediNotFoundException();
        }

        jedi.setName(dto.getName());
        jedi.setLastName(dto.getLastName());

        return repository.save(jedi);
    }

    public void delete(Long id) {

        final Jedi jedi = findById(id);
        repository.delete(jedi);
    }

}
