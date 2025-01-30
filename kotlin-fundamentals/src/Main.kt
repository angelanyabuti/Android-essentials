import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty //this is an interface that represents a declared property and lets you access the metadata on a delegated property

open class SmartDevice(val name: String, val category: String) {//primary constructor for the class smartDevice
    var deviceStatus = "online"
    protected set

    open val deviceType = "unknown"
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

    open fun turnOn() {
        deviceStatus = "on"
    }
    open fun turnOff() {
        deviceStatus = "off"
    }
}
//smarttv subclass
class SmartTvDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory){

        override val deviceType = "Smart TV"
            private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

            private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
            fun increaseSpeakerVolume() {
                speakerVolume++
                println("Speaker volume increased to $speakerVolume")
            }
           protected fun nextChannel() {
                channelNumber++
                println("Speaker volume increased to $channelNumber")
            }
            override fun turnOn() {
                super.turnOn() //reusing superclass code in subclasses with super keyword
                println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is " + "set to $channelNumber.")
            }
            override fun turnOff() {
                super.turnOff() //reusing superclass code in subclasses with super keyword
                println("$name turned off")
            }
        }

//smartlight subclass
class SmartLightDevice(deviceName: String, deviceCategory: String) :
      SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart Light"
         private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100 )
        fun increaseBrightness() {
            brightnessLevel++
            println("Brightness level has been increased to $brightnessLevel")
        }
        override fun turnOn(){ //the override keyword informs the kotlin runtime to execute the code defined in the subclass
            super.turnOn() //reusing superclass code in subclasses with super keyword
            brightnessLevel = 2
            println("$name turned on. The brightness level is $brightnessLevel")

        }
        override fun turnOff() {
            super.turnOff() //reusing superclass code in subclasses with super keyword
            brightnessLevel = 0
            println("Smart Light turned off")
        }
      }

//Has - A relationship
//The SmartHome class HAS-A smart TV device
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val SmartLightDevice: SmartLightDevice
){
    var deviceTurnOnCount = 0
    private set
    //calls the turnOn() method on the smartTvDevice
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    //calls the turnOff() method on the smartTvDevice
    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    //calls the increaseSpeakerVolume() method on the smartTvDevice
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    //calls the nextChannel() method on the smartTvDevice
    /*fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }*/
    //calls the turnOn() method on the smartLightDevice object
    fun turnOnLight() {
        deviceTurnOnCount++
        SmartLightDevice.turnOn()
    }
    //calls the turnoff method on the SmartLightDevice object
    fun  turnOffLight() {
        deviceTurnOnCount--
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

class RangeRegulator(initialValue: Int, private val minValue: Int, private val maxValue: Int) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue //acts as the backing field for the variable
    //these methods act as the properties' getter and setter functions
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }

}





fun main() {
    val smartTvDevice = SmartDevice(name = "Android TV", category = "Entertainment")
    var smartDevice: SmartDevice = SmartTvDevice("Android TV","Entertainment")
    //println("Device name is: ${smartTvDevice.name}")
    smartDevice.turnOn() //calling the turn on method
    smartTvDevice.turnOff() //calling the turn off method
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}