package com.example.demo.Controller;

import com.example.demo.DTO.PersonaDTO;
import com.example.demo.Service.Inter.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/create")
    public PersonaDTO create(@RequestBody @Valid PersonaDTO personadto) {

        return personaService.create(personadto);
    }

    @GetMapping("/all")
    public List<PersonaDTO> getAll()
    {
        return personaService.getAllPersonaList();
    }

    @GetMapping("/{id}")
    public PersonaDTO getById(@PathVariable Long id)
    {
        return personaService.getById(id);
    }

    @GetMapping("/address/{id}")
    public String getAddress(@PathVariable long id)
    {
        return personaService.getAddress(id);
    }

    @GetMapping("/phone/{id}")
    public String getPhone(@PathVariable long id)
    {
        return personaService.getPhone(id);
    }
}
