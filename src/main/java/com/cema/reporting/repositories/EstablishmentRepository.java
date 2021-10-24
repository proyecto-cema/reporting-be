package com.cema.reporting.repositories;

import com.cema.reporting.entities.CemaEstablishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentRepository extends JpaRepository<CemaEstablishment, Long> {

    CemaEstablishment findCemaEstablishmentByCuig(String cuig);
}
