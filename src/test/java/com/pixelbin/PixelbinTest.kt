package com.pixelbin

import com.pixelbin.error.PDKInvalidUrlException
import org.junit.Test
import org.junit.Assert.*

class PixelBinTest {
    @Test
    fun testValidImageUrl() {
        // Arrange
        val pixelBin = PixelBin.getInstance()
        val imageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/original/__playground/playground-default.jpeg"

        // Act
        val url = pixelBin.url(imageUrl)

        // Assert
        assertNotNull(url)
        assertEquals(imageUrl, url.getUrl())
    }

    @Test(expected = PDKInvalidUrlException::class)
    fun testInvalidImageUrl() {
        // Arrange
        val pixelBin = PixelBin.getInstance()
        val invalidImageUrl = "invalid_url"

        // Act
        pixelBin.url(invalidImageUrl)

        // Expect IllegalArgumentException to be thrown
    }
}
