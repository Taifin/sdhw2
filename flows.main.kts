
fun String.serviceMessage() = println("##teamcity[$this]")

"flowStarted flowId='MainFlow'".serviceMessage()
"message flowId='MainFlow' text='message from MainFlow'".serviceMessage()
"flowStarted flowId='SubFlow' parent='MainFlow'".serviceMessage()
"message flowId='SubFlow' text='message from SubFlow'".serviceMessage()
"message flowId='MainFlow' text='again from MainFlow'".serviceMessage()
"flowFinished flowId='SubFlow'".serviceMessage()
"flowFinished flowId='MainFlow'".serviceMessage()