package io.github.anvell.filetype.io

private const val PeekSize = 8 * 1024

internal fun peekResource(
    fileName: String
): ByteArray = ClassLoader
    .getSystemResourceAsStream(fileName)
    ?.readNBytes(PeekSize)
    ?: error("Cannot find resource file: $fileName.")
