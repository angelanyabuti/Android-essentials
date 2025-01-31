fun main() {
    val trickFunction =  trick //you do not add brackets because we are not calling the function
    trick()
    trickFunction()
}
val trick = {
    println("No treats")
}