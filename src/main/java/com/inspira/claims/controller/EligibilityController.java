package com.inspira.claims.controller;

import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/eligibility")
@CrossOrigin
public class EligibilityController {

    // Stub — replace with real member/plan lookup in production
    @PostMapping("/check")
    public Map<String, Object> check(@RequestBody Map<String, String> req) {
        String memberId = req.get("memberId");
        return Map.of(
            "memberId", memberId,
            "memberName", "Sample Member",
            "planId", "PLN-001",
            "planName", "Commercial PPO",
            "eligibleFrom", LocalDate.now().withDayOfYear(1).toString(),
            "eligibleTo", LocalDate.now().withMonth(12).withDayOfMonth(31).toString(),
            "copay", 30,
            "deductible", 1500,
            "deductibleMet", 400,
            "outOfPocketMax", 5000,
            "outOfPocketMet", 400,
            "isEligible", true
        );
    }
}
