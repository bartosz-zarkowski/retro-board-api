package bartosz.zarkowski.retroboardapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
    info = Info(
        title = "Retro Board API",
        description = "API to ",
        version = "1.0.0"
    )
)
class RetroBoardApiApplication

fun main(args: Array<String>) {
    runApplication<RetroBoardApiApplication>(*args)
}
