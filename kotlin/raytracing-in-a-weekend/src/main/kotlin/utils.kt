fun hitSphere(center: Point3, radius: Double, r: Ray): Boolean {
    val oc = r.origin() - center
    val a = dot(r.direction(), r.direction())
    val b = 2.0 * dot(oc, r.direction())
    val c = dot(oc, oc) - radius * radius
    val discriminant = b * b - 4 * a * c
    return discriminant > 0
}