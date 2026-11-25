package com.tylercave.royalty_ledger.rightsholder;

import com.tylercave.royalty_ledger.rightsholder.dto.CreateRightsHolderRequest;
import com.tylercave.royalty_ledger.rightsholder.dto.RightsHolderResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/rights-holders")
public class RightsHolderController {
    private final RightsHolderService rightsHolderService;
    private final RightsHolderRepository rightsHolderRepository;

    public RightsHolderController(RightsHolderService rightsHolderService, RightsHolderRepository rightsHolderRepository){
        this.rightsHolderService = rightsHolderService;
        this.rightsHolderRepository = rightsHolderRepository;
    }

    @PostMapping
    public ResponseEntity<RightsHolderResponse> createRightsHolder(@Valid @RequestBody CreateRightsHolderRequest request) {
        RightsHolderResponse response = rightsHolderService.create(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    public RightsHolderResponse getById(@PathVariable Long id) {
        return rightsHolderService.getById(id);
    }

    @GetMapping()
    public List<RightsHolderResponse> getAll() {
        return rightsHolderService.findAll();
    }

}
