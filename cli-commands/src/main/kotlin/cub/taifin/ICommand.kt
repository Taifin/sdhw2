package cub.taifin

interface ICommand {
    val descriptor: CommandDescriptor
    fun execute(context: CommandContext): CommandResult
}
