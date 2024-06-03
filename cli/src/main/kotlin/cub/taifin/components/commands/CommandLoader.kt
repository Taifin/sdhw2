package cub.taifin.components.commands

import cub.taifin.ICommand

interface CommandLoader {
    fun loadCommand(uri: String): List<ICommand>
}