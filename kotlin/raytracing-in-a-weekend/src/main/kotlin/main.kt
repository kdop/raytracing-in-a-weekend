import java.io.File

const val OUTPUT_IMAGE_PATH = "image.ppm"

class MainClass {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            // Image
            val aspectRatio = 16.0 / 9.0
            val imageWidth = 400
            val imageHeight = (imageWidth / aspectRatio).toInt()

            // Camera
            val viewportHeight = 2.0
            val viewportWidth = aspectRatio * viewportHeight
            val focalLength = 1.0

            val origin = Point3(0.0, 0.0, 0.0)
            val horizontal = Vec3(viewportWidth, 0.0, 0.0)
            val vertical = Vec3(0.0, viewportHeight, 0.0)
            val lowerLeftCorner = origin - (horizontal / 2.0) - (vertical / 2.0) - Vec3(0.0, 0.0, focalLength)

            // Render
            val output = StringBuilder()

            output.appendLine("P3")
            output.appendLine("$imageWidth $imageHeight")
            output.appendLine("255")

            for (j in imageHeight - 1 downTo 0 step 1) {
                println("Scan lines remaining: $j")
                for (i in 0 until imageWidth step 1) {
                    val u = i.toDouble() / (imageWidth - 1)  // 0.0..1.0
                    val v = j.toDouble() / (imageHeight - 1)  // 1.0..0.0

                    val r = Ray(origin, lowerLeftCorner + u * horizontal + v * vertical - origin)
                    val pixelColor = rayColor(r)
                    val pixelColorTranslated = translateColor(pixelColor)
                    println(pixelColorTranslated)
                    output.appendLine(pixelColorTranslated)
                }
            }

            File(OUTPUT_IMAGE_PATH).writeText(output.toString())
        }
    }
}

fun main(args: Array<String>) {
    MainClass.main(args)
}