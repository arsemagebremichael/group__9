fun main(){
    var student1 = Student("Alice", arrayOf(70.0,89.0,97.0))
    var student2 = Student("Mark", arrayOf(90.0,89.0,97.0))
    var student3= Student("Bob", arrayOf(70.0,80.0,97.0))
    var student4 = Student("Mark", arrayOf(80.0, 87.0, 79.0))
    var students = listOf(student1,student2, student3, student4)
    println(studentStatics(students))
}

data class Student(var name:String, var scores:Array<Double>)

fun studentStatics(students:List<Student>):Any{
    var studentRecord = mutableMapOf<String,Any>()
    for(student in students){
        var studentData = mutableMapOf<String,Any>()
        var studentAverage = average(student.scores)
        var minimum = min(student.scores)
        var maximum = max(student.scores)
        studentData["average"]= studentAverage
        studentData["minimum"]= minimum
        studentData["maximum"]= maximum
        studentRecord[student.name] = studentData
    }
    return studentRecord
}

fun average(scores: Array<Double>): Any {
    var total = 0.0
    for (score in scores){
        total += score

    }
    return total/scores.size
}

fun min(scores: Array<Double>): Any{
    var minimum = scores[0]
    for(i in 0 until scores.size-1){
        if (scores[i] > scores[i+1] ){
            minimum = scores[i+1]
        }
    }
    return minimum
}

fun max(scores: Array<Double>): Any{
    var maximum = scores[0]
    for(i in 0 until scores.size-1){
        if (scores[i] < scores[i+1] ){
            maximum = scores[i+1]
        }
    }
    return maximum
}

