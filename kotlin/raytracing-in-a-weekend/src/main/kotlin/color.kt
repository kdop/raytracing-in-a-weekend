fun writeColor(pixelColor: Color): String {
    // Write the translated [0,255] value of each color component.
    val ir = (255.999 * pixelColor.x()).toInt()
    val ig = (255.999 * pixelColor.y()).toInt()
    val ib = (255.999 * pixelColor.z()).toInt()
    return "$ir $ig $ib"
}