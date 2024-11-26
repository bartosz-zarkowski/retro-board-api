package bartosz.zarkowski.retroboardapi.repository

import bartosz.zarkowski.retroboardapi.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ItemRepositoryInterface : JpaRepository<Item, UUID>
