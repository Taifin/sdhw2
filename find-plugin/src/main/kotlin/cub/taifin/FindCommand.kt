package cub.taifin

import java.lang.IllegalArgumentException
import java.nio.file.InvalidPathException
import java.nio.file.Paths
import kotlin.io.path.absolutePathString
import kotlin.io.path.isReadable
import kotlin.io.path.isRegularFile
import kotlin.io.path.readLines

class FindCommand : ICommand {
    override val descriptor =
        CommandDescriptor(
            "find",
            "print lines that contain the word in a file",
            listOf(
                PositionalArgumentDescriptor(0, "word"),
                PositionalArgumentDescriptor(1, "file")
            )
        )

    override fun execute(context: CommandContext): CommandResult {
        try {
            require(context.args.size == 2) { "Incorrect amount of arguments" }

            val word = context.args[0]
            val file = context.args[1]
            val path = Paths.get(file.value)

            if (!path.isRegularFile() || !path.isReadable()) {
                return ResultFailure("File ${path.absolutePathString()} is not a file or is not readable")
            }

            val lines = path.readLines()
            for (i in lines.indices) {
                if (word.value in lines[i]) {
                    println("$i:${lines[i]}")
                }
            }

            return ResultSuccess
        } catch (e: IllegalArgumentException) {
            return ResultFailure("Invalid arguments")
        } catch (e: InvalidPathException) {
            return ResultFailure("Path ${context.args[0]} is not a valid path")
        }
    }
}