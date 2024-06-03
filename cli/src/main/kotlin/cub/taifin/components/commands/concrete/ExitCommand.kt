package cub.taifin.components.commands.concrete

import cub.taifin.*

object ExitCommand : ICommand {
    override val descriptor = CommandDescriptor("exit", "exit the application", listOf())

    override fun execute(context: CommandContext): CommandResult {
        return ResultEnd
    }
}