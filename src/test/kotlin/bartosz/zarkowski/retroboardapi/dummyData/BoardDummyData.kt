package bartosz.zarkowski.retroboardapi.dummyData

import bartosz.zarkowski.retroboardapi.entity.Board

class BoardDummyData {

    companion object {
        const val BOARD_TITLE = "Sprint Retrospective - Sprint #25"
        const val BOARD_DESCRIPTION = "To reflect on the progress, challenges, and successes of Sprint #25 and identify actionable improvements for future sprints."
    }

    val board = Board(
        BOARD_TITLE,
        BOARD_DESCRIPTION
    )
}
