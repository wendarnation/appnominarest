package com.awn.appnominarest.repository;

import com.awn.appnominarest.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String>, JpaSpecificationExecutor<Empleado> {



}
