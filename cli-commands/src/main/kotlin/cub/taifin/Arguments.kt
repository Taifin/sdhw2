package cub.taifin

sealed interface ArgumentDescriptor {
    val name: String
}

data class PositionalArgumentDescriptor(val position: Int, override val name: String) : ArgumentDescriptor
data class NamedArgumentDescriptor(val key: String, override val name: String) : ArgumentDescriptor

class Argument(val descriptor: ArgumentDescriptor, val value: String)