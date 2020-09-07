fun translateColor(pixelColor: Color): String {
    // this function is called write_color in the tutorial

    // calculate translated [0, 255] value of each color component
    val ir = (255.999 * pixelColor.x()).toInt()
    val ig = (255.999 * pixelColor.y()).toInt()
    val ib = (255.999 * pixelColor.z()).toInt()

    return "$ir $ig $ib"
}

fun rayColor(r: Ray): Color {
    if (hitSphere(Point3(0.0,0.0,-1.0), 0.5, r)) {
        return Color(1.0, 0.0, 0.0)
    }

    val unitDirection = unitVector(r.direction())
    val t = 0.5 * (unitDirection.y() + 1.0)

    return (1.0 - t) * Color(1.0, 1.0, 1.0) +
                   t * Color(0.5, 0.7, 1.0)

}