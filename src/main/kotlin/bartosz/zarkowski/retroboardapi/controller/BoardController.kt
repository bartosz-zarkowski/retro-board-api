package bartosz.zarkowski.retroboardapi.controller

import bartosz.zarkowski.retroboardapi.service.BoardService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Board Controller v1")
@RequestMapping("/v1/boards")
@RestController
class BoardController(
    val boardService: BoardService
) {
}
