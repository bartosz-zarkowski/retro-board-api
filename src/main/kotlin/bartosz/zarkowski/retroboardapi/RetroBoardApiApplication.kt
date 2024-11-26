package bartosz.zarkowski.retroboardapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RetroBoardApiApplication

fun main(args: Array<String>) {
    runApplication<RetroBoardApiApplication>(*args)
}
