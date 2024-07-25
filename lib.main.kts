//@file:Repository("https://packages.jetbrains.team/maven/p/teamcity-vcs/maven")
@file:DependsOn("org.jetbrains.teamcity:kotlin-build-step-api:1.3.0-l")

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.jetbrains.teamcity.TeamCity
import org.jetbrains.teamcity.enums.MessageStatus

TeamCity.BuildLog.message("some text", status = MessageStatus.WARNING, errorDetails="more\n details")


TeamCity.Build.test("testName", calculateDuration = true, captureStandardOutput = true) {
    testFailed("test failed for a reason")
}

runBlocking {
    TeamCity.Build.Async.progress("foo") {
        message("bar")
        delay(100)
    }
}