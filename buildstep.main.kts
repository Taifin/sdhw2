import java.io.File

var jarFile = File("find-plugin/build/libs/find.jar")
if (jarFile.exists()) {
    println("##teamcity[buildProblem description='Jar file with plugin was created successfully']")
} else {
    println("##teamcity[buildProblem description='Plugin could not be found']")
}
