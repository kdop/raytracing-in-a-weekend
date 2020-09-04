import kotlin.test.Test
import kotlin.test.assertEquals

val p = Point3(5.0,4.0, 6.0)
val v = Vec3(1.0, 2.0, 3.0)
val r = Ray(p,  v)

class RayTest {
    @Test
    fun constructorNormal() {
        assertEquals(5.0, r.origin().x())
        assertEquals(3.0, r.direction().z())
    }

    @Test
    fun at() {
        assertEquals(18.0, r.at(7.0).y())
    }
}