package io.github.anvell.filetype.extensions

/**
 * Matches [ByteArray] against [signature].
 */
internal fun ByteArray.matchSignature(
    vararg signature: Byte
): Boolean = size >= signature.size &&
    sliceArray(signature.indices).contentEquals(signature)
