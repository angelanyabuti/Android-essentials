fun main() {
    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)
    treatFunction()
    trickFunction()
}
//Using a function as a return type
fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick){
        return trick
    }else {
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