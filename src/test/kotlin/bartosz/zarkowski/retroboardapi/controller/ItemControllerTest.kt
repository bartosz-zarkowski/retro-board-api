package bartosz.zarkowski.retroboardapi.controller

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class ItemControllerTest : BaseControllerTest() {
}
