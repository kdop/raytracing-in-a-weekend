class Ray(origin: Point3, direction: Vec3) {
    private val orig = origin
    private val dir = direction

    fun origin() = this.orig
    fun direction() = this.dir
    fun at(t: Double) = orig + (t * dir)
}