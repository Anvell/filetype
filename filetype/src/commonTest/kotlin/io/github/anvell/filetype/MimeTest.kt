package io.github.anvell.filetype

import io.github.anvell.filetype.Mime.mimeString
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MimeTest : StringSpec({

    "Mime pair formats as a string" {
        val type = Mime.Type.Text
        val subtype = Mime.Subtype("html")
        val sample = "$type/$subtype;charset=utf-8"
        val param = "charset" to "utf-8"
        val mimetype = type to subtype

        mimetype.mimeString(param) shouldBe sample
    }
})
