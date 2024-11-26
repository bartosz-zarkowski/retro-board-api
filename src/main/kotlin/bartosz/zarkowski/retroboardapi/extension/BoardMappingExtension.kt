package bartosz.zarkowski.retroboardapi.extension

import bartosz.zarkowski.retroboardapi.dto.board.BoardCreateModel
import bartosz.zarkowski.retroboardapi.dto.board.BoardResponseModel
import bartosz.zarkowski.retroboardapi.entity.Board

fun Board.toResponseModel(): BoardResponseModel =
    BoardResponseModel(id, title, description, createdAt, updatedAt, items)

fun BoardCreateModel.toBoard(): Board =
    Board(title, description)
