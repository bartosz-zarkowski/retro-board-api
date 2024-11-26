package bartosz.zarkowski.retroboardapi.service

import bartosz.zarkowski.retroboardapi.repository.BoardRepositoryInterface
import org.mockito.Mockito.mock

class BoardServiceTest {

    private val boardRepository: BoardRepositoryInterface = mock()

    private val boardService = BoardService(boardRepository)

}
