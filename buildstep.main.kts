import java.io.File

println("##teamcity[compilationStarted compiler='kotlinc']")
println("##teamcity[message text='foobar' status='WARNING']")
println("##teamcity[message text='bibaboba' status='ERROR']")
println("##teamcity[compilationFinished compiler='kotlinc']")

println("##teamcity[message flowId='flow1' text='fooflow1']")
println("##teamcity[message flowId='flow2' text='fooflow2']")

println("##teamcity[message flowId='flow1' text='flow1bar']")
println("##teamcity[message flowId='flow2' text='flow2bar']")

var jarFile = File("find-plugin/build/libs/find.jar")
if (jarFile.exists()) {
    println("##teamcity[message text='Jar file with plugin was created successfully']")
} else {
    println("##teamcity[buildProblem description='Plugin could not be found']")
}
