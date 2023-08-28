package com.pixelbin

import com.pixelbin.transformation.TransformationObj
import com.pixelbin.url.Url
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class UrlTest {
    @Test
    fun testCreateUrl() {
        // Arrange
        val imageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/original/__playground/playground-default.jpeg"
        val url = Url(imageUrl)

        // Act
        val createdUrl = url.getUrl()

        // Assert
        assertEquals(imageUrl, createdUrl)
    }

    @Test
    fun testAddTransformation() {
        // Arrange
        val imageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/original/__playground/playground-default.jpeg"
        val url = Url(imageUrl)

        // Act
        val transformedUrl = url.addTransformation(
            TransformationObj(
                plugin="t",
                name = "resize",
                values = hashMapOf(
                    "w" to "200",
                    "h" to "300",
                )
            )
        ).getUrl()

        // Assert
        val expectedUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/t.resize(h:300,w:200)/__playground/playground-default.jpeg"
        assertEquals(expectedUrl, transformedUrl)
    }

    @Test
    fun testAddMultipleTransformation() {
        // Arrange
        val imageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/original/__playground/playground-default.jpeg"
        val url = Url(imageUrl)

        // Act
        val transformedUrl = url.addTransformation(
            arrayListOf(
                TransformationObj(
                plugin="t",
                name = "flip",
                ),
                TransformationObj(
                plugin="t",
                name = "flop",
                )
            )
        ).getUrl()

        // Assert
        val expectedUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/t.flip()~t.flop()/__playground/playground-default.jpeg"
        assertEquals(expectedUrl, transformedUrl)
    }

    @Test
    fun testGetUrlObject() {
        // Arrange
        val imageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/t.resize(w:200,h:300)/__playground/playground-default.jpeg"
        val url = Url(imageUrl)

        // Act
        val urlObj = url.getUrlObject()

        // Assert
        assertNotNull(urlObj)
        if (urlObj != null) {
            assertEquals("https://cdn.pixelbin.io", urlObj.baseUrl)
            assertEquals("v2", urlObj.version)
            assertEquals("orange-lake-60c8e1", urlObj.cloudName)
            assertEquals("t.resize(w:200,h:300)", Utility.getTransformationString(urlObj.transformation))
            assertEquals("", urlObj.zone)
            assertEquals("__playground/playground-default.jpeg", urlObj.filePath)
        }
        // Add assertions for other properties of UrlObj
    }

    @Test
    fun testGetUrl() {
        // Arrange
        val imageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/t.resize(w:200,h:300)/__playground/playground-default.jpeg"
        val url = Url(imageUrl)

        // Act
        val urlStr = url.getUrl()

        // Assert
        assertEquals(imageUrl, urlStr)
    }
}
