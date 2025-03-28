package com.bridgelabz.mapInterface;
import java.util.*;
import java.time.LocalDate;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate,
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return String.format("%s (%s, Expires: %s, %s, $%.2f)",
                policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}

public class PolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>(); // Fast lookup by policy number
    private Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>(); // Insertion order
    private TreeMap<LocalDate, List<Policy>> policiesByExpiry = new TreeMap<>(); // Sorted by expiry

    // Add a new policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);

        policiesByExpiry.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Get policy by number
    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Get policies expiring within next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> result = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate cutoff = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : policiesByExpiry.entrySet()) {
            if (!entry.getKey().isBefore(today) && !entry.getKey().isAfter(cutoff)) {
                result.addAll(entry.getValue());
            }
        }

        return result;
    }

    // Get policies by policyholder
    public List<Policy> getPoliciesByHolder(String policyholderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<Policy>>> it = policiesByExpiry.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = it.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy policy : entry.getValue()) {
                    policyMap.remove(policy.policyNumber);
                    orderedPolicyMap.remove(policy.policyNumber);
                }
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Add sample policies
        manager.addPolicy(new Policy("P001", "John Doe", LocalDate.now().plusDays(15), "Auto", 500.0));
        manager.addPolicy(new Policy("P002", "Jane Smith", LocalDate.now().plusMonths(2), "Home", 1200.0));
        manager.addPolicy(new Policy("P003", "John Doe", LocalDate.now().minusDays(1), "Life", 300.0));

        // Test operations
        System.out.println("Policy P001: " + manager.getPolicy("P001"));
        System.out.println("Policies expiring soon: " + manager.getPoliciesExpiringSoon());
        System.out.println("John Doe's policies: " + manager.getPoliciesByHolder("John Doe"));

        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("After removing expired policies, total policies: " + manager.policyMap.size());
    }
}
