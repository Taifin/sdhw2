package cub.taifin.components.commands

import cub.taifin.*

import java.lang.IllegalArgumentException
import java.nio.file.InvalidPathException
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.isReadable
import kotlin.io.path.isRegularFile

open class SingleFileCommand(
    name: String, help: String, val action: (Path) -> Unit,
) :
    ICommand {
    override val descriptor = CommandDescriptor(name, help, listOf(PositionalArgumentDescriptor(0, "file")))
    override fun execute(context: CommandContext): CommandResult {
        try {
            require(context.args.size == 1) { "Invalid number of arguments" }

            val file = context.args[0]
            val path = Paths.get(file.value)

            if (!path.isRegularFile() || !path.isReadable()) {
                return ResultFailure("File $file is not a file or is not readable")
            }

            action(path)

            return ResultSuccess
        } catch (e: IllegalArgumentException) {
            return ResultFailure("Invalid arguments")
        } catch (e: InvalidPathException) {
            return ResultFailure("Path ${context.args[0].value} is not a valid path")
        }
    }
}