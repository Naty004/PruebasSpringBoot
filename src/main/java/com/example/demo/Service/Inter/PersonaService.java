package com.example.demo.Service.Inter;

import com.example.demo.DTO.PersonaDTO;

import java.util.List;

public interface PersonaService {

    PersonaDTO getById(Long id);
    PersonaDTO create(PersonaDTO personaDTO);
    String getAddress(Long id);
    String getPhone(Long id);
    List<PersonaDTO> getAllPersonaList();

}
