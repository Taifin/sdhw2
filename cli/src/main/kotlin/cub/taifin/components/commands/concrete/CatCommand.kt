package cub.taifin.components.commands.concrete

import cub.taifin.components.commands.SingleFileCommand
import kotlin.io.path.readText

object CatCommand : SingleFileCommand(
    "cat",
    "print file content",
    {
        val text = it.readText()
        println(text)
    }
)