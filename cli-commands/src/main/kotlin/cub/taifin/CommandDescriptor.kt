package cub.taifin

data class CommandDescriptor(
    val name: String,
    val help: String,
    val args: List<ArgumentDescriptor>
)