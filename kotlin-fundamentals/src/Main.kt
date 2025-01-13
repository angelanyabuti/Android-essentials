fun main() {
    var favouriteColor: String? = "maroon"

    val length = favouriteColor?.length ?: 0

    println("The length of your favourite color's name is $length")
}