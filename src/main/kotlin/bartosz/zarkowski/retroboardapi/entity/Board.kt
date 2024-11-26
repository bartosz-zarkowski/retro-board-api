package bartosz.zarkowski.retroboardapi.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import java.sql.Types
import java.time.Instant
import java.util.*

@Entity
@Table(name = "board")
class Board(
    @Column(nullable = false)
    val title: String,
    @Column(nullable = false)
    val description: String,
) {
    @Id
    @Column(unique = true, nullable = false)
    @JdbcTypeCode(Types.VARCHAR)
    val id: UUID = UUID.randomUUID()
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant = Instant.now()
    @Column(name = "updated_at")
    val updatedAt: Instant? = null

    @OneToMany(mappedBy = "board", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    val items: MutableList<Item> = mutableListOf()
}
