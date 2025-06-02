students = [
    {"id": 1, "location": (1.290270, 36.821946)},
    {"id": 2, "location": (1.292030, 36.822000)},
    {"id": 3, "location": (1.289000, 36.819000)},
]
bus_stops = [
    {"id": "A", "location": (1.291000, 36.820000)},
    {"id": "B", "location": (1.293000, 36.823000)},
]
bus_capacity = 35
buses = {}
def euclidean(p1, p2):
    return ((p1[0] - p2[0])**2 + (p1[1] - p2[1])**2) ** 0.5
for student in students:
    nearest = min(bus_stops, key=lambda stop: euclidean(student["location"], stop["location"]))
    stop_id = nearest["id"]
    if stop_id not in buses:
        buses[stop_id] = []
    buses[stop_id].append(student["id"])
for stop, group in buses.items():
    grouped = [group[i:i + bus_capacity] for i in range(0, len(group), bus_capacity)]
    print(f"Stop {stop} buses: {grouped}")