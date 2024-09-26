import java.time.LocalDate;
import java.util.*;

// Policy class to represent insurance policy details
class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
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

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName + ", ExpiryDate: " + expiryDate;
    }
}

// PolicyManager class to manage the insurance policies
public class PolicyManager {
    // HashMap to store policies with policy numbers as keys
    private HashMap<String, Policy> policyMap;

    // LinkedHashMap to store policies in insertion order
    private LinkedHashMap<String, Policy> insertionOrderPolicies;

    // TreeMap to store policies sorted by expiry date
    private TreeMap<LocalDate, List<Policy>> expiryDateSortedPolicies;

    // Constructor to initialize the data structures
    public PolicyManager() {
        policyMap = new HashMap<>();
        insertionOrderPolicies = new LinkedHashMap<>();
        expiryDateSortedPolicies = new TreeMap<>();
    }

    // Method to add a new policy
    public void addPolicy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        Policy policy = new Policy(policyNumber, policyholderName, expiryDate);

        // Add to HashMap
        policyMap.put(policyNumber, policy);

        // Add to LinkedHashMap (Insertion order)
        insertionOrderPolicies.put(policyNumber, policy);

        // Add to TreeMap (Expiry date order)
        expiryDateSortedPolicies.computeIfAbsent(expiryDate, k -> new ArrayList<>()).add(policy);

        System.out.println("Policy added: " + policy);
    }

    // Method to retrieve a policy by its policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Method to list all policies expiring within the next 30 days
    public void listPoliciesExpiringWithin30Days() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        System.out.println("Policies expiring within the next 30 days:");
        for (Map.Entry<LocalDate, List<Policy>> entry : expiryDateSortedPolicies.subMap(today, thirtyDaysLater).entrySet()) {
            for (Policy policy : entry.getValue()) {
                System.out.println(policy);
            }
        }
    }

    // Method to list all policies for a specific policyholder
    public void listPoliciesByPolicyholder(String policyholderName) {
        System.out.println("Policies for policyholder: " + policyholderName);
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                System.out.println(policy);
            }
        }
    }

    // Method to remove policies that have expired (before today)
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        System.out.println("Removing expired policies...");

        // Find and remove policies that are expired
        Iterator<Map.Entry<LocalDate, List<Policy>>> iterator = expiryDateSortedPolicies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy policy : entry.getValue()) {
                    // Remove from HashMap and LinkedHashMap
                    policyMap.remove(policy.getPolicyNumber());
                    insertionOrderPolicies.remove(policy.getPolicyNumber());
                }
                iterator.remove(); // Remove expired entry from TreeMap
            }
        }
        System.out.println("Expired policies removed.");
    }

    // Method to display all policies in insertion order
    public void displayAllPoliciesInInsertionOrder() {
        System.out.println("All policies in insertion order:");
        for (Policy policy : insertionOrderPolicies.values()) {
            System.out.println(policy);
        }
    }

    // Main method for interaction
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        Scanner scanner = new Scanner(System.in);

        // Sample data for demonstration
        manager.addPolicy("P123", "Alice", LocalDate.of(2024, 10, 10));
        manager.addPolicy("P456", "Bob", LocalDate.of(2023, 9, 25));  // Expired policy
        manager.addPolicy("P789", "Charlie", LocalDate.of(2023, 10, 5));
        manager.addPolicy("P321", "Alice", LocalDate.of(2024, 11, 1));

        int choice;
        do {
            System.out.println("\nPolicy Management Menu:");
            System.out.println("1. Add Policy");
            System.out.println("2. Retrieve Policy by Number");
            System.out.println("3. List Policies Expiring within 30 Days");
            System.out.println("4. List Policies by Policyholder");
            System.out.println("5. Remove Expired Policies");
            System.out.println("6. Display All Policies in Insertion Order");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter policy number: ");
                    String policyNumber = scanner.nextLine();
                    System.out.print("Enter policyholder name: ");
                    String policyholderName = scanner.nextLine();
                    System.out.print("Enter expiry date (YYYY-MM-DD): ");
                    LocalDate expiryDate = LocalDate.parse(scanner.nextLine());
                    manager.addPolicy(policyNumber, policyholderName, expiryDate);
                    break;

                case 2:
                    System.out.print("Enter policy number: ");
                    String searchPolicyNumber = scanner.nextLine();
                    Policy policy = manager.getPolicyByNumber(searchPolicyNumber);
                    if (policy != null) {
                        System.out.println("Policy found: " + policy);
                    } else {
                        System.out.println("Policy not found.");
                    }
                    break;

                case 3:
                    manager.listPoliciesExpiringWithin30Days();
                    break;

                case 4:
                    System.out.print("Enter policyholder name: ");
                    String searchPolicyholderName = scanner.nextLine();
                    manager.listPoliciesByPolicyholder(searchPolicyholderName);
                    break;

                case 5:
                    manager.removeExpiredPolicies();
                    break;

                case 6:
                    manager.displayAllPoliciesInInsertionOrder();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
