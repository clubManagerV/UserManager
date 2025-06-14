package de.club.usermanager.adapter.controller;

import de.club.usermanager.adapter.controller.mapper.AddressMapper;
import de.club.usermanager.core.port.in.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static de.club.usermanager.adapter.controller.mapper.MapToDtoHelper.mapAddressToDto;

@RestController
@RequestMapping("Organisation")
public class OrganisationController {

  private final OrganisationService organisationService;

    @Autowired
    public OrganisationController(OrganisationService oganisationService) {
        this.organisationService = oganisationService;
    }


    @PostMapping(path = "userSubscribeEvent")
    public ResponseEntity<Boolean> createOrganisation(@RequestBody AddressMapper addressMapper, @RequestParam String userId) {
        organisationService.createOrganisation(userId, mapAddressToDto(addressMapper));
        return ResponseEntity.ok().build();
    }




}
