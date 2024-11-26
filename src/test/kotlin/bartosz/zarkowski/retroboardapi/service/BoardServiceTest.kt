package bartosz.zarkowski.retroboardapi.service

import bartosz.zarkowski.retroboardapi.dummyData.BoardDummyData
import bartosz.zarkowski.retroboardapi.dummyData.BoardDummyData.Companion.BOARD_DESCRIPTION
import bartosz.zarkowski.retroboardapi.dummyData.BoardDummyData.Companion.BOARD_TITLE
import bartosz.zarkowski.retroboardapi.dummyData.BoardDummyData.Companion.CREATE_BOARD_DESCRIPTION
import bartosz.zarkowski.retroboardapi.dummyData.BoardDummyData.Companion.CREATE_BOARD_TITLE
import bartosz.zarkowski.retroboardapi.dummyData.BoardDummyData.Companion.UPDATE_BOARD_DESCRIPTION
import bartosz.zarkowski.retroboardapi.dummyData.BoardDummyData.Companion.UPDATE_BOARD_TITLE
import bartosz.zarkowski.retroboardapi.entity.Board
import bartosz.zarkowski.retroboardapi.exception.NotFoundException
import bartosz.zarkowski.retroboardapi.extension.toBoard
import bartosz.zarkowski.retroboardapi.repository.BoardRepositoryInterface
import bartosz.zarkowski.retroboardapi.service.BoardService.Companion.BOARD_NOT_FOUND_EXCEPTION_MESSAGE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.kotlin.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import java.util.UUID
import kotlin.test.Test

class BoardServiceTest {

    private val boardRepository: BoardRepositoryInterface = mock()

    private val boardService = BoardService(boardRepository)

    private val boardDummyData = BoardDummyData()

    @Test
    fun `getBoardById returns board response`() {
        val board = boardDummyData.board

        whenever(boardRepository.findBoardById(eq(board.id))).thenReturn(board)

        val boardResponse = boardService.getBoardById(board.id)

        assertEquals(BOARD_TITLE, boardResponse.title)
        assertEquals(BOARD_DESCRIPTION, boardResponse.description)
        verify(boardRepository, times(1)).findBoardById(eq(board.id))
    }

    @Test
    fun `getBoardById throws exception when board was not found`() {
        whenever(boardRepository.findBoardById(any<UUID>())).thenReturn(null)

        val exception = assertThrows<NotFoundException> {
            boardService.getBoardById(UUID.randomUUID())
        }

        assertEquals(BOARD_NOT_FOUND_EXCEPTION_MESSAGE, exception.reason)
        verify(boardRepository, times(1)).findBoardById(any<UUID>())
    }

    @Test
    fun `getAllBoards returns paged board response`() {
        val pageable = PageRequest.of(0, 10)
        val boards = listOf(boardDummyData.board)
        val page: Page<Board> = PageImpl(listOf(), pageable, boards.size.toLong())

        whenever(boardRepository.findAll(eq(pageable))).thenReturn(page)

        val pagedBoardResponse = boardService.getAllBoards(pageable)

        assertEquals(page, pagedBoardResponse)
        verify(boardRepository, times(1)).findAll(eq(pageable))
    }

    @Test
    fun `postBoard returns board response`() {
        val boardCreateModel = boardDummyData.boardCreateModel

        whenever(boardRepository.save(any<Board>())).thenReturn(boardCreateModel.toBoard())

        val boardResponse = boardService.postBoard(boardCreateModel)

        assertEquals(CREATE_BOARD_TITLE, boardResponse.title)
        assertEquals(CREATE_BOARD_DESCRIPTION, boardResponse.description)
        verify(boardRepository, times(1)).save(any<Board>())
    }

    @Test
    fun `putBoardById returns board response`() {
        val board = boardDummyData.board
        val boardUpdateModel = boardDummyData.boardUpdateModel

        whenever(boardRepository.findBoardById(board.id)).thenReturn(board)
        whenever(boardRepository.save(any<Board>())).thenReturn(board)

        val boardResponse = boardService.putBoardById(board.id, boardUpdateModel)

        assertEquals(UPDATE_BOARD_TITLE, boardResponse.title)
        assertEquals(UPDATE_BOARD_DESCRIPTION, boardResponse.description)
        verify(boardRepository, times(1)).findBoardById(board.id)
        verify(boardRepository, times(1)).save(board)
    }

    @Test
    fun `putBoardById throws exception when board was not found`() {
        val board = boardDummyData.board
        val boardUpdateModel = boardDummyData.boardUpdateModel

        whenever(boardRepository.findBoardById(any<UUID>())).thenReturn(null)

        val exception = assertThrows<NotFoundException> {
            boardService.putBoardById(board.id, boardUpdateModel)
        }

        assertEquals(BOARD_NOT_FOUND_EXCEPTION_MESSAGE, exception.reason)
        verify(boardRepository, times(1)).findBoardById(any<UUID>())
        verify(boardRepository, never()).save(any<Board>())
    }

    @Test
    fun `deleteBoardByID successfully`() {
        whenever(boardRepository.existsById(any<UUID>())).thenReturn(true)

        boardService.deleteBoardById(UUID.randomUUID())

        verify(boardRepository, times(1)).existsById(any<UUID>())
        verify(boardRepository, times(1)).deleteById(any<UUID>())
    }

    @Test
    fun `deleteBoardByID throws exception when board was not found`() {
        whenever(boardRepository.existsById(any<UUID>())).thenReturn(false)

        val exception = assertThrows<NotFoundException> {
            boardService.deleteBoardById(UUID.randomUUID())
        }

        assertEquals(BOARD_NOT_FOUND_EXCEPTION_MESSAGE, exception.reason)
        verify(boardRepository, times(1)).existsById(any<UUID>())
        verify(boardRepository, never()).deleteById(any<UUID>())
    }
}
