package bartosz.zarkowski.retroboardapi.service

import bartosz.zarkowski.retroboardapi.dto.board.BoardCreateModel
import bartosz.zarkowski.retroboardapi.dto.board.BoardResponseModel
import bartosz.zarkowski.retroboardapi.dto.board.BoardUpdateModel
import bartosz.zarkowski.retroboardapi.exception.NotFoundException
import bartosz.zarkowski.retroboardapi.extension.toBoard
import bartosz.zarkowski.retroboardapi.extension.toResponseModel
import bartosz.zarkowski.retroboardapi.repository.BoardRepositoryInterface
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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

    fun getAllBoards(pageable: Pageable): Page<BoardResponseModel> =
         boardRepository.findAll(pageable).map { it.toResponseModel() }

    fun postBoard(boardCreateModel: BoardCreateModel): BoardResponseModel =
        boardRepository.save(boardCreateModel.toBoard()).toResponseModel()

    fun putBoardById(id: UUID, boardUpdateModel: BoardUpdateModel): BoardResponseModel {
        val board = boardRepository.findBoardById(id)
            ?: throw NotFoundException(BOARD_NOT_FOUND_EXCEPTION_MESSAGE)

        board.title = boardUpdateModel.title
        board.description = boardUpdateModel.description

        val savedBoard = boardRepository.save(board)

        return savedBoard.toResponseModel()
    }

    fun deleteBoardById(id: UUID) {
        val boardExists = boardRepository.existsById(id)
        if (!boardExists)
            throw NotFoundException(BOARD_NOT_FOUND_EXCEPTION_MESSAGE)

        boardRepository.deleteById(id)
    }
}
