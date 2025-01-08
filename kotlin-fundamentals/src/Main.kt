fun main() {
    val trafficLightColor = "Red"
    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Amber" -> println("Get Ready")
        "Green" -> println("Go")
        else -> println("Invalid color")
    }
    val x:Any = 20 //indicates x can be of any value other than int
    when (x){
        2,3,5,7 -> println("x is a prime number between 1 and 10")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number")
        is Int -> println("x is an integer number but not between 1 and 10")
        else -> println("x isn't an integer number.")
    }
}