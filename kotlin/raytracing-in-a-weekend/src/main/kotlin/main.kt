class MainClass {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val imageWidth = 256
            val imageHeight = 256

            println("P3")
            println("$imageWidth $imageHeight")
            println("255")

            for (j in imageHeight - 1 downTo 0 step 1) {
                println("Scan lines remaining: $j")
                for (i in 0 until imageWidth step 1) {
                    val pixelColor = Color(
                            i.toDouble() / (imageWidth - 1),
                            j.toDouble() / (imageHeight - 1),
                            0.25
                    )

                    writeColor(pixelColor)
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    MainClass.main(args)
}