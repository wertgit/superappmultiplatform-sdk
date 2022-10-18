package org.jetbrains.base64

/**
 * Base64Encoder interface that converts bytes to the Base64 format
 */
interface Base64Encoder {
    fun encode(src: ByteArray): ByteArray
}