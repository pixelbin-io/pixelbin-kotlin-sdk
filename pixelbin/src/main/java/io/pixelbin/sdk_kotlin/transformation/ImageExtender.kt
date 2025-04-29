package io.pixelbin.sdk_kotlin.transformation

import io.pixelbin.sdk_kotlin.TransformationObj

class BgExtend {

  /**
   * Method for AI Image Extender
   *
   * @param Bounding Box bbox
   * @param Prompt custom (Default: )
   * @param Guidance Scale Int (Default: 30)
   * @param Number of inference steps Int (Default: 50)
   * @param seed Int (Default: 123)
   * @return TransformationObj.
   */
  @JvmOverloads
  fun extend(
      boundingbox: String? = null,
      prompt: String? = null,
      guidancescale: Int? = null,
      numberofinferencesteps: Int? = null,
      seed: Int? = null
  ): TransformationObj {
    // Create the values HashMap
    val values = HashMap<String, String>()

    if (!boundingbox.isNullOrEmpty()) {
      values["bbox"] = boundingbox.toString()
    }

    if (!prompt.isNullOrEmpty()) {
      values["p"] = prompt.toString()
    }

    values["gs"] = guidancescale.toString()

    values["nis"] = numberofinferencesteps.toString()

    values["sd"] = seed.toString()

    return TransformationObj(plugin = "bg", name = "extend", values = values)
  }
}
