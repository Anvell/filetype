package io.github.anvell.filetype.matchers

import io.github.anvell.filetype.FileType
import io.github.anvell.filetype.performDetectionTest
import io.kotest.core.spec.style.StringSpec

private val TestData = listOf(
    "sample.jks" to FileType.Credentials.Jks,
    "sample.kdbx" to FileType.Credentials.Kdbx,
    "sample.pri" to FileType.Credentials.OpenSshPrivateKey,
    "sample.cer" to FileType.Credentials.Pem
)

class CredentialsTest : StringSpec({

    for ((filename, expected) in TestData) {
        performDetectionTest(filename, expected)
    }
})
