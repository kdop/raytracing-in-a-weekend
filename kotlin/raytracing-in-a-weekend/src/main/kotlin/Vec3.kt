import kotlin.math.sqrt

class Vec3(X: Double, Y: Double, Z: Double) {
    val e = doubleArrayOf(X, Y, Z)

    fun x() = e[0]
    fun y() = e[1]
    fun z() = e[2]

    constructor() : this(0.0, 0.0, 0.0)

    operator fun minus(other: Vec3) = Vec3(e[0] - other.e[0], e[1] - other.e[1], e[2] - other.e[2])

    operator fun unaryMinus() = Vec3(-e[0], -e[1], -e[2])

    operator fun get(i: Int) = e[i]

    operator fun plus(other: Vec3) = Vec3(e[0] + other.e[0], e[1] + other.e[1], e[2] + other.e[2])

    operator fun plusAssign(other: Vec3) {
        e[0] += other.e[0]
        e[1] += other.e[1]
        e[2] += other.e[2]
    }

    operator fun times(other: Vec3) = Vec3(e[0] * other.e[0], e[1] * other.e[1], e[2] * other.e[2])

    operator fun times(t: Double) = Vec3(t * e[0], t * e[1], t * e[2])

    operator fun div(t: Double) = (1 / t) * this

    operator fun divAssign(other: Vec3) {
        e[0] += other.e[0]
        e[1] += other.e[1]
        e[2] += other.e[2]
    }

    fun length() = sqrt(lengthSquared())

    fun lengthSquared() = e[0]*e[0] + e[1]*e[1] + e[2]*e[2]

    override fun toString() = "${e[0]} ${e[1]} ${e[2]}"
}

operator fun Double.times(other: Vec3) = other * this

fun dot(u: Vec3, v: Vec3) = u.e[0] * v.e[0] + u.e[1] * v.e[1] + u.e[2] * v.e[2]

fun cross(u: Vec3, v: Vec3) = Vec3(
    u.e[1] * v.e[2] - u.e[2] * v.e[1],
    u.e[2] * v.e[0] - u.e[0] * v.e[2],
    u.e[0] * v.e[1] - u.e[1] * v.e[0]
)

fun unitVector(v: Vec3) = v / v.length()

typealias Color = Vec3
typealias Point3 = Vec3