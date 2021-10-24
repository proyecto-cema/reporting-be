package com.cema.reporting.services.authorization;

public interface AuthorizationService {

    String getCurrentUserCuig();

    boolean isOnTheSameEstablishment(String cuig);

    boolean isAdmin();
}
