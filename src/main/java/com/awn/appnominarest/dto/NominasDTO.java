package com.awn.appnominarest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NominasDTO {
    private String dni;        // Identificador único del empleado
    private Integer sueldo;    // Sueldo asociado a la nómina
    private EmpleadoDTO empleado; // Detalles del empleado (opcional)

    // Constructor personalizado
    public NominasDTO(String dni, Integer sueldo, EmpleadoDTO empleado) {
        this.dni = dni;
        this.sueldo = sueldo;
        this.empleado = empleado;
    }
}

