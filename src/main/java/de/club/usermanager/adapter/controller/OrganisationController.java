package de.club.usermanager.adapter.controller;

import de.club.usermanager.core.outport.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganisationController {


  private final OrganisationService oganisationService;

    @Autowired
    public OrganisationController(OrganisationService oganisationService) {
        this.oganisationService = oganisationService;
    }
}
