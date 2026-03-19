package com.example.demo.Service.Impl;

import com.example.demo.DTO.PersonaDTO;
import com.example.demo.Entity.Persona;
import com.example.demo.Mapper.PersonaMapper;
import com.example.demo.Repository.PersonaRepository;
import com.example.demo.Service.Inter.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaImplement implements PersonaService {

    @Autowired
    private PersonaRepository repository;

    @Autowired
    private PersonaMapper mapper;

    @Override
    public PersonaDTO getById(Long id) {
        Persona persona = repository.findById(id).orElse(null);
        return mapper.toDTO(persona);
    }

    @Override
    public PersonaDTO create(PersonaDTO personaDTO) {
        Persona persona = mapper.toEntity(personaDTO);
        Persona saved = repository.save(persona);
        return mapper.toDTO(saved);
    }

    @Override
    public String getAddress(Long id) {
        Persona persona = repository.findById(id).orElse(null);
        return persona != null ? persona.getAddress() : null;
    }

    @Override
    public String getPhone(Long id) {
        Persona persona = repository.findById(id).orElse(null);
        return persona != null ? persona.getPhone() : null;
    }

    @Override
    public List<PersonaDTO> getAllPersonaList() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}