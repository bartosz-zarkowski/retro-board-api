package bartosz.zarkowski.retroboardapi.controller

import bartosz.zarkowski.retroboardapi.service.ItemService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Item Controller v1")
@RequestMapping("/v1/items")
@RestController
class ItemController(
    val itemService: ItemService
) {
}
