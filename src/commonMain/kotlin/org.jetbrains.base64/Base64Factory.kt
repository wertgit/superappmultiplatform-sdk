package org.jetbrains.base64

/**
 * The factory object is marked with the expect keyword in the cross-platform code.
 * For each platform, you should provide an actual implementation of the Base64Factory
 * object with the platform-specific encoder
 * This library will convert raw data – strings and byte arrays – to Base64 format.
 * To implement the conversion to the Base64 format on the different platforms,
 * you will use the platform capabilities for JVM and JS, and write your own implementation for Native.
 */
expect object Base64Factory {
    fun createEncoder(): Base64Encoder
}