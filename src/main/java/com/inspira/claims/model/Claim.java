package com.inspira.claims.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "claim_number", unique = true, nullable = false)
    private String claimNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClaimType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClaimStatus status = ClaimStatus.SUBMITTED;

    @NotBlank
    @Column(name = "member_id", nullable = false)
    private String memberId;

    @NotBlank
    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @NotNull
    @Column(name = "service_from_date", nullable = false)
    private LocalDate serviceFromDate;

    @NotNull
    @Column(name = "service_to_date", nullable = false)
    private LocalDate serviceToDate;

    @Column(name = "billed_amount", precision = 12, scale = 2)
    private BigDecimal billedAmount;

    @Column(name = "allowed_amount", precision = 12, scale = 2)
    private BigDecimal allowedAmount;

    @Column(name = "paid_amount", precision = 12, scale = 2)
    private BigDecimal paidAmount;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "claim", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClaimLine> lines;

    @PreUpdate
    void onUpdate() { this.updatedAt = LocalDateTime.now(); }

    // Getters and setters omitted for brevity — use Lombok in real projects
    public UUID getId() { return id; }
    public String getClaimNumber() { return claimNumber; }
    public void setClaimNumber(String n) { this.claimNumber = n; }
    public ClaimType getType() { return type; }
    public void setType(ClaimType t) { this.type = t; }
    public ClaimStatus getStatus() { return status; }
    public void setStatus(ClaimStatus s) { this.status = s; }
    public String getMemberId() { return memberId; }
    public void setMemberId(String m) { this.memberId = m; }
    public String getProviderId() { return providerId; }
    public void setProviderId(String p) { this.providerId = p; }
    public LocalDate getServiceFromDate() { return serviceFromDate; }
    public void setServiceFromDate(LocalDate d) { this.serviceFromDate = d; }
    public LocalDate getServiceToDate() { return serviceToDate; }
    public void setServiceToDate(LocalDate d) { this.serviceToDate = d; }
    public BigDecimal getBilledAmount() { return billedAmount; }
    public void setBilledAmount(BigDecimal a) { this.billedAmount = a; }
    public BigDecimal getAllowedAmount() { return allowedAmount; }
    public void setAllowedAmount(BigDecimal a) { this.allowedAmount = a; }
    public BigDecimal getPaidAmount() { return paidAmount; }
    public void setPaidAmount(BigDecimal a) { this.paidAmount = a; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public List<ClaimLine> getLines() { return lines; }
    public void setLines(List<ClaimLine> l) { this.lines = l; }
}
