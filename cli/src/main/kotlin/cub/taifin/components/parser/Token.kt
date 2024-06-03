package cub.taifin.components.parser

data class CMD(val value: String)

/**
 * Positional argument of a command
 */
data class PArg(override val value: String) : IArg

/**
 * Named argument of a command
 *
 * Not used yet
 */
//data class NArg(override val value: String, val key: String) : IArg