package bartosz.zarkowski.retroboardapi.dto.board

class BoardUpdateModel(
    override val title: String,
    override val description: String,
) : BoardModelInterface
