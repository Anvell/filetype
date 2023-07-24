@file:Suppress("SpellCheckingInspection")

package io.github.anvell.filetype.matchers

import io.github.anvell.filetype.FileType.Image
import io.github.anvell.filetype.FileType.detect
import io.github.anvell.filetype.io.peekResource
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ImageTest : StringSpec({

    "Detect Avif" {
        detect(peekResource("./sample.avif")) shouldBe Image.Avif
    }

    "Detect Bmp" {
        detect(peekResource("./sample.bmp")) shouldBe Image.Bmp
    }

    "Detect Exr" {
        detect(peekResource("./sample.exr")) shouldBe Image.Exr
    }

    "Detect Gif" {
        detect(peekResource("./sample.gif")) shouldBe Image.Gif
    }

    "Detect Heif" {
        detect(peekResource("./sample.heic")) shouldBe Image.Heif
    }

    "Detect Ico" {
        detect(peekResource("./sample.ico")) shouldBe Image.Ico
    }

    "Detect Jpeg" {
        detect(peekResource("./sample.jpg")) shouldBe Image.Jpeg
    }

    "Detect Jpeg2000" {
        detect(peekResource("./sample.jp2")) shouldBe Image.Jpeg2000
    }

    "Detect Jxr" {
        detect(peekResource("./sample.jxr")) shouldBe Image.Jxr
    }

    "Detect Png" {
        detect(peekResource("./sample.png")) shouldBe Image.Png
    }

    "Detect Psd" {
        detect(peekResource("./sample.psd")) shouldBe Image.Psd
    }

    "Detect Tiff" {
        detect(peekResource("./sample.tif")) shouldBe Image.Tiff
    }

    "Detect Webp" {
        detect(peekResource("./sample.webp")) shouldBe Image.Webp
    }
})
