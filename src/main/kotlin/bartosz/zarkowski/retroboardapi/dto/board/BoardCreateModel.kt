package bartosz.zarkowski.retroboardapi.dto.board

class BoardCreateModel(
    override val title: String,
    override val description: String,
) : BoardModelInterface
