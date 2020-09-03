import java.io.File

const val OUTPUT_IMAGE_PATH = "image.ppm"

class MainClass {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val imageWidth = 256
            val imageHeight = 256

            val output = StringBuilder()

            output.appendLine("P3")
            output.appendLine("$imageWidth $imageHeight")
            output.appendLine("255")

            for (j in imageHeight - 1 downTo 0 step 1) {
                println("Scan lines remaining: $j")
                for (i in 0 until imageWidth step 1) {
                    val pixelColor = Color(
                            i.toDouble() / (imageWidth - 1),
                            j.toDouble() / (imageHeight - 1),
                            0.25
                    )
                    val colorString = writeColor(pixelColor)
                    println(colorString)
                    output.appendLine(colorString)
                }
            }

            File(OUTPUT_IMAGE_PATH).writeText(output.toString())
        }
    }
}

fun main(args: Array<String>) {
    MainClass.main(args)
}