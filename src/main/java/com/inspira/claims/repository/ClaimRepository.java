package com.inspira.claims.repository;

import com.inspira.claims.model.Claim;
import com.inspira.claims.model.ClaimStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ClaimRepository extends JpaRepository<Claim, UUID> {
    List<Claim> findByMemberId(String memberId);
    List<Claim> findByStatus(ClaimStatus status);
    List<Claim> findByMemberIdAndStatus(String memberId, ClaimStatus status);
}
