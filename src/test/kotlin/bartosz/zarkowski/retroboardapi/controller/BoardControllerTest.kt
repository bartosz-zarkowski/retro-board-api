package bartosz.zarkowski.retroboardapi.controller

import bartosz.zarkowski.retroboardapi.dummyData.BoardDummyData
import bartosz.zarkowski.retroboardapi.repository.BoardRepositoryInterface
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import kotlin.test.Test

@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest : BaseControllerTest() {

    @Autowired
    private lateinit var boardRepository: BoardRepositoryInterface

    val boardDummyData = BoardDummyData()

    @Test
    @Transactional
    fun `getBoardByID returns board`() {
        val board = boardDummyData.board
        boardRepository.save(board)

        performMockRequest(
            get("/v1/boards/${board.id}"),
            MockMvcResultMatchers.status().isOk
        )
    }
}
