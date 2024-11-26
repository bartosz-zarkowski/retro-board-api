package bartosz.zarkowski.retroboardapi.dummyData

import bartosz.zarkowski.retroboardapi.dto.board.BoardCreateModel
import bartosz.zarkowski.retroboardapi.dto.board.BoardUpdateModel
import bartosz.zarkowski.retroboardapi.entity.Board

class BoardDummyData {

    companion object {
        const val BOARD_TITLE = "Sprint Retrospective - Sprint #25"
        const val BOARD_DESCRIPTION = "To reflect on the progress, challenges, and successes of Sprint #25 and identify actionable improvements for future sprints."
        const val CREATE_BOARD_TITLE = "Board update title"
        const val CREATE_BOARD_DESCRIPTION = "Update board description"
        const val UPDATE_BOARD_TITLE = "Board update title"
        const val UPDATE_BOARD_DESCRIPTION = "Update board description"

    }

    val board = Board(
        BOARD_TITLE,
        BOARD_DESCRIPTION
    )

    val boardCreateModel = BoardCreateModel(
        CREATE_BOARD_TITLE,
        CREATE_BOARD_DESCRIPTION
    )

    val boardUpdateModel = BoardUpdateModel(
        UPDATE_BOARD_TITLE,
        UPDATE_BOARD_DESCRIPTION
    )
}
