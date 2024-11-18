package com.awn.appnominarest.service;

import com.awn.appnominarest.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IEmpleadoService {

    List<Empleado> findAllEmpleados();

    Optional<Empleado> findEmpleadoByDni(String dni);

    Empleado saveEmpleado(Empleado emp);

    void deleteEmpleado(String dni);

    Empleado updateEmpleado(String dni, Empleado emp);


//    Métodos para nóminas

    List<Nominas> findAllNominas();

    Optional<Nominas> findNominasByDni(String dni);
}
