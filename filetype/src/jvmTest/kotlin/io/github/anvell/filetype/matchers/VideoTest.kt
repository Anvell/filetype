package io.github.anvell.filetype.matchers

import io.github.anvell.filetype.FileType.Video
import io.github.anvell.filetype.performDetectionTest
import io.kotest.core.spec.style.StringSpec

private val TestData = listOf(
    "sample.m4v" to Video.M4v,
    "sample.mkv" to Video.Mkv,
    "sample.webm" to Video.Webm,
    "sample.mov" to Video.Mov,
    "sample.avi" to Video.Avi,
    "sample.wmv" to Video.Wmv,
    "sample.mpeg" to Video.Mpeg,
    "sample.flv" to Video.Flv,
    "sample.mp4" to Video.Mp4
)

class VideoTest : StringSpec({

    for ((filename, expected) in TestData) {
        performDetectionTest(filename, expected)
    }
})
