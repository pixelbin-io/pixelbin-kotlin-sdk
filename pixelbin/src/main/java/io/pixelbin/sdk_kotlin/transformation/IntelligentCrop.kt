package io.pixelbin.sdk_kotlin.transformation
import io.pixelbin.sdk_kotlin.TransformationObj

class IcCrop {
    /**
     * Gravity towards options: object, foreground, face, none
     */
    enum class Gravitytowards {
        OBJECT {
            override fun toString(): String = "object"
        },
        FOREGROUND {
            override fun toString(): String = "foreground"
        },
        FACE {
            override fun toString(): String = "face"
        },
        NONE {
            override fun toString(): String = "none"
        },
    }

    /**
     * Preferred direction options: north_west, north, north_east, west, center, east, south_west, south, south_east
     */
    enum class Preferreddirection {
        NORTH_WEST {
            override fun toString(): String = "north_west"
        },
        NORTH {
            override fun toString(): String = "north"
        },
        NORTH_EAST {
            override fun toString(): String = "north_east"
        },
        WEST {
            override fun toString(): String = "west"
        },
        CENTER {
            override fun toString(): String = "center"
        },
        EAST {
            override fun toString(): String = "east"
        },
        SOUTH_WEST {
            override fun toString(): String = "south_west"
        },
        SOUTH {
            override fun toString(): String = "south"
        },
        SOUTH_EAST {
            override fun toString(): String = "south_east"
        },
    }

    /**
     * Object Type (if Gravity is object) options: airplane, apple, backpack, banana, baseball_bat, baseball_glove, bear, bed, bench, bicycle, bird, boat, book, bottle, bowl, broccoli, bus, cake, car, carrot, cat, cell_phone, chair, clock, couch, cow, cup, dining_table, dog, donut, elephant, fire_hydrant, fork, frisbee, giraffe, hair_drier, handbag, horse, hot_dog, keyboard, kite, knife, laptop, microwave, motorcycle, mouse, orange, oven, parking_meter, person, pizza, potted_plant, refrigerator, remote, sandwich, scissors, sheep, sink, skateboard, skis, snowboard, spoon, sports_ball, stop_sign, suitcase, surfboard, teddy_bear, tennis_racket, tie, toaster, toilet, toothbrush, traffic_light, train, truck, tv, umbrella, vase, wine_glass, zebra
     */
    enum class Objecttype {
        AIRPLANE {
            override fun toString(): String = "airplane"
        },
        APPLE {
            override fun toString(): String = "apple"
        },
        BACKPACK {
            override fun toString(): String = "backpack"
        },
        BANANA {
            override fun toString(): String = "banana"
        },
        BASEBALL_BAT {
            override fun toString(): String = "baseball_bat"
        },
        BASEBALL_GLOVE {
            override fun toString(): String = "baseball_glove"
        },
        BEAR {
            override fun toString(): String = "bear"
        },
        BED {
            override fun toString(): String = "bed"
        },
        BENCH {
            override fun toString(): String = "bench"
        },
        BICYCLE {
            override fun toString(): String = "bicycle"
        },
        BIRD {
            override fun toString(): String = "bird"
        },
        BOAT {
            override fun toString(): String = "boat"
        },
        BOOK {
            override fun toString(): String = "book"
        },
        BOTTLE {
            override fun toString(): String = "bottle"
        },
        BOWL {
            override fun toString(): String = "bowl"
        },
        BROCCOLI {
            override fun toString(): String = "broccoli"
        },
        BUS {
            override fun toString(): String = "bus"
        },
        CAKE {
            override fun toString(): String = "cake"
        },
        CAR {
            override fun toString(): String = "car"
        },
        CARROT {
            override fun toString(): String = "carrot"
        },
        CAT {
            override fun toString(): String = "cat"
        },
        CELL_PHONE {
            override fun toString(): String = "cell_phone"
        },
        CHAIR {
            override fun toString(): String = "chair"
        },
        CLOCK {
            override fun toString(): String = "clock"
        },
        COUCH {
            override fun toString(): String = "couch"
        },
        COW {
            override fun toString(): String = "cow"
        },
        CUP {
            override fun toString(): String = "cup"
        },
        DINING_TABLE {
            override fun toString(): String = "dining_table"
        },
        DOG {
            override fun toString(): String = "dog"
        },
        DONUT {
            override fun toString(): String = "donut"
        },
        ELEPHANT {
            override fun toString(): String = "elephant"
        },
        FIRE_HYDRANT {
            override fun toString(): String = "fire_hydrant"
        },
        FORK {
            override fun toString(): String = "fork"
        },
        FRISBEE {
            override fun toString(): String = "frisbee"
        },
        GIRAFFE {
            override fun toString(): String = "giraffe"
        },
        HAIR_DRIER {
            override fun toString(): String = "hair_drier"
        },
        HANDBAG {
            override fun toString(): String = "handbag"
        },
        HORSE {
            override fun toString(): String = "horse"
        },
        HOT_DOG {
            override fun toString(): String = "hot_dog"
        },
        KEYBOARD {
            override fun toString(): String = "keyboard"
        },
        KITE {
            override fun toString(): String = "kite"
        },
        KNIFE {
            override fun toString(): String = "knife"
        },
        LAPTOP {
            override fun toString(): String = "laptop"
        },
        MICROWAVE {
            override fun toString(): String = "microwave"
        },
        MOTORCYCLE {
            override fun toString(): String = "motorcycle"
        },
        MOUSE {
            override fun toString(): String = "mouse"
        },
        ORANGE {
            override fun toString(): String = "orange"
        },
        OVEN {
            override fun toString(): String = "oven"
        },
        PARKING_METER {
            override fun toString(): String = "parking_meter"
        },
        PERSON {
            override fun toString(): String = "person"
        },
        PIZZA {
            override fun toString(): String = "pizza"
        },
        POTTED_PLANT {
            override fun toString(): String = "potted_plant"
        },
        REFRIGERATOR {
            override fun toString(): String = "refrigerator"
        },
        REMOTE {
            override fun toString(): String = "remote"
        },
        SANDWICH {
            override fun toString(): String = "sandwich"
        },
        SCISSORS {
            override fun toString(): String = "scissors"
        },
        SHEEP {
            override fun toString(): String = "sheep"
        },
        SINK {
            override fun toString(): String = "sink"
        },
        SKATEBOARD {
            override fun toString(): String = "skateboard"
        },
        SKIS {
            override fun toString(): String = "skis"
        },
        SNOWBOARD {
            override fun toString(): String = "snowboard"
        },
        SPOON {
            override fun toString(): String = "spoon"
        },
        SPORTS_BALL {
            override fun toString(): String = "sports_ball"
        },
        STOP_SIGN {
            override fun toString(): String = "stop_sign"
        },
        SUITCASE {
            override fun toString(): String = "suitcase"
        },
        SURFBOARD {
            override fun toString(): String = "surfboard"
        },
        TEDDY_BEAR {
            override fun toString(): String = "teddy_bear"
        },
        TENNIS_RACKET {
            override fun toString(): String = "tennis_racket"
        },
        TIE {
            override fun toString(): String = "tie"
        },
        TOASTER {
            override fun toString(): String = "toaster"
        },
        TOILET {
            override fun toString(): String = "toilet"
        },
        TOOTHBRUSH {
            override fun toString(): String = "toothbrush"
        },
        TRAFFIC_LIGHT {
            override fun toString(): String = "traffic_light"
        },
        TRAIN {
            override fun toString(): String = "train"
        },
        TRUCK {
            override fun toString(): String = "truck"
        },
        TV {
            override fun toString(): String = "tv"
        },
        UMBRELLA {
            override fun toString(): String = "umbrella"
        },
        VASE {
            override fun toString(): String = "vase"
        },
        WINE_GLASS {
            override fun toString(): String = "wine_glass"
        },
        ZEBRA {
            override fun toString(): String = "zebra"
        },
    }

