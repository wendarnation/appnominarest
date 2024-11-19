package com.awn.appnominarest.service;

import com.awn.appnominarest.dto.EmpleadoDTO;
import com.awn.appnominarest.dto.NominasDTO;
import com.awn.appnominarest.model.Empleado;
import com.awn.appnominarest.repository.EmpleadoRepository;
import com.awn.appnominarest.repository.NominasRepository;
import com.awn.appnominarest.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService implements IEmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final NominasRepository nominasRepository;

    public EmpleadoService(EmpleadoRepository empRepository, NominasRepository nomRepository) {
        this.empleadoRepository = empRepository;
        this.nominasRepository = nomRepository;
    }

    // Métodos de empleados

    @Override
    public List<EmpleadoDTO> findAllEmpleados() {
        return empleadoRepository.findAll()
                .stream()
                .map(DTOMapper::toEmpleadoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmpleadoDTO> findEmpleadoByDni(String dni) {
        return empleadoRepository.findById(dni)
                .map(DTOMapper::toEmpleadoDTO);
    }

    @Override
    public EmpleadoDTO saveEmpleado(EmpleadoDTO empDTO) {
        Empleado empleado = DTOMapper.toEmpleadoEntity(empDTO);
        Empleado savedEmpleado = empleadoRepository.save(empleado);
        return DTOMapper.toEmpleadoDTO(savedEmpleado);
    }

    @Override
    public void deleteEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }

    @Override
    public EmpleadoDTO updateEmpleado(String dni, EmpleadoDTO empDTO) {
        return empleadoRepository.findById(dni)
                .map(existingEmp -> {
                    existingEmp.setNombre(empDTO.getNombre());
                    existingEmp.setSexo(empDTO.getSexo());
                    existingEmp.setCategoria(empDTO.getCategoria());
                    existingEmp.setAnyos(empDTO.getAnyos());
                    Empleado updatedEmpleado = empleadoRepository.save(existingEmp);
                    return DTOMapper.toEmpleadoDTO(updatedEmpleado);
                })
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    // Métodos de nóminas

    @Override
    public List<NominasDTO> findAllNominas() {
        return nominasRepository.findAll()
                .stream()
                .map(DTOMapper::toNominasDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NominasDTO> findNominasByDni(String dni) {
        return nominasRepository.findById(dni)
                .map(DTOMapper::toNominasDTO);
    }
}
