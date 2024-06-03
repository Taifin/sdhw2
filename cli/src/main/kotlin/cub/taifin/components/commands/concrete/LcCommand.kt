package cub.taifin.components.commands.concrete

import cub.taifin.components.commands.SingleFileCommand
import kotlin.io.path.readLines

object LcCommand : SingleFileCommand(
    "lc",
    "count lines in the given file",
    {
        val lc = it.readLines().size
        println(lc)
    }
)