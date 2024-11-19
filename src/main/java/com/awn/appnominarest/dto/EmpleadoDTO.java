package com.awn.appnominarest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpleadoDTO {
    private String dni;      // Identificador único
    private String nombre;   // Nombre del empleado
    private String sexo;     // Género del empleado
    private int categoria;   // Categoría (1-10)
    private int anyos;       // Años de experiencia

    // Constructor personalizado
    public EmpleadoDTO(String dni, String nombre, String sexo, int categoria, int anyos) {
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
        this.categoria = categoria;
        this.anyos = anyos;
    }
}

