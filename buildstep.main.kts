import java.io.File
import java.lang.Thread.sleep

fun String.serviceMessage() = println("##teamcity[$this]")

"inspectionType id='123' name='inspectionType' category='Style violations' description='foobar'".serviceMessage()


"progressMessage 'start of the build step'".serviceMessage()

println("##teamcity[compilationStarted compiler='kotlinc']")
println("##teamcity[message text='foobar' status='WARNING']")
println("##teamcity[message text='bibaboba' status='ERROR']")
println("##teamcity[compilationFinished compiler='kotlinc']")

println("##teamcity[message flowId='flow1' text='foo']")
println("##teamcity[message flowId='flow2' text='foo']")

println("##teamcity[message flowId='flow1' text='bar']")
println("##teamcity[message flowId='flow2' text='bar']")

"testSuiteStarted name='suite'".serviceMessage()

sleep(10000)

"progressStart 'test suite |'suite|''".serviceMessage()

"testStarted name='test1'".serviceMessage()
println("hahahahahaha")
"inspection typeId='123' message='this is an inspection from test1' file='cli/src/main/kotlin/cub/taifin/App.kt' line='14' SEVERITY='WARNING'".serviceMessage()
"testStdOut name='test1' out='text'".serviceMessage()
"testStdErr name='test1' out='error text'".serviceMessage()
"testFinished name='test1' duration='10000'".serviceMessage()

"testStarted name='test2' captureStandardOutput='true'".serviceMessage()
println("hihihihihihi")
"testIgnored name='test2' message='I don|'t like it'".serviceMessage()
"testFinished name='test2'".serviceMessage()
sleep(5000)

"testStarted name='test3'".serviceMessage()
"testMetadata name='just some metadata' testName='test3' type='ms' value='434.5'".serviceMessage()
"inspection typeId='123' message='this is an inspection from test3' file='cli/src/build.gradle.kts' line='10' SEVERITY='ERROR'".serviceMessage()
"testFinished name='test3'".serviceMessage()

"testStarted name='retry'".serviceMessage()
"testRetrySupport enabled='true'".serviceMessage()
"testFailed name='retry' type='comparisonFailure' details='idk it just failed' expected='foobar' actual='barfoo'".serviceMessage()
"testFinished name='retry'".serviceMessage()

"testStarted name='retry'".serviceMessage()

"testFinished name='retry'".serviceMessage()

"testSuiteFinished name='suite'".serviceMessage()
"progressStart 'test suite |'suite|''".serviceMessage()

"testSuiteStarted name='suite2'".serviceMessage()
"testStarted name='testS2'".serviceMessage()
"testFinished name='testS2'".serviceMessage()
"testSuiteFinished name='suite2'".serviceMessage()

"testStarted name='testOutOfTestSuite'".serviceMessage()
"testFinished name='testOutOfTestSuite'".serviceMessage()

var jarFile = File("find-plugin/build/libs/find.jar")
if (jarFile.exists()) {
    println("##teamcity[message text='Jar file with plugin was created successfully']")
} else {
    println("##teamcity[buildProblem description='Plugin could not be found']")
}
