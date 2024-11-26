package bartosz.zarkowski.retroboardapi.entity

import bartosz.zarkowski.retroboardapi.enum.ItemType
import jakarta.persistence.*
import jakarta.persistence.FetchType.EAGER
import org.hibernate.annotations.JdbcTypeCode
import java.sql.Types
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "item")
class Item(
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val type: ItemType,
    val content: String,
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "board_id", nullable = false)
    val board: Board
) {
    @Id
    @Column(unique = true, nullable = false)
    @JdbcTypeCode(Types.VARCHAR)
    val id: UUID = UUID.randomUUID()
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant = Instant.now()
    @Column(name = "updated_at", nullable = true)
    val updatedAt: Instant? = null
}
