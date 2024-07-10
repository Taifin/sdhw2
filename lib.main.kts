@file:Repository(
    "https://packages.jetbrains.team/maven/p/tc/maven",
    options = [
        "username=Mikhail.Rodionychev",
        "password=\$SPACE_TOKEN"
    ]
)
@file:DependsOn("org.jetbrains.teamcity:kotlin-service-messages:1.0.0")

import org.jetbrains.teamcity.TeamCity

TeamCity.BuildLog.message("Hello, world")
TeamCity.Build.progress("A progress message") {

}