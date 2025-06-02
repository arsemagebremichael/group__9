def process_vote(voters, candidates, vote):
    voter = next((v for v in voters if v["citizen_id"] == vote["citizen_id"]), None)
    if not voter:
        return "Fraud detected"
    if voter["vote_status"]:
        return "Citizen has already voted"
    candidate = next((c for c in candidates if c["candidate_id"] == vote["candidate_id"]), None)
    if not candidate:
        return "Invalid candidate ID"
    candidate["count"] += 1
    voter["vote_status"] = True
    return candidates
voters = [
    {"citizen_id": 1, "vote_status": False},
    {"citizen_id": 2, "vote_status": False}
]
candidates = [
    {"candidate_id": "A", "count": 0},
    {"candidate_id": "B", "count": 0}
]
vote = {"citizen_id": 1, "candidate_id": "A"}
result = process_vote(voters, candidates, vote)
print(result)