package com.awn.appnominarest.util;

import com.awn.appnominarest.dto.EmpleadoDTO;
import com.awn.appnominarest.dto.NominasDTO;
import com.awn.appnominarest.model.Empleado;
import com.awn.appnominarest.model.Nominas;

public class DTOMapper {

    // Métodos de mapeo para Empleado
    public static EmpleadoDTO toEmpleadoDTO(Empleado empleado) {
        return new EmpleadoDTO(
                empleado.getDni(),
                empleado.getNombre(),
                empleado.getSexo(),
                empleado.getCategoria(),
                empleado.getAnyos()
        );
    }

    public static Empleado toEmpleadoEntity(EmpleadoDTO dto) {
        return new Empleado(
                dto.getDni(),
                dto.getNombre(),
                dto.getSexo(),
                dto.getCategoria(),
                dto.getAnyos()
        );
    }

    // Métodos de mapeo para Nóminas
    public static NominasDTO toNominasDTO(Nominas nominas) {
        return new NominasDTO(
                nominas.getDni(),
                nominas.getSueldo(),
                toEmpleadoDTO(nominas.getEmpleado())
        );
    }

    public static Nominas toNominasEntity(NominasDTO dto) {
        Nominas nominas = new Nominas();
        nominas.setDni(dto.getDni());
        nominas.setSueldo(dto.getSueldo());
        nominas.setEmpleado(toEmpleadoEntity(dto.getEmpleado()));
        return nominas;
    }
}
