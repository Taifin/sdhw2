import java.io.File

println("##teamcity[compilationStarted compiler='kotlinc']")
println("##teamcity[message text='foobar' status='WARNING']")
println("##teamcity[message text='bibaboba' status='ERROR']")
println("##teamcity[compilationFinished compiler='kotlinc']")

println("##teamcity[message flowId='flow1' text='foo']")
println("##teamcity[message flowId='flow2' text='foo']")

println("##teamcity[message flowId='flow1' text='bar']")
println("##teamcity[message flowId='flow2' text='bar']")

var jarFile = File("find-plugin/build/libs/find.jar")
if (jarFile.exists()) {
    println("##teamcity[message text='Jar file with plugin was created successfully']")
} else {
    println("##teamcity[buildProblem description='Plugin could not be found']")
}
