package io.github.anvell.filetype.matchers

import io.github.anvell.filetype.FileType.Document
import io.github.anvell.filetype.performDetectionTest
import io.kotest.core.spec.style.StringSpec

private val TestData = listOf(
    "sample.pdf" to Document.Pdf,
    "sample.rtf" to Document.Rtf
)

class DocumentTest : StringSpec({

    for ((filename, expected) in TestData) {
        performDetectionTest(filename, expected)
    }
})
