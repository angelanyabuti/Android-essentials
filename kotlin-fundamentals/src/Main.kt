class SmartDevice {
    val name = "Android TV"
    val category = "Entertainment"
    var deviceStatus = "online"
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
    val smartTvDevice = SmartDevice()
    println("Device name is: ${smartTvDevice.name}")
    smartTvDevice.turnOn() //calling the turn on method
    smartTvDevice.turnOff() //calling the turn off method
}