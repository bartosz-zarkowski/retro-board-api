package bartosz.zarkowski.retroboardapi.entity

import java.time.Instant
import java.util.*

interface EntityInterface {
    val id : UUID
    val createdAt : Instant
    val updatedAt : Instant?
}
