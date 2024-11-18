package com.awn.appnominarest.service;

import com.awn.appnominarest.model.Empleado;
import com.awn.appnominarest.model.Nominas;
import com.awn.appnominarest.repository.EmpleadoRepository;
import com.awn.appnominarest.repository.NominasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService  implements IEmpleadoService{

    private final EmpleadoRepository empleadoRepository;
    private final NominasRepository nominasRepository;

    public EmpleadoService(EmpleadoRepository empRepository, NominasRepository nomRepository) {
        this.empleadoRepository = empRepository;
        this.nominasRepository = nomRepository;
    }

    @Override
    public List<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> findEmpleadoByDni(String dni) {
        return empleadoRepository.findById(dni);
    }

    @Override
    public Empleado saveEmpleado(Empleado emp) {
        return empleadoRepository.save(emp);
    }

    @Override
    public void deleteEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }

    @Override
    public Empleado updateEmpleado(String dni, Empleado emp) {
        return empleadoRepository.findById(dni)
                .map(existingEmp -> {
                    existingEmp.setNombre(emp.getNombre());
                    existingEmp.setSexo(emp.getSexo());
                    existingEmp.setCategoria(emp.getCategoria());
                    existingEmp.setAnyos(emp.getAnyos());
                    return empleadoRepository.save(existingEmp);
                })
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Override
    public List<Nominas> findAllNominas() {
        return nominasRepository.findAll();
    }

    @Override
    public Optional<Nominas> findNominasByDni(String dni) {
        return nominasRepository.findById(dni);
    }

}
