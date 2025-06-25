package de.club.usermanager.adapter.controller;

import de.club.usermanager.adapter.controller.mapper.AddressMapper;
import de.club.usermanager.core.port.in.OrganisationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static de.club.usermanager.adapter.controller.mapper.MapToDtoHelper.mapAddressToDto;

@RestController
@RequestMapping("Organisation")
public class OrganisationController {

  private final OrganisationService organisationService;

    private static final Logger logger = LogManager.getLogger(OrganisationService.class);

    @Autowired
    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @PostMapping(path = "create")
    public ResponseEntity<Boolean> createOrganisation(@RequestBody AddressMapper addressMapper, @RequestParam String name) {
        organisationService.createOrganisation(name, mapAddressToDto(addressMapper));
        logger.info("organisation {} is created",name );

        return ResponseEntity.ok().build();
    }




    @PostMapping(path = "addAdmin")
    public ResponseEntity<Boolean> addAdminToOrganisation( @RequestParam long organisationId, @RequestParam long userId) {
         organisationService.addAdminOrganisation(organisationId, userId);
        logger.info("user  {} is adding as admin in the organisation {} ",userId,organisationId );

        return ResponseEntity.ok().build();
    }



}
