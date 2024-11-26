package bartosz.zarkowski.retroboardapi.service

import bartosz.zarkowski.retroboardapi.repository.BoardRepositoryInterface
import org.springframework.stereotype.Service

@Service
class BoardService(
    val boardRepository: BoardRepositoryInterface
)
