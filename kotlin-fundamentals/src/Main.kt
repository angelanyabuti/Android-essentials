fun main() {
    /*val coins: (Int) -> String = { //omitting the parameter name and using it
        "$it quarters"
    }*/
    val treatFunction = trickOrTreat(false, {"$it quarters"}) //pass a lambda expression directly into a function
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
}
//Using a function as a return type
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick){
        return trick
    }else {
        if (extraTreat != null){
            println(extraTreat(5))
        }
        return treat
    }
}
val trick = {
    println("No treats")
}
//function with lambda expression
val treat: () -> Unit = { //specifying treat variable's datatype as () -> Unit
    println("Have a treat")
}