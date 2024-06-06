import java.io.File

fun String.serviceMessage() = println("##teamcity[$this]")

println("##teamcity[compilationStarted compiler='kotlinc']")
println("##teamcity[message text='foobar' status='WARNING']")
println("##teamcity[message text='bibaboba' status='ERROR']")
println("##teamcity[compilationFinished compiler='kotlinc']")

println("##teamcity[message flowId='flow1' text='foo']")
println("##teamcity[message flowId='flow2' text='foo']")

println("##teamcity[message flowId='flow1' text='bar']")
println("##teamcity[message flowId='flow2' text='bar']")

"testSuiteStarted name='suite'".serviceMessage()

"testStarted name='test1'".serviceMessage()
println("hahahahahaha")
"testStdOut name='test1' out='text'".serviceMessage()
"testStdErr name='test1' out='error text'".serviceMessage()
"testFinished name='test1' duration='10000'".serviceMessage()

"testStarted name='test2' captureStandardOutput='true'".serviceMessage()
println("hihihihihihi")
"testIgnored name='test2' message='I don|'t like it'".serviceMessage()
"testFinished name='test2'".serviceMessage()

"testStarted name='test3'".serviceMessage()
"testMetadata name='just some metadata' testName='test3' type='ms' value='434.5'".serviceMessage()
"testFinished name='test3'".serviceMessage()

"testStarted name='retry'".serviceMessage()
"testRetrySupport enabled='true'".serviceMessage()
"testFailed name='retry' type='comparisonFailure' details='idk it just failed' expected='foobar' actual='barfoo'".serviceMessage()

"testStarted name='retry'".serviceMessage()

"testFinished name='retry'".serviceMessage()

"testSuiteFinished name='suite'".serviceMessage()

"testSuiteStarted name='suite2'".serviceMessage()
"testStarted name='testS2'".serviceMessage()
"testFinished name='testS2'".serviceMessage()
"testSuiteFinished name='suite2'".serviceMessage()

var jarFile = File("find-plugin/build/libs/find.jar")
if (jarFile.exists()) {
    println("##teamcity[message text='Jar file with plugin was created successfully']")
} else {
    println("##teamcity[buildProblem description='Plugin could not be found']")
}
