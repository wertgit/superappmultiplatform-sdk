package org.jetbrains.base64

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * You can also add tests that will be run only for a specific platform. For example, you can add UTF-16 tests on JVM
 * This test will automatically run on the JVM platform in addition to the common tests.
 */
class Base64JvmTest {
    @Test
    fun testNonAsciiString() {
        val utf8String = "Gödel"
        val actual = Base64Factory.createEncoder().encodeToString(utf8String.toByteArray())
        assertEquals("R8O2ZGVs", actual)
    }
}