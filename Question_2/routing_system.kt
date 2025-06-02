
    data class Location(val lat: Double, val lon: Double)
    data class Student(val id: Int, val location: Location)
    data class BusStop(val id: String, val location: Location)

    fun euclidean(p1: Location, p2: Location): Double {
        val dx = p1.lat - p2.lat
        val dy = p1.lon - p2.lon
        return Math.sqrt(dx * dx + dy * dy)
    }

    fun main() {
        val students = listOf(
            Student(1, Location(1.290270, 36.821946)),
            Student(2, Location(1.292030, 36.822000)),
            Student(3, Location(1.289000, 36.819000)),
            Student(4, Location(1.369000, 36.829000)),
        )
        val busStops = listOf(
            BusStop("A", Location(1.291000, 36.820000)),
            BusStop("B", Location(1.293000, 36.823000)),
        )
        val busCapacity = 20
        val studentBus = mutableMapOf<Int,String>()
        for (student in students) {
            val nearest = busStops.minByOrNull { euclidean(student.location, it.location) }!!
            studentBus.put(student.id, nearest.id)
        }

        val buses = mutableMapOf<String, MutableList<Int>>()
        for (student in students) {
            val nearest = busStops.minByOrNull { euclidean(student.location, it.location) }!!
            buses.getOrPut(nearest.id) { mutableListOf() }.add(student.id)
        }

        for ((stop, group) in buses) {
            val grouped = group.chunked(busCapacity)
            println("Stop $stop buses: $grouped")
        }

        println(buses)
        println(studentBus)
    }