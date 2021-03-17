import java.io.File
import java.nio.file.Files
import kotlin.io.path.ExperimentalPathApi
import java.io.IOException
import java.io.FileWriter
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

@ExperimentalPathApi

    fun main(args: Array<String>) {

        if (args.size != 2) {
            print("Please provide both arguments!")
            return
        }

        val outputFilePath = args[0]
        val filesToGroup = args[1]

        if (File(outputFilePath).exists()) Files.delete(File(outputFilePath).toPath())

        val files = Files.readAllLines(File(filesToGroup).toPath())

        val componentFiles = files
            .filter {
                it.toString().endsWith("component.ts") || it.toString().endsWith("component.html") ||
                        it.toString().endsWith("component.css") || it.toString().endsWith("component.scss") ||
                        it.toString().endsWith("component.spec.ts")
            }
        val otherFiles = files
            .filter {
                it.toString().endsWith("module.ts") || it.toString().endsWith("guard.ts") ||
                        it.toString().endsWith("service.ts") || it.toString().endsWith("directive.ts")
            }

        var components: Set<Component> = emptySet()
        val mapper = jacksonObjectMapper()


        componentFiles.map { file ->
            val array = file.toString().substring(0, file.toString().length - 8).split(".")
            var i = 1
            var filePath = array[0]

            while (i < array.size - 1) {
                filePath += "." + array[i]
                i++
            }
            val filesPath = componentFiles.filter { it.toString().startsWith(filePath) }
            val arrayOfSubfolders = filePath.split("\\")
            val componentName = arrayOfSubfolders[arrayOfSubfolders.size - 1]
            var files: List<String> = emptyList()
            val iterator = filesPath.iterator()
            while (iterator.hasNext()) {
                val item = iterator.next().toString()
                files = files + item
            }
            val value = Component("Component: " + componentName, files)
            components = components + value
        }

        otherFiles.map { file ->
            val array = file.toString().split(".")
            var i = 1
            var filePath = array[0]

            while (i < array.size - 1) {
                filePath += "." + array[i]
                i++
            }
            val fileEnding = array[array.size - 2] + "." + array[array.size - 1]
            val componentType = array[array.size - 2][0].toUpperCase() + array[array.size - 2].substring(1) + "s"
            val filesPath = otherFiles.filter { it.toString().endsWith(fileEnding) }

            var files: List<String> = emptyList()
            val iterator = filesPath.iterator()
            while (iterator.hasNext()) {
                val item = iterator.next().toString()
                files = files + item
            }
            val value = Component(componentType, files)
            components = components + value
        }

        var writer = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(components)

        try {
            val fw = FileWriter(outputFilePath, true)
            fw.write(writer)
            fw.close()
        } catch (e: IOException) {
        }
    }


    data class Component(
        val fullyQualifiedName: String,
        val files: List<String>,
    )
