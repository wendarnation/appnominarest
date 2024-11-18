package com.awn.appnominarest.controller;

import com.awn.appnominarest.model.Empleado;
import com.awn.appnominarest.model.Nominas;
import com.awn.appnominarest.service.*;
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
    public List<Empleado> allEmpleados() {
        return empleadoService.findAllEmpleados();
    }

    @GetMapping("/empleados/{dni}")
    public ResponseEntity<Empleado> EmpleadoByDni(@PathVariable String dni) {
        return empleadoService.findEmpleadoByDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/empleados")
    public Empleado newEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    @PutMapping("/empleados/{dni}")
    public ResponseEntity<Empleado> editEmpleado(@PathVariable String dni, @RequestBody Empleado empleado) {
        try {
            return ResponseEntity.ok(empleadoService.updateEmpleado(dni, empleado));
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

//    No hay métodos para crear o cambiar nóminas ya que se hace directamente
//    en empleado. La db tiene triggers

    @GetMapping("/nominas")
    public List<Nominas> allNominas() {
        return empleadoService.findAllNominas();
    }

    @GetMapping("/nominas/{dni}")
    public ResponseEntity<Nominas> NominaByDni(@PathVariable String dni) {
        return empleadoService.findNominasByDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
