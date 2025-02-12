fun main() {
    // Test Cases
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") // Expected: 80.60
    printFinalTemperature(350.0, "Kelvin", "Celsius")    // Expected: 76.85
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin")  // Expected: 260.93
}

// Function to print final temperature
fun printFinalTemperature(initialMeasurement: Double, initialUnit: String, finalUnit: String) {
    val conversionFormula: (Double) -> Double = when (initialUnit to finalUnit) {
        "Celsius" to "Fahrenheit" -> { temp -> temp * 9 / 5 + 32 }
        "Fahrenheit" to "Celsius" -> { temp -> (temp - 32) * 5 / 9 }
        "Kelvin" to "Celsius" -> { temp -> temp - 273.15 }
        "Celsius" to "Kelvin" -> { temp -> temp + 273.15 }
        "Fahrenheit" to "Kelvin" -> { temp -> (temp - 32) * 5 / 9 + 273.15 }
        "Kelvin" to "Fahrenheit" -> { temp -> (temp - 273.15) * 9 / 5 + 32 }
        else -> {
            println("Conversion not supported.")
            return
        }
    }

    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // Format to 2 decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit")
}
