fun main() {
    val trafficLightColor = "Black"
    val message = if (trafficLightColor == "Red") "Stop"
    else if (trafficLightColor == "Amber") "Get Ready"
    else if (trafficLightColor == "Green") "Go"
    else "Invalid Color"
    println(message)

    val output = when(trafficLightColor) {
        "Red" -> "Stop"
        "Amber" -> "Get Ready"
        "Green" -> "Go"
        else -> "Invalid color"
    }
    println(output)
}