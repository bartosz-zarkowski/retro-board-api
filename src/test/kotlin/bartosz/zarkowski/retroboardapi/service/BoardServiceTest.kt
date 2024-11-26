package bartosz.zarkowski.retroboardapi.service

import bartosz.zarkowski.retroboardapi.dummyData.BoardDummyData
import bartosz.zarkowski.retroboardapi.exception.NotFoundException
import bartosz.zarkowski.retroboardapi.repository.BoardRepositoryInterface
import bartosz.zarkowski.retroboardapi.service.BoardService.Companion.BOARD_NOT_FOUND_EXCEPTION_MESSAGE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.whenever
import java.util.UUID
import kotlin.test.Test

class BoardServiceTest {

    private val boardRepository: BoardRepositoryInterface = mock()

    private val boardService = BoardService(boardRepository)

    private val boardDummyData = BoardDummyData()

    @Test
    fun `getBoardById returns board`() {
        val board = boardDummyData.board

        whenever(boardRepository.findBoardById(eq(board.id))).thenReturn(board)

        boardService.getBoardById(board.id)

        assertEquals(boardDummyData.board, board)
    }

    @Test
    fun `getBoardById throws exception when board was not found`() {
        whenever(boardRepository.findBoardById(any<UUID>())).thenReturn(null)

        val exception = assertThrows<NotFoundException> {
            boardService.getBoardById(UUID.randomUUID())
        }

        assertEquals(BOARD_NOT_FOUND_EXCEPTION_MESSAGE, exception.reason)
    }
}
