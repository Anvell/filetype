package io.github.anvell.filetype

import io.github.anvell.filetype.io.peekResource
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal fun StringSpec.performDetectionTest(
    sampleFile: String,
    type: Mime
) {
    "Detect $type" {
        FileType.detect(peekResource("./$sampleFile")) shouldBe type
    }
}
