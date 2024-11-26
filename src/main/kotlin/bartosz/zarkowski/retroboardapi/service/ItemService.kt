package bartosz.zarkowski.retroboardapi.service

import bartosz.zarkowski.retroboardapi.repository.ItemRepositoryInterface
import org.springframework.stereotype.Service

@Service
class ItemService(
    val itemRepository: ItemRepositoryInterface
) {
}
