class SmartDevice {
    fun turnOn() {
        println("Smart device has been turned on")
    }
    fun turnOff() {
        println("Smart device has been turned off")
    }
}
fun main() {
    val smartTvDevice = SmartDevice()
    smartTvDevice.turnOn() //calling the turn on method
    smartTvDevice.turnOff() //calling the turn off method
}