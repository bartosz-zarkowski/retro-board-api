package bartosz.zarkowski.retroboardapi.dto.board

import bartosz.zarkowski.retroboardapi.entity.Item
import java.time.Instant
import java.util.*

data class BoardResponseModel(
    val id: UUID,
    override val title: String,
    override val description: String,
    val createdAt: Instant,
    val updatedAt: Instant?,
    val items: MutableList<Item>
) : BoardModelInterface
