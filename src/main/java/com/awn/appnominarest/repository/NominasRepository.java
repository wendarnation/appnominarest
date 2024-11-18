package com.awn.appnominarest.repository;

import com.awn.appnominarest.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NominasRepository extends JpaRepository<Nominas, String>, JpaSpecificationExecutor<Nominas> {
}
