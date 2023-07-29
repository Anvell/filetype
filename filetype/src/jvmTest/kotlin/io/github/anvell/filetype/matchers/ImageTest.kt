@file:Suppress("SpellCheckingInspection")

package io.github.anvell.filetype.matchers

import io.github.anvell.filetype.FileType.Image
import io.github.anvell.filetype.performDetectionTest
import io.kotest.core.spec.style.StringSpec

private val TestData = listOf(
    "sample.avif" to Image.Avif,
    "sample.bmp" to Image.Bmp,
    "sample.exr" to Image.Exr,
    "sample.gif" to Image.Gif,
    "sample.heic" to Image.Heif,
    "sample.ico" to Image.Ico,
    "sample.jpg" to Image.Jpeg,
    "sample.jp2" to Image.Jpeg2000,
    "sample.jxr" to Image.Jxr,
    "sample.png" to Image.Png,
    "sample.psd" to Image.Psd,
    "sample.tif" to Image.Tiff,
    "sample.webp" to Image.Webp
)

class ImageTest : StringSpec({

    for ((filename, expected) in TestData) {
        performDetectionTest(filename, expected)
    }
})
