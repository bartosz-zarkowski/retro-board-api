package bartosz.zarkowski.retroboardapi.controller

import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Health Check v1")
@RestController
class HealthCheckController {

    @GetMapping("/v1/healthcheck")
    @ApiResponse(
        responseCode = "200",
        description = "Succeeded to check health",
        content = [Content()]
    )
    @ApiResponse(
        responseCode = "500",
        description = "Failed to check health",
        content = [Content()]
    )
    fun checkHealth(): ResponseEntity<Any> =
        ResponseEntity(HttpStatus.NO_CONTENT)
}
