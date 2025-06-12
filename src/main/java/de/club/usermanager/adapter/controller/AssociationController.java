package de.club.usermanager.adapter.controller;

import de.club.usermanager.core.outport.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssociationController {

     private final AssociationService associationService;

     @Autowired
    public AssociationController(AssociationService associationService) {
        this.associationService = associationService;
    }
}
