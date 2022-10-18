package org.jetbrains.base64

/**
 * Base64Encoder interface that converts bytes to the Base64 format
 */
interface Base64Encoder {
    fun encode(src: ByteArray): ByteArray

    /**
     * One of the benefits of a multiplatform library is having a default implementation with optional platform-specific overrides.
     */
    fun encodeToString(src: ByteArray): String {
        val encoded = encode(src)
        return buildString(encoded.size) {
            encoded.forEach { append(it.toInt().toChar()) }
        }
    }
}