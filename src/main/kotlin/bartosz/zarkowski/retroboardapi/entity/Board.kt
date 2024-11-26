package bartosz.zarkowski.retroboardapi.entity

import jakarta.persistence.*
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: String = UUID.randomUUID().toString()
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant = Instant.now()
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant? = null

    @OneToMany(mappedBy = "board", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    val items: List<Item> = listOf()
}
