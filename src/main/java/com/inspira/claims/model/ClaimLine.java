package com.inspira.claims.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "claim_lines")
public class ClaimLine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "claim_id", nullable = false)
    private Claim claim;

    @Column(name = "line_number", nullable = false)
    private int lineNumber;

    @Column(name = "procedure_code", nullable = false, length = 10)
    private String procedureCode;

    @Column(name = "diagnosis_code", nullable = false, length = 10)
    private String diagnosisCode;

    @Column(name = "service_date", nullable = false)
    private LocalDate serviceDate;

    @Column(nullable = false)
    private int units;

    @Column(length = 2)
    private String modifier;

    @Column(name = "billed_amount", precision = 12, scale = 2)
    private BigDecimal billedAmount;

    @Column(name = "allowed_amount", precision = 12, scale = 2)
    private BigDecimal allowedAmount;

    public UUID getId() { return id; }
    public Claim getClaim() { return claim; }
    public void setClaim(Claim c) { this.claim = c; }
    public int getLineNumber() { return lineNumber; }
    public void setLineNumber(int n) { this.lineNumber = n; }
    public String getProcedureCode() { return procedureCode; }
    public void setProcedureCode(String c) { this.procedureCode = c; }
    public String getDiagnosisCode() { return diagnosisCode; }
    public void setDiagnosisCode(String c) { this.diagnosisCode = c; }
    public LocalDate getServiceDate() { return serviceDate; }
    public void setServiceDate(LocalDate d) { this.serviceDate = d; }
    public int getUnits() { return units; }
    public void setUnits(int u) { this.units = u; }
    public String getModifier() { return modifier; }
    public void setModifier(String m) { this.modifier = m; }
    public BigDecimal getBilledAmount() { return billedAmount; }
    public void setBilledAmount(BigDecimal a) { this.billedAmount = a; }
    public BigDecimal getAllowedAmount() { return allowedAmount; }
    public void setAllowedAmount(BigDecimal a) { this.allowedAmount = a; }
}
