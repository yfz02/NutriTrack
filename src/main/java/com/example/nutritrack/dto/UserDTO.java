package com.example.nutritrack.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String nombre;
    private double peso;
    private String sexo;
    private String actividad;
    private int calorias;
}
