@file:Suppress("SpellCheckingInspection")

package io.github.anvell.filetype

import io.github.anvell.filetype.Mime.Subtype
import io.github.anvell.filetype.Mime.Type
import io.github.anvell.filetype.matchers.ImageMatchers

object FileType {
    private val DefaultMatchers: Map<Mime, Matcher> = ImageMatchers

    fun interface Matcher {
        operator fun invoke(buffer: ByteArray): Boolean
    }

    /**
     * Attempts to detect [Mime] from a given [buffer].
     */
    fun detect(buffer: ByteArray): Mime? {
        for ((fileType, matcher) in DefaultMatchers) {
            if (matcher(buffer)) return fileType
        }

        return null
    }

    /**
     * Detectable image [Mime].
     */
    object Image {
        val Avif = imageMime("avif")
        val Bmp = imageMime("bmp")
        val Dwg = imageMime("vnd.dwg")
        val Exr = imageMime("x-exr")
        val Gif = imageMime("gif")
        val Heif = imageMime("heif")
        val Ico = imageMime("vnd.microsoft.icon")
        val Jpeg = imageMime("jpeg")
        val Jpeg2000 = imageMime("jp2")
        val Jxr = imageMime("vnd.ms-photo")
        val Png = imageMime("png")
        val Psd = imageMime("vnd.adobe.photoshop")
        val Tiff = imageMime("tiff")
        val Webp = imageMime("webp")

        private fun imageMime(
            subtype: String
        ) = Mime(Type.Image, Subtype(subtype))
    }
}
