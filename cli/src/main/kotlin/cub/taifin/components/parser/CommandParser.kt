package cub.taifin.components.parser

object CommandParser {
    // Just trivial placeholders for checking if token is a valid arg/cmd.
    // No meaningful logic, because no specification is given on formats of names/arguments
    private fun isValidCmd(cmd: String) = cmd.all { it.isLetter() }
    private fun isValidArg(arg: String) = true

    fun parse(string: String): CommandParserResult {
        val strTokens = string.split(" ") // TODO: files with spacebars, but who cares

        if (!isValidCmd(strTokens[0]))
            throw CommandParserException("Name ${strTokens[0]} does not look like a valid command name")

        val name = CMD(strTokens[0])
        val args = strTokens.drop(1)
        args.forEach {
            if (!isValidArg(it))
                throw CommandParserException("Argument $it does not look like a valid argument")
        }

        return CommandParserResult(name, args.map { PArg(it) })
    }
}