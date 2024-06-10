
fun String.serviceMessage() = println("##teamcity[$this]")

"flowStarted flowId='MainFlow'".serviceMessage()
"blockOpened flowId='MainFlow' name='block1'".serviceMessage()

"message flowId='MainFlow' text='message from MainFlow'".serviceMessage()

"flowStarted flowId='SubFlow1' parent='MainFlow'".serviceMessage()
"blockOpened flowId='SubFlow1' name='subblock1'".serviceMessage()
"message flowId='SubFlow1' text='message from SubFlow1'".serviceMessage()
"blockClosed name='subblock1'".serviceMessage()
"flowFinished flowId='SubFlow1'".serviceMessage()

"message flowId='MainFlow' text='another message from MainFlow'".serviceMessage()

"flowStarted flowId='SubFlow2' parent='SubFlow1'".serviceMessage()
"message flowId='MainFlow' text='message from SubFlow2'".serviceMessage()
"flowFinished flowId='SubFlow2'".serviceMessage()

"blockClosed name='block1'".serviceMessage()
"flowFinished flowId='MainFlow'".serviceMessage()