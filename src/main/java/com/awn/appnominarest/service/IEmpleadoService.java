package com.awn.appnominarest.service;

import com.awn.appnominarest.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IEmpleadoService {

    List<EmpleadoDTO> findAllEmpleados();

    Optional<EmpleadoDTO> findEmpleadoByDni(String dni);

    EmpleadoDTO saveEmpleado(EmpleadoDTO emp);

    void deleteEmpleado(String dni);

    EmpleadoDTO updateEmpleado(String dni, EmpleadoDTO emp);


//    Métodos para nóminas

    List<NominasDTO> findAllNominas();

    Optional<NominasDTO> findNominasByDni(String dni);
}
