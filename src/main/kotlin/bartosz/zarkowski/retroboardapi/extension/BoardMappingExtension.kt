package bartosz.zarkowski.retroboardapi.extension

import bartosz.zarkowski.retroboardapi.dto.board.BoardResponseModel
import bartosz.zarkowski.retroboardapi.entity.Board

fun Board.toResponseModel(): BoardResponseModel =
    BoardResponseModel(title, description, createdAt, updatedAt, items)
