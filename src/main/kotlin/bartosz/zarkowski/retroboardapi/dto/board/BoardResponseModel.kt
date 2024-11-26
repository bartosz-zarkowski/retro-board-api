package bartosz.zarkowski.retroboardapi.dto.board

import bartosz.zarkowski.retroboardapi.entity.Item
import java.time.Instant

data class BoardResponseModel(
    val title: String,
    val description: String,
    val createdAt: Instant,
    val updatedAt: Instant?,
    val items: MutableList<Item>
)
