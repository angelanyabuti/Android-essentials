open class SmartDevice(val name: String, val category: String) {//primary constructor for the class smartDevice
    var deviceStatus = "online"
    //secondary constructor initialization                          //initialize primary constructor
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }

    }
    /*var speakerVolume: Int
        get() = 2
        set(value) = TODO()*/

    fun turnOn() {
        println("Smart device has been turned on")
    }
    fun turnOff() {
        println("Smart device has been turned off")
    }
}
//smarttv subclass
class SmartTvDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory){
            var speakerVolume = 2
                set(value) {
                    if (value in 0..100)
                        field = value
                }
            var channelNumber = 1
                set(value) {
                    if (value in 0..200)
                        field = value
                }
            fun increaseSpeakerVolume() {
                speakerVolume++
                println("Speaker volume increased to $speakerVolume")
            }
            fun nextChannel() {
                channelNumber++
                println("Speaker volume increased to $speakerVolume")
            }
        }

//smartlight subclass
class SmartLightDevice(deviceName: String, deviceCategory: String) :
      SmartDevice(name = deviceName, category = deviceCategory) {
          var brightnessLevel = 0
              set(value)  {
                  if (value in 0..100) {
                      field = value
                  }
              }
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness level has been increased to $brightnessLevel")
    }
      }

//Has - A relationship
//The SmartHome class HAS-A smart TV device
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val SmartLightDevice: SmartLightDevice
){
    //calls the turnOn() method on the smartTvDevice
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }
    //calls the turnOff() method on the smartTvDevice
    fun turnOffTv() {
        smartTvDevice.turnOff()
    }
    //calls the increaseSpeakerVolume() method on the smartTvDevice
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    //calls the nextChannel() method on the smartTvDevice
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    //calls the turnOn() method on the smartLightDevice object
    fun turnOnLight() {
        SmartLightDevice.turnOn()
    }
    //calls the turnoff method on the SmartLightDevice object
    fun  turnOffLight() {
        SmartLightDevice.turnOff()
    }
    //calls the increaseBrightness() method
    fun increaseLightBrightness() {
        SmartLightDevice.increaseBrightness()
    }
    //calls the turnOffTv() and turnOffLight() methods
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}






fun main() {
    val smartTvDevice = SmartDevice(name = "Android TV", category = "Entertainment")
    println("Device name is: ${smartTvDevice.name}")
    smartTvDevice.turnOn() //calling the turn on method
    smartTvDevice.turnOff() //calling the turn off method
}