package com.album.leboncoin.data

import junit.framework.TestCase
import org.hamcrest.MatcherAssert


class ItemTest : TestCase() {

    fun testGetAlbumId() {
        val albumId: Long = 100
        // Given a Context object retrieved from Robolectric...
        val myObjectUnderTest = Item(
                100,
                5000,
                "https://via.placeholder.com/150/6dd9cb",
                "error quasi sunt cupiditate voluptate ea odit beatae",
                "https://via.placeholder.com/600/6dd9cb")

        // ...when the result is returned from the object under test...
        val result_albumId: Long = myObjectUnderTest.albumId.toLong()

        // ...then the result should be the expected one.
        MatcherAssert.assertThat(result_albumId.toString(), true).equals(albumId)
    }

    fun testGetId() {
        val id: Long = 5000
        // Given a Context object retrieved from Robolectric...
        val myObjectUnderTest = Item(
                100,
                5000,
                "https://via.placeholder.com/150/6dd9cb",
                "error quasi sunt cupiditate voluptate ea odit beatae",
                "https://via.placeholder.com/600/6dd9cb")

        // ...when the result is returned from the object under test...
        val resultId: Long = myObjectUnderTest.id.toLong()

        // ...then the result should be the expected one.
        MatcherAssert.assertThat(resultId.toString(), true).equals(id)
    }

    fun testGetThumbnailUrl() {
        val thumbnailUrl = "https://via.placeholder.com/150/6dd9cb"
        // Given a Context object retrieved from Robolectric...
        val myObjectUnderTest = Item(
                100,
                5000,
                "https://via.placeholder.com/150/6dd9cb",
                "error quasi sunt cupiditate voluptate ea odit beatae",
                "https://via.placeholder.com/600/6dd9cb")

        // ...when the result is returned from the object under test...
        val resultThumbnailUrl: String = myObjectUnderTest.thumbnailUrl

        // ...then the result should be the expected one.
        MatcherAssert.assertThat(resultThumbnailUrl, true).equals(thumbnailUrl)
    }

    fun testGetUrl() {
        val url = "https://via.placeholder.com/600/6dd9cb"
        // Given a Context object retrieved from Robolectric...
        val myObjectUnderTest = Item(
                100,
                5000,
                "https://via.placeholder.com/150/6dd9cb",
                "error quasi sunt cupiditate voluptate ea odit beatae",
                "https://via.placeholder.com/600/6dd9cb")

        // ...when the result is returned from the object under test...
        val resultUrl = myObjectUnderTest.url

        // ...then the result should be the expected one.
        MatcherAssert.assertThat(resultUrl, true).equals(url)

    }

    fun testGetTitle() {
        val title = "error quasi sunt cupiditate voluptate ea odit beatae"
        // Given a Context object retrieved from Robolectric...
        val myObjectUnderTest = Item(
                100,
                5000,
                "https://via.placeholder.com/150/6dd9cb",
                "error quasi sunt cupiditate voluptate ea odit beatae",
                "https://via.placeholder.com/600/6dd9cb")

        // ...when the result is returned from the object under test...
        val resultTitle = myObjectUnderTest.title

        // ...then the result should be the expected one.
        MatcherAssert.assertThat(resultTitle, true).equals(title)
    }

}