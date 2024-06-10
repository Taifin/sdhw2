
fun String.serviceMessage() = println("##teamcity[$this]")

"flowStarted flowId='MainFlow'".serviceMessage()
"message flowId='MainFlow' text='message from MainFlow'".serviceMessage()
"flowStarted flowId='SubFlow1' parent='MainFlow'".serviceMessage()
"message flowId='SubFlow' text='message from SubFlow1'".serviceMessage()
"flowFinished flowId='SubFlow1'".serviceMessage()
"flowStarted flowId='SubFlow2'".serviceMessage()
"message flowId='MainFlow' text='message from SubFlow2'".serviceMessage()
"flowFinished flowId='SubFlow2'".serviceMessage()
"flowFinished flowId='MainFlow'".serviceMessage()