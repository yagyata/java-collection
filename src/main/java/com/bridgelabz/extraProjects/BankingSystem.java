package com.bridgelabz.extraProjects;
import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double balance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
            return;
        }
        accounts.put(accountNumber, balance);
        sortedAccounts.putIfAbsent(balance, new ArrayList<>());
        sortedAccounts.get(balance).add(accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }
        double oldBalance = accounts.get(accountNumber);
        double newBalance = oldBalance + amount;

        accounts.put(accountNumber, newBalance);

        sortedAccounts.get(oldBalance).remove((Integer) accountNumber);
        if (sortedAccounts.get(oldBalance).isEmpty()) {
            sortedAccounts.remove(oldBalance);
        }

        sortedAccounts.putIfAbsent(newBalance, new ArrayList<>());
        sortedAccounts.get(newBalance).add(accountNumber);
    }

    public void requestWithdrawal(int accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }
        withdrawalQueue.add(accountNumber);
        System.out.println("Withdrawal request added for Account: " + accountNumber);
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            double balance = accounts.get(accountNumber);

            if (balance >= amount) {
                double newBalance = balance - amount;

                accounts.put(accountNumber, newBalance);

                sortedAccounts.get(balance).remove((Integer) accountNumber);
                if (sortedAccounts.get(balance).isEmpty()) {
                    sortedAccounts.remove(balance);
                }

                sortedAccounts.putIfAbsent(newBalance, new ArrayList<>());
                sortedAccounts.get(newBalance).add(accountNumber);

                System.out.println("Withdrawal of ₹" + amount + " processed for Account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance in Account: " + accountNumber);
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("Accounts sorted by balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount(123400, 10000);
        bank.createAccount(567800, 5000);
        bank.createAccount(910110, 15000);

        bank.deposit(123400, 5000);
        bank.deposit(567800, 10000);

        bank.displayAccountsSortedByBalance();

        bank.requestWithdrawal(123400);
        bank.requestWithdrawal(567800);

        bank.processWithdrawals(7000);

        bank.displayAccountsSortedByBalance();
    }
}

