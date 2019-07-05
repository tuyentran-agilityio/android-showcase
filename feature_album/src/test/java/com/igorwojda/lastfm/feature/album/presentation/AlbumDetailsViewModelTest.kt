package com.igorwojda.lastfm.feature.album.presentation

import com.igorwojda.lastfm.feature.album.domain.usecase.GetAlbumUseCaseImpl
import com.igorwojda.lastfm.feature.album.presentation.albumdetails.AlbumDetailsViewModel
import com.igorwojda.lastfm.library.testutils.CoroutinesTestRule
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AlbumDetailsViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Mock
    internal lateinit var mockSearchAlbumUseCase: GetAlbumUseCaseImpl

    private lateinit var cut: AlbumDetailsViewModel

    @Before
    fun setUp() {
        cut = AlbumDetailsViewModel(mockSearchAlbumUseCase)
    }

    @Test
    fun `when init then getAlbumUseCase execute`() {
        runBlocking {
            // given
            val albumName = "album"
            val artistName = "artist"
            val mbId = "123"

            // when
            cut.getAlbum(artistName, albumName, mbId)

            // then
            verify(mockSearchAlbumUseCase).execute(artistName, albumName, mbId)
        }
    }
}
