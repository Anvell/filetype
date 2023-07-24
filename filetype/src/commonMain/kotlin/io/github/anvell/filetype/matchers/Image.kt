@file:Suppress("SpellCheckingInspection")

package io.github.anvell.filetype.matchers

import io.github.anvell.filetype.FileType
import io.github.anvell.filetype.FileType.Image
import io.github.anvell.filetype.extensions.b
import io.github.anvell.filetype.extensions.matchSignature

private val Avif = FileType.Matcher { buffer ->
    IsoBmff.checkFormat(buffer, "avif")
}

private val Bmp = FileType.Matcher { buffer ->
    buffer.matchSignature(0x42.b, 0x4D.b)
}

private val Dwg = FileType.Matcher { buffer ->
    buffer.matchSignature(0x41.b, 0x43.b, 0x31.b, 0x30.b)
}

private val Exr = FileType.Matcher { buffer ->
    buffer.matchSignature(0x76.b, 0x2f.b, 0x31.b, 0x01.b)
}

private val Gif = FileType.Matcher { buffer ->
    buffer.matchSignature(0x47.b, 0x49.b, 0x46.b)
}

private val Heif = FileType.Matcher { buffer ->
    IsoBmff.checkFormat(buffer, "heic")
}

private val Ico = FileType.Matcher { buffer ->
    buffer.matchSignature(0x00, 0x00, 0x01, 0x00)
}

private val Jpeg = FileType.Matcher { buffer ->
    buffer.matchSignature(0xFF.b, 0xD8.b, 0xFF.b)
}

private val Jpeg2000 = FileType.Matcher { buffer ->
    buffer.matchSignature(
        0x0.b, 0x0.b, 0x0.b, 0xC.b, 0x6A.b, 0x50.b, 0x20.b,
        0x20.b, 0xD.b, 0xA.b, 0x87.b, 0xA.b, 0x0.b
    )
}

private val Jxr = FileType.Matcher { buffer ->
    buffer.matchSignature(0x49.b, 0x49.b, 0xBC.b)
}

private val Png = FileType.Matcher { buffer ->
    buffer.matchSignature(0x89.b, 0x50.b, 0x4E.b, 0x47.b)
}

private val Psd = FileType.Matcher { buffer ->
    buffer.matchSignature(0x38.b, 0x42.b, 0x50.b, 0x53.b)
}

private val Tiff = FileType.Matcher { buffer ->
    if (buffer.size <= 10) return@Matcher false

    val littleEndian = buffer.matchSignature(0x49, 0x49, 0x2A, 0x0)
    val bigEndian = buffer.matchSignature(0x4D, 0x4D, 0x0, 0x2A)
    val excludeCr2 = buffer[8] != 0x43.b &&
        buffer[9] != 0x52.b &&
        buffer[10] != 0x02.b

    (littleEndian || bigEndian) && excludeCr2
}

private val Webp = FileType.Matcher { buffer ->
    buffer.size > 11 &&
        buffer[8] == 0x57.b &&
        buffer[9] == 0x45.b &&
        buffer[10] == 0x42.b &&
        buffer[11] == 0x50.b
}

internal val ImageMatchers = mapOf(
    Image.Jpeg to Jpeg,
    Image.Jpeg2000 to Jpeg2000,
    Image.Png to Png,
    Image.Gif to Gif,
    Image.Webp to Webp,
    Image.Tiff to Tiff,
    Image.Bmp to Bmp,
    Image.Jxr to Jxr,
    Image.Psd to Psd,
    Image.Ico to Ico,
    Image.Heif to Heif,
    Image.Dwg to Dwg,
    Image.Exr to Exr,
    Image.Avif to Avif
)