    /**
     * Method for Intelligent Crop Plugin
     *
     * @param Required Width Int (Default: 0)
     * @param Required Height Int (Default: 0)
     * @param Padding Percentage Int (Default: 0)
     * @param Maintain Original Aspect Boolean (Default: false)
     * @param Aspect Ratio string (Default: )
     * @param Gravity Towards Gravity towards? (Default: none)
     * @param Preferred Direction Preferred direction? (Default: center)
     * @param Object Type Object type? (Default: person)
     * @return TransformationObj.
     */
    @JvmOverloads
    fun crop(
        requiredwidth: Int? = null,
        requiredheight: Int? = null,
        paddingpercentage: Int? = null,
        maintainoriginalaspect: Boolean? = null,
        aspectratio: String? = null,
        gravitytowards: Gravitytowards? = null,
        preferreddirection: Preferreddirection? = null,
        objecttype: Objecttype? = null,
    ): TransformationObj {
        // Create the values HashMap
        val values = HashMap<String, String>()
        values["w"] = requiredwidth.toString()
        values["h"] = requiredheight.toString()
        values["p"] = paddingpercentage.toString()
        values["ma"] = maintainoriginalaspect.toString()
        if (!aspectratio.isNullOrEmpty()) {
            values["ar"] = aspectratio.toString()
        }
        values["g"] = gravitytowards.toString()
        values["d"] = preferreddirection.toString()
        values["obj"] = objecttype.toString()
        return TransformationObj(
            plugin = "ic",
            name = "crop",
            values = values,
        )
    }
}
