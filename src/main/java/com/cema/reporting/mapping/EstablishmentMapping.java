package com.cema.reporting.mapping;

import com.cema.reporting.domain.Establishment;
import com.cema.reporting.entities.CemaEstablishment;

public interface EstablishmentMapping {

    Establishment mapEntityToDomain(CemaEstablishment cemaEstablishment);

    CemaEstablishment mapDomainToEntity(Establishment establishment);

    CemaEstablishment updateDomainWithEntity(Establishment establishment, CemaEstablishment CemaEstablishment);
}
