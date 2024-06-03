package cub.taifin.components.commands.concrete

import cub.taifin.*

class HelpCommand(private val commands: List<ICommand>) : ICommand {
    override val descriptor = CommandDescriptor("help", "print available commands and their help", listOf())

    override fun execute(context: CommandContext): CommandResult {
        commands.forEach { command ->
            print(
                "${command.descriptor.name}: ${command.descriptor.help}\n\tUsage: ${command.descriptor.name} "
            )
            command.descriptor.args.sortedBy { when (it) {
                is PositionalArgumentDescriptor -> it.position
                is NamedArgumentDescriptor -> Int.MAX_VALUE // trick to put named arguments at the end of the list
            } }.forEach {
                print(
                    "<${it.name}> "
                )
            }
            println()
        }
        println("${descriptor.name}: ${descriptor.help}\n\tUsage: ${descriptor.name}")

        return ResultSuccess
    }
}