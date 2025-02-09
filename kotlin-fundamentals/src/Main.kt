fun main() {
    /*val coins: (Int) -> String = { //omitting the parameter name and using it
        "$it quarters"
    }*/
    val treatFunction = trickOrTreat(false) {"$it quarters"} //using trailing lambda syntax
    val trickFunction = trickOrTreat(true, null)
    trickFunction()
    repeat(4){//repeat function
        treatFunction()
    }
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