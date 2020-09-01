fun main() {
    val imageWidth = 256
    val imageHeight = 256

    println("P3")
    println("$imageWidth $imageHeight")
    println("255")

    for (j in imageHeight - 1 downTo 0 step 1) {
        println("Scanlines remaining: $j")
        for (i in 0 until imageWidth step 1) {
            val r = i.toDouble() / (imageWidth - 1)
            val g = j.toDouble() / (imageHeight - 1)
            val b = 0.25

            val ir = (255.999 * r).toInt()
            val ig = (255.999 * g).toInt()
            val ib = (255.999 * b).toInt()

            println("$ir $ig $ib")
        }
    }
}