package io.pixelbin.sdk_kotlin.transformation.type

import io.pixelbin.sdk_kotlin.transformation.TransformationObj


class IcCrop {


    /**
     * Gravity towards options: object, foreground, face, none
     */
    enum class Gravitytowards {

        OBJECT {
            override fun toString(): String {
                return "object"
            }
        },

        FOREGROUND {
            override fun toString(): String {
                return "foreground"
            }
        },

        FACE {
            override fun toString(): String {
                return "face"
            }
        },

        NONE {
            override fun toString(): String {
                return "none"
            }
        },

    }


    /**
     * Preferred direction options: north_west, north, north_east, west, center, east, south_west, south, south_east
     */
    enum class Preferreddirection {

        NORTH_WEST {
            override fun toString(): String {
                return "north_west"
            }
        },

        NORTH {
            override fun toString(): String {
                return "north"
            }
        },

        NORTH_EAST {
            override fun toString(): String {
                return "north_east"
            }
        },

        WEST {
            override fun toString(): String {
                return "west"
            }
        },

        CENTER {
            override fun toString(): String {
                return "center"
            }
        },

        EAST {
            override fun toString(): String {
                return "east"
            }
        },

        SOUTH_WEST {
            override fun toString(): String {
                return "south_west"
            }
        },

        SOUTH {
            override fun toString(): String {
                return "south"
            }
        },

        SOUTH_EAST {
            override fun toString(): String {
                return "south_east"
            }
        },

    }


    /**
     * Object Type (if Gravity is object) options: airplane, apple, backpack, banana, baseball_bat, baseball_glove, bear, bed, bench, bicycle, bird, boat, book, bottle, bowl, broccoli, bus, cake, car, carrot, cat, cell_phone, chair, clock, couch, cow, cup, dining_table, dog, donut, elephant, fire_hydrant, fork, frisbee, giraffe, hair_drier, handbag, horse, hot_dog, keyboard, kite, knife, laptop, microwave, motorcycle, mouse, orange, oven, parking_meter, person, pizza, potted_plant, refrigerator, remote, sandwich, scissors, sheep, sink, skateboard, skis, snowboard, spoon, sports_ball, stop_sign, suitcase, surfboard, teddy_bear, tennis_racket, tie, toaster, toilet, toothbrush, traffic_light, train, truck, tv, umbrella, vase, wine_glass, zebra
     */
    enum class Objecttype {

        AIRPLANE {
            override fun toString(): String {
                return "airplane"
            }
        },

        APPLE {
            override fun toString(): String {
                return "apple"
            }
        },

        BACKPACK {
            override fun toString(): String {
                return "backpack"
            }
        },

        BANANA {
            override fun toString(): String {
                return "banana"
            }
        },

        BASEBALL_BAT {
            override fun toString(): String {
                return "baseball_bat"
            }
        },

        BASEBALL_GLOVE {
            override fun toString(): String {
                return "baseball_glove"
            }
        },

        BEAR {
            override fun toString(): String {
                return "bear"
            }
        },

        BED {
            override fun toString(): String {
                return "bed"
            }
        },

        BENCH {
            override fun toString(): String {
                return "bench"
            }
        },

        BICYCLE {
            override fun toString(): String {
                return "bicycle"
            }
        },

        BIRD {
            override fun toString(): String {
                return "bird"
            }
        },

        BOAT {
            override fun toString(): String {
                return "boat"
            }
        },

        BOOK {
            override fun toString(): String {
                return "book"
            }
        },

        BOTTLE {
            override fun toString(): String {
                return "bottle"
            }
        },

        BOWL {
            override fun toString(): String {
                return "bowl"
            }
        },

        BROCCOLI {
            override fun toString(): String {
                return "broccoli"
            }
        },

        BUS {
            override fun toString(): String {
                return "bus"
            }
        },

        CAKE {
            override fun toString(): String {
                return "cake"
            }
        },

        CAR {
            override fun toString(): String {
                return "car"
            }
        },

        CARROT {
            override fun toString(): String {
                return "carrot"
            }
        },

        CAT {
            override fun toString(): String {
                return "cat"
            }
        },

        CELL_PHONE {
            override fun toString(): String {
                return "cell_phone"
            }
        },

        CHAIR {
            override fun toString(): String {
                return "chair"
            }
        },

        CLOCK {
            override fun toString(): String {
                return "clock"
            }
        },

        COUCH {
            override fun toString(): String {
                return "couch"
            }
        },

        COW {
            override fun toString(): String {
                return "cow"
            }
        },

        CUP {
            override fun toString(): String {
                return "cup"
            }
        },

