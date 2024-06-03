package cub.taifin.components.commands

import cub.taifin.ICommand
import cub.taifin.ICommandRegistry

object CommandRegistry : ICommandRegistry {
    private val _commands: MutableMap<String, ICommand> = mutableMapOf()
    override val commands: List<ICommand> get() = _commands.values.toList()
    override fun register(command: ICommand) {
        _commands[command.descriptor.name] = command
    }

    override fun getCommand(name: String) = _commands[name]
}