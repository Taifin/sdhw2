package cub.taifin.components.commands

import cub.taifin.ICommand
import org.reflections.Reflections
import org.reflections.scanners.Scanners
import org.reflections.scanners.SubTypesScanner
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import java.net.URLClassLoader
import java.nio.file.Paths
import kotlin.io.path.isReadable
import kotlin.io.path.isRegularFile
import kotlin.io.path.pathString

class JarCommandLoader : CommandLoader {
    override fun loadCommand(uri: String): List<ICommand> {
        val jarFile = Paths.get(uri)

        require(jarFile.isRegularFile()) { "${jarFile.pathString} is not a regular file"}
        require(jarFile.isReadable()) { "${jarFile.pathString} is not readable"}

        println(jarFile.toUri().toURL())

        val classLoader = URLClassLoader(arrayOf(jarFile.toUri().toURL()))
        val reflections = Reflections(
            ConfigurationBuilder()
                .addClassLoaders(classLoader)
                .setUrls(jarFile.toUri().toURL())
                .setScanners(Scanners.SubTypes)
        )
        println(reflections.configuration.urls)
        return reflections.getSubTypesOf(ICommand::class.java).map { it.getDeclaredConstructor().newInstance() }
    }
}