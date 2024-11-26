package bartosz.zarkowski.retroboardapi.service

import bartosz.zarkowski.retroboardapi.dto.board.BoardResponseModel
import bartosz.zarkowski.retroboardapi.exception.NotFoundException
import bartosz.zarkowski.retroboardapi.extension.toResponseModel
import bartosz.zarkowski.retroboardapi.repository.BoardRepositoryInterface
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BoardService(
    val boardRepository: BoardRepositoryInterface
) {

    companion object {
        const val BOARD_NOT_FOUND_EXCEPTION_MESSAGE = "Board not found"
    }

    fun getBoardById(id: UUID): BoardResponseModel {
        val board = boardRepository.findBoardById(id)
            ?: throw NotFoundException(BOARD_NOT_FOUND_EXCEPTION_MESSAGE)

        return board.toResponseModel()
    }
}
