package com.inspira.claims.controller;

import com.inspira.claims.model.Claim;
import com.inspira.claims.model.ClaimStatus;
import com.inspira.claims.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin
public class ClaimController {

    private final ClaimService service;

    public ClaimController(ClaimService service) {
        this.service = service;
    }

    @GetMapping
    public List<Claim> list(
            @RequestParam(required = false) String memberId,
            @RequestParam(required = false) String status) {
        return service.findAll(memberId, status);
    }

    @GetMapping("/{id}")
    public Claim get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Claim submit(@Valid @RequestBody Claim claim) {
        return service.submit(claim);
    }

    @PatchMapping("/{id}/status")
    public Claim updateStatus(@PathVariable UUID id, @RequestParam ClaimStatus status) {
        return service.updateStatus(id, status);
    }
}
