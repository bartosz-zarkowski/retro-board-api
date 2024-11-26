package bartosz.zarkowski.retroboardapi.controller

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.test.Test

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class HealthCheckControllerTest : BaseControllerTest() {

    @Test
    fun `checkHealth returns 204`() {
        performMockRequest(
            get("/v1/healthcheck"),
            status().isNoContent
        )
    }
}
