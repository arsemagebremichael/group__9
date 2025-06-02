student1 = {"name": "Nebyat", "scores": [90, 70, 50]}
student2 = {"name": "Arsema", "scores": [90, 70, 80]}
student3 = {"name": "Hani", "scores": [100, 70, 60]}

students = [student1, student2, student3]

def student_statistics(students):
    students_statistics = []
    for student in students:
        average = sum(student["scores"]) / len(student["scores"])
        minimum = min(student["scores"])
        maximum = max(student["scores"])
        statistics = [minimum, maximum, average]
        student_data = {"name": student["name"], "scores_statistics": statistics}
        students_statistics.append(student_data)
    return students_statistics

print(student_statistics(students))

