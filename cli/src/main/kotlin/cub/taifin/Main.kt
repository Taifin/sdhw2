package cub.taifin

fun main(args: Array<String>) {
    val pathToPlugin = if (args.size == 1) args[0] else null
    App(pathToPlugin).run()
}