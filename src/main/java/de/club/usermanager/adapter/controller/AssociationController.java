package de.club.usermanager.adapter.controller;

import de.club.usermanager.adapter.controller.mapper.AddressMapper;
import de.club.usermanager.core.exceptions.NotFoundException;
import de.club.usermanager.core.port.in.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static de.club.usermanager.adapter.controller.mapper.MapToDtoHelper.mapAddressToDto;

@RestController
@RequestMapping("association")
public class AssociationController {

     private final AssociationService associationService;

     @Autowired
    public AssociationController(AssociationService associationService) {
        this.associationService = associationService;
    }


    @PostMapping(path = "create")
    public ResponseEntity<Boolean> createAssociation(@RequestBody AddressMapper addressMapper,
                                                     @RequestParam String associationName,
                                                     @RequestParam long organisationId) throws NotFoundException {
        associationService.createAssociation(associationName, mapAddressToDto(addressMapper), organisationId);
        return ResponseEntity.ok().build();
    }


}
