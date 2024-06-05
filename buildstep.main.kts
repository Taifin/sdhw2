import java.io.File

println("##teamcity[blockOpened name='block1']")
println("##teamcity[message text='foobar']")
println("##teamcity[message text='bibaboba']")
println("##teamcity[blockClosed name='block1']")

var jarFile = File("find-plugin/build/libs/find.jar")
if (jarFile.exists()) {
    println("##teamcity[buildProblem description='Jar file with plugin was created successfully']")
} else {
    println("##teamcity[buildProblem description='Plugin could not be found']")
}
