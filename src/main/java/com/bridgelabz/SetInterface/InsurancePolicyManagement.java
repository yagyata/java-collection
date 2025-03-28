package com.bridgelabz.SetInterface;
import java.util.*;
import java.time.LocalDate;

class Policy implements Comparable<Policy> {
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
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Policy Number: '" + policyNumber + '\'' +
                ", Policy holder Name: '" + policyholderName + '\'' +
                ", Expiry Date: " + expiryDate +
                ", Coverage Type: '" + coverageType + '\'' +
                ", Premium Amount: " + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // Get all unique policies
    public Set<Policy> getAllPolicies() {
        return new HashSet<>(hashSet);
    }

    // Get policies expiring soon (within next 30 days)
    public Set<Policy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        Set<Policy> result = new HashSet<>();
        for (Policy policy : treeSet) {
            if (policy.expiryDate.isAfter(today) && policy.expiryDate.isBefore(thirtyDaysLater)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Get policies by coverage type
    public Set<Policy> getPoliciesByCoverage(String coverageType) {
        Set<Policy> result = new HashSet<>();
        for (Policy policy : hashSet) {
            if (policy.coverageType.equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Find duplicate policies (based on policy number)
    public Set<Policy> findDuplicatePolicies(Collection<Policy> policies) {
        Set<Policy> duplicates = new HashSet<>();
        Set<String> seenNumbers = new HashSet<>();

        for (Policy policy : policies) {
            if (!seenNumbers.add(policy.policyNumber)) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    // Performance comparison methods
    public void comparePerformance() {
        Policy samplePolicy = new Policy("P100", "John Doe", LocalDate.now().plusMonths(6),
                "Auto", 500.0);

        // Add operation
        long start = System.nanoTime();
        hashSet.add(samplePolicy);
        long hashSetAddTime = System.nanoTime() - start;

        start = System.nanoTime();
        linkedHashSet.add(samplePolicy);
        long linkedHashSetAddTime = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.add(samplePolicy);
        long treeSetAddTime = System.nanoTime() - start;

        // Search operation
        start = System.nanoTime();
        hashSet.contains(samplePolicy);
        long hashSetSearchTime = System.nanoTime() - start;

        start = System.nanoTime();
        linkedHashSet.contains(samplePolicy);
        long linkedHashSetSearchTime = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.contains(samplePolicy);
        long treeSetSearchTime = System.nanoTime() - start;

        // Remove operation
        start = System.nanoTime();
        hashSet.remove(samplePolicy);
        long hashSetRemoveTime = System.nanoTime() - start;

        start = System.nanoTime();
        linkedHashSet.remove(samplePolicy);
        long linkedHashSetRemoveTime = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.remove(samplePolicy);
        long treeSetRemoveTime = System.nanoTime() - start;

        // Print results
        System.out.println("Performance Comparison (nanoseconds):");
        System.out.printf("Add - HashSet: %d, LinkedHashSet: %d, TreeSet: %d\n",
                hashSetAddTime, linkedHashSetAddTime, treeSetAddTime);
        System.out.printf("Search - HashSet: %d, LinkedHashSet: %d, TreeSet: %d\n",
                hashSetSearchTime, linkedHashSetSearchTime, treeSetSearchTime);
        System.out.printf("Remove - HashSet: %d, LinkedHashSet: %d, TreeSet: %d\n",
                hashSetRemoveTime, linkedHashSetRemoveTime, treeSetRemoveTime);
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();

        // Add sample policies
        system.addPolicy(new Policy("P001", "Alice", LocalDate.of(2023, 12, 31), "Health", 200.0));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.of(2023, 11, 15), "Auto", 150.0));
        system.addPolicy(new Policy("P003", "Charlie", LocalDate.of(2024, 1, 20), "Home", 300.0));
        system.addPolicy(new Policy("P004", "David", LocalDate.of(2023, 10, 5), "Auto", 180.0));

        // Test operations
        System.out.println("All Policies:");
        system.getAllPolicies().forEach(System.out::println);

        System.out.println("\nPolicies Expiring Soon:");
        system.getPoliciesExpiringSoon().forEach(System.out::println);

        System.out.println("\nAuto Policies:");
        system.getPoliciesByCoverage("Auto").forEach(System.out::println);

        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        system.comparePerformance();
    }
}
