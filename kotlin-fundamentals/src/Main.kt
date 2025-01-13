fun main() {
    var favouriteColor: String? = "maroon"

    val length = if (favouriteColor != null){
        favouriteColor.length
    } else {
        0
    }
    println("The length of your favourite color's name is $length")
}