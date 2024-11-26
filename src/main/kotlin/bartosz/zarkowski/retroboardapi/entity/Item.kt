package bartosz.zarkowski.retroboardapi.entity

import bartosz.zarkowski.retroboardapi.enum.ItemType
import jakarta.persistence.*
import jakarta.persistence.FetchType.EAGER
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "item")
class Item(
    @Column(nullable = false)
    val type: ItemType,
    val content: String,
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "board_id", nullable = false)
    val board: Board
) {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: String = UUID.randomUUID().toString()
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant = Instant.now()
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant? = null
}
