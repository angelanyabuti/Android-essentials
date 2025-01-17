class SmartDevice(val name: String, val category: String) {//primary constructor for the class smartDevice
    var deviceStatus = "online"
    //secondary constructor initialization                          //initialize primary constructor
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }

    }
    var speakerVolume: Int
        get() = 2
        set(value) = TODO()

    fun turnOn() {
        println("Smart device has been turned on")
    }
    fun turnOff() {
        println("Smart device has been turned off")
    }
}
fun main() {
    val smartTvDevice = SmartDevice(name = "Android TV", category = "Entertainment")
    println("Device name is: ${smartTvDevice.name}")
    smartTvDevice.turnOn() //calling the turn on method
    smartTvDevice.turnOff() //calling the turn off method
}