package com.awn.appnominarest.controller;

import com.awn.appnominarest.dto.EmpleadoDTO;
import com.awn.appnominarest.dto.NominasDTO;
import com.awn.appnominarest.service.IEmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    // Endpoints para Empleados

    @GetMapping("/empleados")
    public List<EmpleadoDTO> allEmpleados() {
        return empleadoService.findAllEmpleados();
    }

    @GetMapping("/empleados/{dni}")
    public ResponseEntity<EmpleadoDTO> empleadoByDni(@PathVariable String dni) {
        return empleadoService.findEmpleadoByDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/empleados")
    public ResponseEntity<EmpleadoDTO> newEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        EmpleadoDTO savedEmpleado = empleadoService.saveEmpleado(empleadoDTO);
        return ResponseEntity.ok(savedEmpleado);
    }

    @PutMapping("/empleados/{dni}")
    public ResponseEntity<EmpleadoDTO> editEmpleado(@PathVariable String dni, @RequestBody EmpleadoDTO empleadoDTO) {
        try {
            EmpleadoDTO updatedEmpleado = empleadoService.updateEmpleado(dni, empleadoDTO);
            return ResponseEntity.ok(updatedEmpleado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/empleados/{dni}")
    public ResponseEntity<Void> eraseEmpleado(@PathVariable String dni) {
        empleadoService.deleteEmpleado(dni);
        return ResponseEntity.noContent().build();
    }

    // Endpoints para Nóminas

    @GetMapping("/nominas")
    public List<NominasDTO> allNominas() {
        return empleadoService.findAllNominas();
    }

    @GetMapping("/nominas/{dni}")
    public ResponseEntity<NominasDTO> nominaByDni(@PathVariable String dni) {
        return empleadoService.findNominasByDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
