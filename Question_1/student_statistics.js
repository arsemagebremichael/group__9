function Student(name, scores) {
    this.name = name;
    this.scores = scores;
}

let student1 = new Student("Arsema", [90, 96, 89]);
let student2 = new Student("Hani", [89, 98, 90]);
let student3 = new Student("Nebyat", [90, 90, 98]);

let students = [student1, student2, student3];

function studentsStatistics(students) {
    let studentsStatistics = {};
    for (let i = 0; i < students.length; i++) {
        let student = students[i];
        let scores = student.scores;
        let ave = scores.reduce((sum, score) => sum + score, 0) / scores.length;
        let min= 100;
        let max = 0;
        for(let j =0; j<scores.length; j++){
            if (scores[j]> max){
                max = scores[j]
            }
            if (scores[j]< min){
                min = scores[j]
            }
            
        }
        
        let status = { minimum: min, maximum: max, average: ave };
        studentsStatistics[student.name] = status;
    }
    return studentsStatistics;
}

console.log(studentsStatistics(students));