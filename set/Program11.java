package set;
// package assignment5.setInterfaceAndClass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Program11 {

    static class Policy implements Comparable<Policy> {
        private String policyNumber;
        private String policyholderName;
        private LocalDate expiryDate;
        private String coverageType;
        private double premiumAmount;

        public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public String getPolicyholderName() {
            return policyholderName;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public String getCoverageType() {
            return coverageType;
        }

        public double getPremiumAmount() {
            return premiumAmount;
        }

        @Override
        public int compareTo(Policy other) {
            return this.expiryDate.compareTo(other.expiryDate);
        }

        @Override
        public String toString() {
            return "Policy [policyNumber=" + policyNumber + ", policyholderName=" + policyholderName + ", expiryDate="
                    + expiryDate + ", coverageType=" + coverageType + ", premiumAmount=" + premiumAmount + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Policy)) return false;
            Policy policy = (Policy) o;
            return Objects.equals(policyNumber, policy.policyNumber) &&
                   Objects.equals(policyholderName, policy.policyholderName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber, policyholderName);
        }

    }

    static class PolicyManager {
        private Set<Policy> hashSet = new HashSet<>();
        private Set<Policy> linkedHashSet = new LinkedHashSet<>();
        private Set<Policy> treeSet = new TreeSet<>();

        public void addPolicy(Policy policy) {
            hashSet.add(policy);
            linkedHashSet.add(policy);
            treeSet.add(policy);
        }

        public Set<Policy> getAllUniquePolicies() {
            return hashSet;
        }

        public Set<Policy> getPoliciesExpiringSoon() {
            LocalDate today = LocalDate.now();
            Set<Policy> expiringSoon = new HashSet<>();
            for (Policy policy : treeSet) {
                if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                    expiringSoon.add(policy);
                }
            }
            return expiringSoon;
        }

        public Set<Policy> getPoliciesByCoverage(String coverageType) {
            Set<Policy> result = new HashSet<>();
            for (Policy policy : hashSet) {
                if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                    result.add(policy);
                }
            }
            return result;
        }

        public Set<Policy> findDuplicatePolicies() {
            Map<String, List<Policy>> policyMap = new HashMap<>();
            for (Policy policy : linkedHashSet) {
                policyMap.putIfAbsent(policy.getPolicyNumber(), new ArrayList<>());
                policyMap.get(policy.getPolicyNumber()).add(policy);
            }

            Set<Policy> duplicates = new HashSet<>();
            for (List<Policy> policies : policyMap.values()) {
                if (policies.size() > 1) {
                    duplicates.addAll(policies);
                }
            }
            return duplicates;
        }



        public void comparePerformance(int numberOfPolicies) {
            List<Policy> policies = generateSamplePolicies(numberOfPolicies);
            long startTime, endTime;

            startTime = System.nanoTime();
            for (Policy policy : policies) {
                hashSet.add(policy);
            }
            endTime = System.nanoTime();
            System.out.println("HashSet add time: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            for (Policy policy : policies) {
                linkedHashSet.add(policy);
            }
            endTime = System.nanoTime();
            System.out.println("LinkedHashSet add time: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            for (Policy policy : policies) {
                treeSet.add(policy);
            }
            endTime = System.nanoTime();
            System.out.println("TreeSet add time: " + (endTime - startTime) + " ns");

            String lookupPolicyNumber = policies.get(0).getPolicyNumber();

            startTime = System.nanoTime();
            hashSet.contains(new Policy(lookupPolicyNumber, "", LocalDate.now(), "", 0));
            endTime = System.nanoTime();
            System.out.println("HashSet lookup time: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            linkedHashSet.contains(new Policy(lookupPolicyNumber, "", LocalDate.now(), "", 0));
            endTime = System.nanoTime();
            System.out.println("LinkedHashSet lookup time: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            treeSet.contains(new Policy(lookupPolicyNumber, "", LocalDate.now(), "", 0));
            endTime = System.nanoTime();
            System.out.println("TreeSet lookup time: " + (endTime - startTime) + " ns");
        }

        private List<Policy> generateSamplePolicies(int count) {
            List<Policy> policies = new ArrayList<>();
            for (int i = 1; i <= count; i++) {
                policies.add(new Policy("POL" + i, "Holder " + i,
                        LocalDate.now().plusDays(i * 10), "Health", 100 + i * 10));
            }
            return policies;
        }
    }

    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("POL001", "Alice", LocalDate.now().plusDays(10), "Health", 500));
        manager.addPolicy(new Policy("POL002", "Bob", LocalDate.now().plusDays(20), "Auto", 600));
        manager.addPolicy(new Policy("POL003", "Charlie", LocalDate.now().plusDays(25), "Home", 700));
        manager.addPolicy(new Policy("POL004", "David", LocalDate.now().plusDays(5), "Health", 300));
        manager.addPolicy(new Policy("POL001", "Alice", LocalDate.now().plusDays(10), "Health", 500));
        manager.addPolicy(new Policy("POL001", "Alice Smith", LocalDate.now().plusDays(15), "Health", 550)); // Duplicate

        System.out.println("All Unique Policies: " + manager.getAllUniquePolicies());
        System.out.println("Policies Expiring Soon: " + manager.getPoliciesExpiringSoon());
        System.out.println("Health Policies: " + manager.getPoliciesByCoverage("Health"));
        System.out.println("Duplicate Policies: " + manager.findDuplicatePolicies());

        manager.comparePerformance(10000);
    }
}