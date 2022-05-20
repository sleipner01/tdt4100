package eksamenOving.kode.kont2021;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class VoterCounter {

	// Add any needed fields here
	private HashMap<String, Integer> candidates = new HashMap<>();
	public static final String TIE_RESULT = "TIE";
	private final int DEFAULT_VOTES = 0;

	/**
	 * Register a candidate to the poll
	 * 
	 * @param candidate the new candidate to add
	 */
	public void addCandidate(String candidate) {
		candidates.putIfAbsent(candidate, DEFAULT_VOTES);
	}

	/**
	 * Vote on a given candidate
	 * 
	 * @param candidate the candidate to vote on
	 * 
	 * @throws IllegalArgumentException if the candidate is not registered
	 */
	public void castVote(String candidate) {
		if(!this.candidates.containsKey(candidate))
			throw new IllegalArgumentException("This candidate does not exist");
		candidates.replace(candidate, candidates.get(candidate), candidates.get(candidate) + 1);
	}

	/**
	 * Prints all the results in an arbitrary order. The results should be on the
	 * format {candidate name}-{number of votes for the candidate} with each
	 * candidate on a new line
	 * 
	 * Example output with two candidates, "Candidate1" with 7 votes, and
	 * "Candidate2" with 6 votes
	 * 
	 * Candidate1-7 
	 * Candidate2-6
	 */
	public String getFormattedResults() {
		StringBuilder sb = new StringBuilder();
		for (String candidate : candidates.keySet()) {
			sb.append(candidate + " : " + candidates.get(candidate) + "\n");
			
		}
		return sb.toString();
	}

	/**
	 * Returns the number of votes a candidate has received
	 * 
	 * @param candidate the candidate to get number of votes for
	 * @return the number of votes the candidate has received. Returns null if the
	 *         candidate is not registered
	 */
	public Integer getNumberOfVotes(String candidate) {
		return candidates.getOrDefault(candidate, null);
	}

	/**
	 *
	 * @return the name of the candidate who won the election. If two or more
	 *         candidates got the same number of maximum votes, return the
	 *         TIE_RESULT field. Return null if there are no candidates.
	 */
	public String getWinner() {
		int maxValue = 0;
		String winner = null;
		for (String candidate : candidates.keySet()) {
			if (candidates.get(candidate) > maxValue) {
				winner = candidate;
				maxValue = candidates.get(candidate);
			}
		}
		for (String candidate : candidates.keySet()) {
			if (candidates.get(candidate) == maxValue && !winner.equals(candidate)) {
				return TIE_RESULT;
			}
		}
		return winner;
	}
	

	public static void main(String[] args) {
		String candidate1 = "CANDIDATE1";
		String candidate2 = "CANDIDATE2";
		VoterCounter counter = new VoterCounter();
		counter.addCandidate(candidate1);
		counter.addCandidate(candidate2);
		// Should print 0
		System.out.println(counter.getNumberOfVotes(candidate1));
		counter.castVote(candidate1);
		// Should print 1;
		System.out.println(counter.getNumberOfVotes(candidate1));
		// Should print CANDIDATE 1
		System.out.println(counter.getWinner());
		counter.castVote(candidate2);
		// Should print TIE
		System.out.println(counter.getWinner());
	}
}
