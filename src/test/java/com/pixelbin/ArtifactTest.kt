package com.pixelbin

import com.pixelbin.transformation.type.AfRemove
import org.junit.Test
import org.junit.Assert.*

class ArtifactTest {
    @Test
    fun testRemoveTransformation() {
        // Arrange
        val artifact = AfRemove()

        // Act
        val transformationObj = artifact.remove()

        // Assert
        assertNotNull(transformationObj)
        assertEquals("remove", transformationObj.name)
        assertEquals("af", transformationObj.plugin)
        assertEquals(emptyMap<String, String>(), transformationObj.values)
    }
}


