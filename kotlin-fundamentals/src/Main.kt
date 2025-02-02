fun main() {
    val trickFunction =  trick //you do not add brackets because we are not calling the function
    trick()
    trickFunction()
    treat()
}
val trick = {
    println("No treats")
}
//function with lambda expression
val treat: () -> Unit = { //specifying treat variable's datatype as () -> Unit
    println("Have a treat")
}