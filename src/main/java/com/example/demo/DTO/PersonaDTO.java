package com.example.demo.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class PersonaDTO {
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String phone;
}
