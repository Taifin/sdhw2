package cub.taifin

sealed interface CommandResult

class ResultFailure(val reason: String) : CommandResult

data object ResultSuccess : CommandResult
data object ResultEnd : CommandResult