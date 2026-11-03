package com.inspira.claims.service;

import com.inspira.claims.model.*;
import com.inspira.claims.repository.ClaimRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class ClaimService {

    private final ClaimRepository repo;

    public ClaimService(ClaimRepository repo) {
        this.repo = repo;
    }

    public List<Claim> findAll(String memberId, String status) {
        if (memberId != null && status != null)
            return repo.findByMemberIdAndStatus(memberId, ClaimStatus.valueOf(status));
        if (memberId != null) return repo.findByMemberId(memberId);
        if (status != null)   return repo.findByStatus(ClaimStatus.valueOf(status));
        return repo.findAll();
    }

    public Claim findById(UUID id) {
        return repo.findById(id).orElseThrow(() ->
            new IllegalArgumentException("Claim not found: " + id));
    }

    @Transactional
    public Claim submit(Claim claim) {
        claim.setClaimNumber(generateClaimNumber());
        claim.setStatus(ClaimStatus.SUBMITTED);
        BigDecimal total = claim.getLines().stream()
            .map(ClaimLine::getBilledAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        claim.setBilledAmount(total);
        int i = 1;
        for (ClaimLine line : claim.getLines()) {
            line.setClaim(claim);
            line.setLineNumber(i++);
        }
        return repo.save(claim);
    }

    @Transactional
    public Claim updateStatus(UUID id, ClaimStatus newStatus) {
        Claim claim = findById(id);
        claim.setStatus(newStatus);
        return repo.save(claim);
    }

    private String generateClaimNumber() {
        return "CLM" + System.currentTimeMillis();
    }
}
