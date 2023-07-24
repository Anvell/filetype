package io.github.anvell.filetype

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MimeTest : StringSpec({

    "Formats as a string with parameter" {
        val type = Mime.Type.Text
        val subtype = Mime.Subtype("html")
        val sample = "$type/$subtype;charset=utf-8"
        val param = "charset" to "utf-8"
        val mimetype = Mime(type, subtype)

        mimetype.toString(param) shouldBe sample
    }
})
