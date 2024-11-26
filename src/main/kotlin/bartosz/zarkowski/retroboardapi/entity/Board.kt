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
    var title: String,
    @Column(nullable = false)
    var description: String,
) : EntityInterface {
    @Id
    @Column(unique = true, nullable = false)
    @JdbcTypeCode(Types.VARCHAR)
    override val id: UUID = UUID.randomUUID()
    @Column(name = "created_at", nullable = false)
    override val createdAt: Instant = Instant.now()
    @Column(name = "updated_at")
    override val updatedAt: Instant? = null

    @OneToMany(mappedBy = "board", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    val items: MutableList<Item> = mutableListOf()
}