        DINING_TABLE {
            override fun toString(): String {
                return "dining_table"
            }
        },

        DOG {
            override fun toString(): String {
                return "dog"
            }
        },

        DONUT {
            override fun toString(): String {
                return "donut"
            }
        },

        ELEPHANT {
            override fun toString(): String {
                return "elephant"
            }
        },

        FIRE_HYDRANT {
            override fun toString(): String {
                return "fire_hydrant"
            }
        },

        FORK {
            override fun toString(): String {
                return "fork"
            }
        },

        FRISBEE {
            override fun toString(): String {
                return "frisbee"
            }
        },

        GIRAFFE {
            override fun toString(): String {
                return "giraffe"
            }
        },

        HAIR_DRIER {
            override fun toString(): String {
                return "hair_drier"
            }
        },

        HANDBAG {
            override fun toString(): String {
                return "handbag"
            }
        },

        HORSE {
            override fun toString(): String {
                return "horse"
            }
        },

        HOT_DOG {
            override fun toString(): String {
                return "hot_dog"
            }
        },

        KEYBOARD {
            override fun toString(): String {
                return "keyboard"
            }
        },

        KITE {
            override fun toString(): String {
                return "kite"
            }
        },

        KNIFE {
            override fun toString(): String {
                return "knife"
            }
        },

        LAPTOP {
            override fun toString(): String {
                return "laptop"
            }
        },

        MICROWAVE {
            override fun toString(): String {
                return "microwave"
            }
        },

        MOTORCYCLE {
            override fun toString(): String {
                return "motorcycle"
            }
        },

        MOUSE {
            override fun toString(): String {
                return "mouse"
            }
        },

        ORANGE {
            override fun toString(): String {
                return "orange"
            }
        },

        OVEN {
            override fun toString(): String {
                return "oven"
            }
        },

        PARKING_METER {
            override fun toString(): String {
                return "parking_meter"
            }
        },

        PERSON {
            override fun toString(): String {
                return "person"
            }
        },

        PIZZA {
            override fun toString(): String {
                return "pizza"
            }
        },

        POTTED_PLANT {
            override fun toString(): String {
                return "potted_plant"
            }
        },

        REFRIGERATOR {
            override fun toString(): String {
                return "refrigerator"
            }
        },

        REMOTE {
            override fun toString(): String {
                return "remote"
            }
        },

        SANDWICH {
            override fun toString(): String {
                return "sandwich"
            }
        },

        SCISSORS {
            override fun toString(): String {
                return "scissors"
            }
        },

        SHEEP {
            override fun toString(): String {
                return "sheep"
            }
        },

        SINK {
            override fun toString(): String {
                return "sink"
            }
        },

        SKATEBOARD {
            override fun toString(): String {
                return "skateboard"
            }
        },

        SKIS {
            override fun toString(): String {
                return "skis"
            }
        },

        SNOWBOARD {
            override fun toString(): String {
                return "snowboard"
            }
        },

        SPOON {
            override fun toString(): String {
                return "spoon"
            }
        },

        SPORTS_BALL {
            override fun toString(): String {
                return "sports_ball"
            }
        },

        STOP_SIGN {
            override fun toString(): String {
                return "stop_sign"
            }
        },

        SUITCASE {
            override fun toString(): String {
                return "suitcase"
            }
        },

        SURFBOARD {
            override fun toString(): String {
                return "surfboard"
            }
        },

        TEDDY_BEAR {
            override fun toString(): String {
                return "teddy_bear"
            }
        },

        TENNIS_RACKET {
            override fun toString(): String {
                return "tennis_racket"
            }
        },

        TIE {
            override fun toString(): String {
                return "tie"
            }
        },

        TOASTER {
            override fun toString(): String {
                return "toaster"
            }
        },

        TOILET {
            override fun toString(): String {
                return "toilet"
            }
        },

        TOOTHBRUSH {
            override fun toString(): String {
                return "toothbrush"
            }
        },

        TRAFFIC_LIGHT {
            override fun toString(): String {
                return "traffic_light"
            }
        },

        TRAIN {
            override fun toString(): String {
                return "train"
            }
        },

        TRUCK {
            override fun toString(): String {
                return "truck"
            }
        },

        TV {
            override fun toString(): String {
                return "tv"
            }
        },

        UMBRELLA {
            override fun toString(): String {
                return "umbrella"
            }
        },

        VASE {
            override fun toString(): String {
                return "vase"
            }
        },

        WINE_GLASS {
            override fun toString(): String {
                return "wine_glass"
            }
        },

        ZEBRA {
            override fun toString(): String {
                return "zebra"
            }
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

        objecttype: Objecttype? = null

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
            values = values
        )
    }
}

