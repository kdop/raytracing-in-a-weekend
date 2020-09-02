import kotlin.test.Test
import kotlin.test.assertEquals

class Vec3Test {
    @Test
    fun constructorNormal() {
        val v = Vec3(1.0, 2.0, 3.0)
        assertEquals(1.0, v.x())
        assertEquals(2.0, v.y())
        assertEquals(3.0, v.z())
    }

    @Test
    fun constructorEmpty() {
        val v = Vec3()
        assertEquals(0.0, v.x())
        assertEquals(0.0, v.y())
        assertEquals(0.0, v.z())
    }

    @Test
    fun operatorUnaryMinus() {
        val a = Vec3(1.0, 2.0, 3.0)
        val b = -a
        assertEquals(1.0, a.x())
        assertEquals(2.0, a.y())
        assertEquals(3.0, a.z())
        assertEquals(-1.0, b.x())
        assertEquals(-2.0, b.y())
        assertEquals(-3.0, b.z())
    }

    @Test
    fun operatorGet() {
        val a = Vec3(1.0, 2.0, 3.0)
        assertEquals(2.0, a[1])
    }

    @Test
    fun operatorPlusAssign() {
        val a = Vec3(1.0, 2.0, 3.0)
        val b = Vec3(4.0, 5.0, 6.0)
        a += b
        assertEquals(5.0, a.x())
        assertEquals(7.0, a.y())
        assertEquals(9.0, a.z())
        assertEquals(4.0, b.x())
        assertEquals(5.0, b.y())
        assertEquals(6.0, b.z())
    }

    @Test
    fun length() {
        val a = Vec3(-1.0, 2.0, 2.0)
        assertEquals(3.0, a.length())
    }

    @Test
    fun lengthSquared() {
        val a = Vec3(-1.0, 2.0, 2.0)
        assertEquals(9.0, a.lengthSquared())
    }

    @Test
    fun vec3toString() {
        val a = Vec3(1.0, 2.0, 3.0)
        assertEquals("1.0 2.0 3.0", a.toString())
    }

    @Test
    fun operatorPlus() {
        val a = Vec3(1.0, 2.0, 3.0)
        val b = Vec3(1.0, 2.0, 3.0)
        val c = a + b
        assertEquals(2.0, c.x())
        assertEquals(4.0, c.y())
        assertEquals(6.0, c.z())
    }

    @Test
    fun operatorMinus() {
        val a = Vec3(4.0, 5.0, 6.0)
        val b = Vec3(1.0, 1.0, 0.0)
        val c = a - b
        assertEquals(3.0, c.x())
        assertEquals(4.0, c.y())
        assertEquals(6.0, c.z())
    }

    @Test
    fun operatorVec3TimesVec3() {
        val a = Vec3(4.0, 5.0, 6.0)
        val b = Vec3(1.0, 3.0, 0.0)
        val c = a * b
        assertEquals(4.0, c.x())
        assertEquals(15.0, c.y())
        assertEquals(0.0, c.z())
    }

    @Test
    fun operatorVec3TimesT() {
        val a = Vec3(4.0, 5.0, 6.0)
        val t = 7.0
        val c = a * t
        assertEquals(28.0, c.x())
        assertEquals(35.0, c.y())
        assertEquals(42.0, c.z())
    }

    @Test
    fun operatorTTimesVec3() {
        val a = Vec3(4.0, 5.0, 6.0)
        val t = 7.0
        val c = t * a
        assertEquals(28.0, c.x())
        assertEquals(35.0, c.y())
        assertEquals(42.0, c.z())
    }

    @Test
    fun operatorVec3DivT() {
        val a = Vec3(4.0, 5.0, 6.0)
        val t = 2.0
        val c = a / t
        assertEquals(2.0, c.x())
        assertEquals(2.5, c.y())
        assertEquals(3.0, c.z())
    }

    @Test
    fun dot() {
        val a = Vec3(4.0, 5.0, 6.0)
        val b = Vec3(4.0, 5.0, 6.0)
        val dot = dot(a, b)
        assertEquals(dot, 77.0)
    }

    @Test
    fun cross() {
        val a = Vec3(1.0, 2.0, 3.0)
        val b = Vec3(4.0, 5.0, 6.0)
        val c = cross(a, b)
        assertEquals(-3.0, c.x())
        assertEquals(6.0, c.y())
        assertEquals(-3.0, c.z())
    }

    @Test
    fun unitVector() {
        val a = Vec3(0.0, 0.0, 2.0)
        val c = unitVector(a)
        assertEquals(0.0, c.x())
        assertEquals(0.0, c.y())
        assertEquals(1.0, c.z())
    }
}