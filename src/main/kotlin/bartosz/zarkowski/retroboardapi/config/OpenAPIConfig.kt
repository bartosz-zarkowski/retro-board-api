package bartosz.zarkowski.retroboardapi.config

import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.v3.core.jackson.ModelResolver
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAPIConfig {

    @Value("\${api-version}")
    private lateinit var apiVersion: String

    @Bean
    fun openAPI(): OpenAPI {
        val info = Info()
            .title("Retro Board API")
            .version(apiVersion)
            .description("API for managing retro boards, feedback, and action items.")

        return OpenAPI().info(info)
    }

    @Bean
    fun modelResolver(objectMapper: ObjectMapper): ModelResolver =
        ModelResolver(objectMapper)
}
