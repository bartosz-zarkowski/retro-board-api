package bartosz.zarkowski.retroboardapi.service

import bartosz.zarkowski.retroboardapi.repository.ItemRepositoryInterface
import org.mockito.kotlin.mock

class ItemServiceTest {

    private val itemRepository: ItemRepositoryInterface = mock()

    private val itemService = ItemService(itemRepository)

}
