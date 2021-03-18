package com.gmail.artsiombaranau.spring5petclinic.services.jpa;

import com.gmail.artsiombaranau.spring5petclinic.model.Visit;
import com.gmail.artsiombaranau.spring5petclinic.repositories.VisitRepository;
import com.gmail.artsiombaranau.spring5petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VisitServiceJPA implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceJPA(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
