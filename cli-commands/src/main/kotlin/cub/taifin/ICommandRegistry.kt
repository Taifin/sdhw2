package cub.taifin

interface ICommandRegistry {
    val commands: List<ICommand>
    fun register(command: ICommand)
    fun getCommand(name: String): ICommand?
}