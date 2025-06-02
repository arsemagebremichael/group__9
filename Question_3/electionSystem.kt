data class Voter(var citizenId: String, var voteStatus: Boolean)
data class Candidate(val candidateId: String, var count: Int)
data class Vote(val citizenId: String, val candidateId: String)
fun processVote(
    voters: MutableList<Voter>,
    candidates: MutableList<Candidate>,
    vote: Vote
): Any {
    val voter = voters.find { it.citizenId == vote.citizenId }
    if (voter == null) {
        return "Fraud detected"
    }
    if (voter.voteStatus) {
        return "Citizen has already voted"
    }
    val candidate = candidates.find { it.candidateId == vote.candidateId }
    if (candidate == null) {
        return "Invalid candidate ID"
    }
    candidate.count += 1
    voter.voteStatus = true
    return candidates
}
fun main() {
    val voters = mutableListOf(
        Voter("123", false),
        Voter("456", false)
    )
    val candidates = mutableListOf(
        Candidate("A", 0),
        Candidate("B", 0)
    )
    val vote = Vote("123", "A")
    val result = processVote(voters, candidates, vote)
    println(result)
}






