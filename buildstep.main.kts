@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")

import java.io.File
import java.lang.Thread.sleep
import kotlinx.coroutines.*
import java.nio.file.Paths


fun String.serviceMessage() = println("##teamcity[$this]")

runBlocking {
    "message text='starting coroutines'".serviceMessage()
    launch {
        delay(5000L)
        "message text='coroutine 1 started and waited' flowId='coroutine1'".serviceMessage()
        delay(5000L)
    }
    launch {
        "message text='coroutine 2 started' flowId='coroutine2'".serviceMessage()
        delay(10000L)
        "message text='coroutine 2 waited even more' flowId='coroutine2'".serviceMessage()
    }
    "message text='coroutines finished'".serviceMessage()
}

"inspectionType id='123' name='inspectionType' category='Style violations' description='foobar'".serviceMessage()

"publishArtifacts ${Paths.get("find-plugin/build/libs/find.jar")} => find.jar".serviceMessage()

"progressMessage 'start of the build step'".serviceMessage()

"blockOpened name='block1' flowId='id1'".serviceMessage()
"blockOpened name='block2' flowId='id2'".serviceMessage()
"message flowId='id1' text='foo'".serviceMessage()
"message flowId='id2' text='bar'".serviceMessage()
"blockClosed name='block2' flowId='id2'".serviceMessage()
"blockClosed name='block1' flowId='id1'".serviceMessage()

"message flowId='id1' text='message with id1 out of block id1'".serviceMessage()

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

"testStarted name='failWithExpectedActual'".serviceMessage()
"testFailed name='failWithExpectedActual' expected='foo' actual='bar'".serviceMessage()
"testFinished name='failWithExpectedActual'".serviceMessage()

"testStarted name='comparisonFailedExpectedActual'".serviceMessage()
"testFailed name='comparisonFailedExpectedActual' expected='barfoo' actual='foobar' type='comparisonFailure'".serviceMessage()
"testFinished name='comparisonFailedExpectedActual'".serviceMessage()

"testStarted name='customTypeExpectedActual'".serviceMessage()
"testFailed name='customTypeExpectedActual' expected='abacaba' actual='cabadaba' type='SK'".serviceMessage()
"testFinished name='customTypeExpectedActual'".serviceMessage()

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
