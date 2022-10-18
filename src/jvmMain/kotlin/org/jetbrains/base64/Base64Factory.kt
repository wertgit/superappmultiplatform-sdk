package org.jetbrains.base64

import java.util.*

/**
 *  We are provided a platform-specific implementation
 *  by using a straightforward delegation to a third-party implementation.
 */
actual object Base64Factory {
    actual fun createEncoder(): Base64Encoder = JvmBase64Encoder
}

object JvmBase64Encoder : Base64Encoder {
    override fun encode(src: ByteArray): ByteArray = Base64.getEncoder().encode(src)
    override fun encodeToString(src: ByteArray): String = Base64.getEncoder().encodeToString(src)
}