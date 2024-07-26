
/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2024.07"

project {
    buildType(Build)
}

val f = Foo()
f.meow()

object Build : BuildType({
    name = "Main Build Configuration"

    vcs {
        root(DslContext.settingsRoot)
    }

    val file = File("foo")

    steps {
//        kotlinFile {
//            name = "TeamcityBuildstep"
//            id = "TeamcityBuildstep"
//            path = "custom.teamcity.buildstep.kts"
//        }
//        kotlinFile {
//            name = "flows"
//            id = "kts"
//            path = "flows.main.kts"
//            param("scriptContent", "@file:dependsOn(org.example:foobar:1.0)")
//        }
//        kotlinFile {
//            name = "kts_main"
//            id = "kts_main"
//            path = "buildstep.main.kts"
//            param("scriptContent", "@file:dependsOn(org.example:foobar:1.0)")
//        }
//        script {
//            name = "echo message"
//            id = "echo_message"
//            scriptContent = """
//                echo "##teamcity[message text='just a message']"
//                echo "##teamcity[buildProblem description='foobar']"
//            """.trimIndent()
//        }
        kotlinFile {
            name = "Lib"
            id = "Lib"
            path = "lib.main.kts"
        }
    }

    triggers {
        vcs {
        }
    }
})
