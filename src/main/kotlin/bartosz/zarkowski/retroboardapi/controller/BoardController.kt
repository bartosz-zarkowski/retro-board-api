package bartosz.zarkowski.retroboardapi.controller

import bartosz.zarkowski.retroboardapi.dto.board.BoardResponseModel
import bartosz.zarkowski.retroboardapi.service.BoardService
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@Tag(name = "Board Controller v1")
@RequestMapping("/v1/boards")
@RestController
class BoardController(
    val boardService: BoardService
) {

    @GetMapping("/{id}")
    @ApiResponse(
        responseCode = "200",
        description = "Success",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = BoardResponseModel::class))]
    )
    fun getBoardByID(@PathVariable id: UUID): ResponseEntity<BoardResponseModel> =
        ResponseEntity(boardService.getBoardById(id), HttpStatus.OK)

    @GetMapping
    @ApiResponse(
        responseCode = "200",
        description = "Success",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = BoardResponseModel::class))]
    )
    fun getAllBoards(pageable: Pageable): ResponseEntity<Page<BoardResponseModel>> =
        ResponseEntity(boardService.getAllBoards(pageable), HttpStatus.OK)
}
