const students = [
    { studentId: 'S001', location: [10.290275, 50.821945] },
    { studentId: 'S002', location: [10.292035, 50.822001] },
    { studentId: 'S003', location: [10.289005, 50.819001] }
  ];
const busStops = [
    { id: 'B001', location: [10.291005, 50.820000] },
    { id: "B002", location: [10.293005, 50.823000] }
];
const busCapacity = 2;
const buses = {};
function distance(p1, p2){
    const dx = p1[0] - p2[0];
    const dy = p1[1] - p2[1];
    return Math.sqrt(dx * dx + dy * dy);
}

students.forEach(student => {
    const closeby = busStops.reduce((a, b) =>
      distance(student.location, a.location) < distance(student.location, b.location) ? a : b
    );
    if (!buses[closeby.id]) buses[closeby.id] = [];
    buses[closeby.id].push(student.id);
  });
for(const stop in buses) {
    const group = buses[stop];
    const grouped = [];
    for (let i = 0; i < group.length; i += busCapacity) {
      grouped.push(group.slice(i, i + busCapacity));
    }
    console.log(`Stop ${stop} buses:`, grouped);
  }