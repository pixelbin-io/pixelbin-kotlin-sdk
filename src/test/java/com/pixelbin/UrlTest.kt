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
        val workerUrl = "https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/wrkr/resize:h100,w:200/folder/image.jpeg"
        val customDomainUrl = "https://xyz.designify.media/v2/z-slug/t.resize(h:100,w:200)~t.flip()/path/to/image.jpeg"

        val urlClassObj = Url(imageUrl)
        val workerClassObj = Url(workerUrl)
        val customClassDomainObj = Url(customDomainUrl)

        // Act
        val createdUrl = urlClassObj.getUrl()
        val createdWorkerUrl = workerClassObj.getUrl()
        val createdCustomDomainUrl = customClassDomainObj.getUrl()

        // Assert
        assertEquals(imageUrl, createdUrl)
        assertEquals(workerUrl, createdWorkerUrl)
        assertEquals(customDomainUrl, createdCustomDomainUrl)
    }

    @Test
    fun testAddTransformation() {
        // Arrange
        val imageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/original/__playground/playground-default.jpeg"
        val workerUrl = "https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/wrkr/resize:h100,w:200/folder/image.jpeg"
        val customDomainUrl = "https://xyz.designify.media/v2/orange-lake-60c8e1/original/__playground/playground-default.jpeg"

        val urlClassObj = Url(imageUrl)
        val workerUrlClassObj = Url(workerUrl)
        val customDomainClassObj = Url(customDomainUrl)

        // Act
        val transformedUrl = urlClassObj.addTransformation(
            TransformationObj(
                plugin = "t",
                name = "resize",
                values = hashMapOf(
                    "w" to "200",
                    "h" to "300",
                )
            )
        ).getUrl()

        val transformedWorkerUrl = workerUrlClassObj.addTransformation(
            TransformationObj(
                plugin = "t",
                name = "resize",
                values = hashMapOf(
                    "w" to "200",
                    "h" to "300",
                )
            )
        ).getUrl()

        val transformedcustomDomainUrl = customDomainClassObj.addTransformation(
            TransformationObj(
                plugin = "t",
                name = "resize",
                values = hashMapOf(
                    "w" to "200",
                    "h" to "300",
                )
            )
        ).getUrl()

        // Assert
        val expectedUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/t.resize(h:300,w:200)/__playground/playground-default.jpeg"
        val expectedCustomDomainUrl = "https://xyz.designify.media/v2/orange-lake-60c8e1/t.resize(h:300,w:200)/__playground/playground-default.jpeg"

        assertEquals(expectedUrl, transformedUrl)
        assertEquals(workerUrl, transformedWorkerUrl)
        assertEquals(expectedCustomDomainUrl, transformedcustomDomainUrl)
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
                    plugin = "t",
                    name = "flip",
                ),
                TransformationObj(
                    plugin = "t",
                    name = "flop",
                )
            )
        ).getUrl()

        // Assert
        val expectedUrl =
            "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/t.flip()~t.flop()/__playground/playground-default.jpeg"
        assertEquals(expectedUrl, transformedUrl)
    }

    @Test
    fun testGetUrlObject() {
        // Arrange
        val imageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/t.resize(w:200,h:300)/__playground/playground-default.jpeg"
        val optionImageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/t.resize(w:200,h:300)/__playground/playground-default.jpeg?dpr=auto&f_auto=true"
        val workerUrl = "https://xyz.designify.media/v2/orange-lake-60c8e1/z-slug/wrkr/resize:h100,w:200/folder/image.jpeg"
        val optionWorkerUrl = "https://xyz.designify.media/v2/orange-lake-60c8e1/z-slug/wrkr/resize:h100,w:200/folder/image.jpeg?dpr=auto&f_auto=true"
        val customDomainUrl = "https://xyz.designify.media/v2/orange-lake-60c8e1/original/__playground/playground-default.jpeg"

        val url = Url(imageUrl)
        val optionUrl = Url(optionImageUrl)
        val workerUrlClassObj = Url(workerUrl)
        val optionWorkerUrlClassObj = Url(optionWorkerUrl)
        val customDomainUrlClassObj = Url(customDomainUrl)

        // Act
        val urlObj = url.getUrlObject()
        val optionUrlObj = optionUrl.getUrlObject()
        val workerUrlObj = workerUrlClassObj.getUrlObject()
        val optionWorkerUrlObj = optionWorkerUrlClassObj.getUrlObject()
        val customDomainObj = customDomainUrlClassObj.getUrlObject()

        // Assert
        assertNotNull(urlObj)
        if (urlObj != null) {
            assertEquals("https://cdn.pixelbin.io", urlObj.baseUrl)
            assertEquals("v2", urlObj.version)
            assertEquals("orange-lake-60c8e1", urlObj.cloudName)
            assertEquals(
                "t.resize(w:200,h:300)",
                Utility.getTransformationString(urlObj.transformation)
            )
            assertEquals("", urlObj.zone)
            assertEquals("__playground/playground-default.jpeg", urlObj.filePath)
        }

        assertNotNull(optionUrl)
        if (optionUrlObj != null) {
            assertEquals("https://cdn.pixelbin.io", optionUrlObj.baseUrl)
            assertEquals("v2", optionUrlObj.version)
            assertEquals("orange-lake-60c8e1", optionUrlObj.cloudName)
            assertEquals(
                "t.resize(w:200,h:300)",
                Utility.getTransformationString(optionUrlObj.transformation)
            )
            assertEquals("", optionUrlObj.zone)
            assertEquals("__playground/playground-default.jpeg", optionUrlObj.filePath)
            assertEquals(
                hashMapOf(
                    "dpr" to "auto",
                    "f_auto" to "true"
                ), optionUrlObj.options
            )
        }

        assertNotNull(workerUrlObj)
        if (workerUrlObj != null) {
            assertEquals("https://xyz.designify.media", workerUrlObj.baseUrl)
            assertEquals("v2", workerUrlObj.version)
            assertEquals("orange-lake-60c8e1", workerUrlObj.cloudName)
            assertEquals("",
                workerUrlObj.transformation.let { Utility.getTransformationString(it) })
            assertEquals("z-slug", workerUrlObj.zone)
            assertEquals("", workerUrlObj.filePath)
            assertEquals("wrkr/resize:h100,w:200/folder/image.jpeg", workerUrlObj.workerPath)
        }

        assertNotNull(optionWorkerUrlObj)
        if (optionWorkerUrlObj != null) {
            assertEquals("https://xyz.designify.media", optionWorkerUrlObj.baseUrl)
            assertEquals("v2", optionWorkerUrlObj.version)
            assertEquals("orange-lake-60c8e1", optionWorkerUrlObj.cloudName)
            assertEquals("",
                optionWorkerUrlObj.transformation.let { Utility.getTransformationString(it) })
            assertEquals("z-slug", optionWorkerUrlObj.zone)
            assertEquals("", optionWorkerUrlObj.filePath)
            assertEquals("wrkr/resize:h100,w:200/folder/image.jpeg", optionWorkerUrlObj.workerPath)
            assertEquals(
                hashMapOf(
                    "dpr" to "auto",
                    "f_auto" to "true"
                ), optionWorkerUrlObj.options
            )
        }

        assertNotNull(customDomainObj)
        if (customDomainObj != null) {
            assertEquals("https://xyz.designify.media", customDomainObj.baseUrl)
            assertEquals("v2", customDomainObj.version)
            assertEquals("orange-lake-60c8e1", customDomainObj.cloudName)
            assertEquals("",
                customDomainObj.transformation.let { Utility.getTransformationString(it) })
            assertEquals("", customDomainObj.zone)
            assertEquals("__playground/playground-default.jpeg", customDomainObj.filePath)
        }
        // Add assertions for other properties of UrlObj
    }

    @Test
    fun testGetUrl() {
        // Arrange
        val imageUrl = "https://cdn.pixelbin.io/v2/orange-lake-60c8e1/t.resize(w:200,h:300)/__playground/playground-default.jpeg"
        val workerUrl = "https://cdn.pixelbin.io/v2/your-cloud-name/z-slug/wrkr/resize:h100,w:200/folder/image.jpeg"
        val customDomainUrl = "https://xyz.designify.media/v2/orange-lake-60c8e1/t.resize(w:200,h:300)/__playground/playground-default.jpeg"

        val url = Url(imageUrl)
        val workerUrlClassObj = Url(workerUrl)
        val customDomainUrlClassObj = Url(customDomainUrl)

        // Act
        val urlStr = url.getUrl()
        val workerUrlStr = workerUrlClassObj.getUrl()
        val customDomainStr = customDomainUrlClassObj.getUrl()

        // Assert
        assertEquals(imageUrl, urlStr)
        assertEquals(workerUrl, workerUrlStr)
        assertEquals(customDomainUrl, customDomainStr)
    }
}
