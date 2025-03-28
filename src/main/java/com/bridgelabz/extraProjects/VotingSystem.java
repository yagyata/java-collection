package com.bridgelabz.extraProjects;
import java.util.*;

class VotingSystem {
    private Map<String, Integer> votes = new HashMap<>();
    private TreeMap<Integer, List<String>> sortedVotes = new TreeMap<>(Collections.reverseOrder());
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

    // Casting a vote
    public void castVote(String candidate) {
        int newVoteCount = votes.getOrDefault(candidate, 0) + 1;

        // Updating the HashMap
        votes.put(candidate, newVoteCount);

        // Update LinkedHashMap
        voteOrder.put(candidate, newVoteCount);

        // Update TreeMap
        if (sortedVotes.containsKey(newVoteCount - 1)) {
            sortedVotes.get(newVoteCount - 1).remove(candidate);
            if (sortedVotes.get(newVoteCount - 1).isEmpty()) {
                sortedVotes.remove(newVoteCount - 1);
            }
        }

        sortedVotes.putIfAbsent(newVoteCount, new ArrayList<>());
        sortedVotes.get(newVoteCount).add(candidate);
    }

    public void displayVotesInOrder() {
        System.out.println("Votes in order of casting: " + voteOrder);
    }

    public void displaySortedResults() {
        System.out.println("Results sorted by votes: " + sortedVotes);
    }

    public void findWinner() {
        if (sortedVotes.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }
        int maxVotes = sortedVotes.firstKey();
        System.out.println("Winner(s) with " + maxVotes + " votes: " + sortedVotes.get(maxVotes));
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();

        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");
        voting.castVote("Bob");
        voting.castVote("Alice");

        voting.displayVotesInOrder();
        voting.displaySortedResults();
        voting.findWinner();
    }
}
