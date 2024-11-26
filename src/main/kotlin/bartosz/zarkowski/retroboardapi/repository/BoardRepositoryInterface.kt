package bartosz.zarkowski.retroboardapi.repository

import bartosz.zarkowski.retroboardapi.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BoardRepositoryInterface : JpaRepository<Board, UUID>
