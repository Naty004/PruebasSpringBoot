package com.example.demo.Mapper;

import com.example.demo.DTO.PersonaDTO;
import com.example.demo.Entity.Persona;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaDTO toDTO(Persona user);
    Persona toEntity(PersonaDTO user);
}