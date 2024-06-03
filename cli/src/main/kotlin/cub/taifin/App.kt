package cub.taifin

import cub.taifin.components.commands.*
import cub.taifin.components.commands.concrete.CatCommand
import cub.taifin.components.commands.concrete.ExitCommand
import cub.taifin.components.commands.concrete.HelpCommand
import cub.taifin.components.commands.concrete.LcCommand
import cub.taifin.components.parser.*

import java.lang.Exception
import java.lang.IllegalArgumentException

class App(pathToPlugin: String?) {
    private val parser = CommandParser
    private val commandLoader: CommandLoader = JarCommandLoader()
    private val registry = CommandRegistry

    init {
        pathToPlugin?.let { loadPlugin(it) }
        registry.register(CatCommand)
        registry.register(LcCommand)
        registry.register(ExitCommand)
        registry.register(HelpCommand(registry.commands))
    }

    private fun loadPlugin(pathToPlugin: String) {
        val pluginCommands = commandLoader.loadCommand(pathToPlugin)
        pluginCommands.forEach {
            registry.register(it)
        }
    }

    private fun formContext(commandDescriptor: CommandDescriptor, args: List<IArg>): CommandContext {
        val positionalArgsDescriptors =
            commandDescriptor.args.filterIsInstance<PositionalArgumentDescriptor>()
                .sortedBy { it.position }

        return CommandContext(args.mapIndexed { index, it ->
            require(it is PArg)
            require(index < positionalArgsDescriptors.size) { "Too many positional arguments given" }
            Argument(positionalArgsDescriptors[index], it.value)
        })
    }

    /**
     * @return false if execution loop is to be broken (exit command/EOF in input), true otherwise
     */
    private fun main(): Boolean {
        try {
            print("> ")
            val line = readlnOrNull() ?: return false
            val (name, args) = parser.parse(line)

            val cmd = registry.getCommand(name.value) ?: run {
                println("\"${name.value}\" is invalid name of a command")
                return true
            }

            val context = formContext(cmd.descriptor, args)

            if (cmd is ExitCommand) {
                return false
            }

            val result = cmd.execute(context)

            if (result is ResultFailure) {
                println("Command \"${name.value}\" failed to execute.\n\tReason: ${result.reason}")
            }
        } catch (e: CommandParserException) {
            println("Paring failed:")
            println("\t${e.message}")
        } catch (e: IllegalArgumentException) {
            println("Illegal arguments were given:")
            println("\t${e.message}")
        } catch (e: Exception) {
            println("Unexpected error:")
            println("\t${e.message}")
        }

        return true
    }

    fun run() {
        while (main()) {
        }
    }
}