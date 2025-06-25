package de.club.usermanager.adapter.controller;

import de.club.usermanager.adapter.controller.mapper.AddressMapper;
import de.club.usermanager.core.exceptions.NotFoundException;
import de.club.usermanager.core.port.in.AssociationService;
import de.club.usermanager.feign.eventservice.ieventservice.IEventService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static de.club.usermanager.adapter.controller.mapper.MapToDtoHelper.mapAddressToDto;

@RestController
@RequestMapping("association")
public class AssociationController {

    private static final Logger logger = LogManager.getLogger(AssociationController.class);
     private final AssociationService associationService;
    private final IEventService ieventService;
     @Autowired
    public AssociationController(AssociationService associationService, IEventService ieventService) {
        this.associationService = associationService;
         this.ieventService = ieventService;
     }


    @PostMapping(path = "create")
    public ResponseEntity<Boolean> createAssociation(@RequestBody AddressMapper addressMapper,
                                                     @RequestParam String associationName,
                                                     @RequestParam long organisationId){
        logger.info("association creating...");
         try {
           associationService.createAssociation(associationName, mapAddressToDto(addressMapper), organisationId);
       }catch (NotFoundException notFoundException) {
           logger.error("error creation: {}",notFoundException.getMessage());
           return ResponseEntity.internalServerError().build();
       }
        logger.info("association is created");
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "addEventToAssociation")
    public ResponseEntity<Boolean> addEventToAssociation(@RequestParam long eventId, @RequestParam long associationId) {
        return ResponseEntity.ok(ieventService.addEventToAssociation(eventId, associationId));
    }

    @PostMapping(path = "removeEventToAssociation")
    public ResponseEntity<Boolean> removeEventToAssociation(@RequestParam long eventId, @RequestParam long associationId) {
        return ResponseEntity.ok(ieventService.removeEventToAssociation(eventId, associationId));
    }
}
