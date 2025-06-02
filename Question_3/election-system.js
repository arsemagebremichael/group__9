class Voter {
    constructor(citizenId, voteStatus = false) {
        this.citizenId = citizenId;
        this.voteStatus = voteStatus;
    }
}
class Candidate {
    constructor(candidateId, count = 0) {
        this.candidateId = candidateId;
        this.count = count;
    }
}
class Vote {
    constructor(citizenId, candidateId) {
        this.citizenId = citizenId;
        this.candidateId = candidateId;
    }
}

class ElectionSystem {
    constructor(voters, candidates) {
        this.voters = voters;
        this.candidates = candidates;
    }
    processVote(vote) {
        const voter = this.voters.find(v => v.citizenId === vote.citizenId);
        if (!voter) {
            throw new Error('Fraud detected: citizen ID not found in eligible voters');
        }
        if (voter.voteStatus) {
            throw new Error('Citizen has already voted');
        }
        const candidate = this.candidates.find(c => c.candidateId === vote.candidateId);
        if (!candidate) {
            throw new Error('Invalid candidate ID');
        }

        candidate.count += 1;
        voter.voteStatus = true;
        return this.candidates;
    }
}

// Example usage
const voters = [
    new Voter('123', false),
    new Voter('456', false),
];
const candidates = [
    new Candidate('A', 0),
    new Candidate('B', 0),
];
const election = new ElectionSystem(voters, candidates);
const vote = new Vote('123', 'A');
try {
    const updatedCandidates = election.processVote(vote);
    console.log("Updated candidate counts:");
    updatedCandidates.forEach(c => console.log(`${c.candidateId}: ${c.count}`));
} catch (err) {
    console.error(err.message);
}