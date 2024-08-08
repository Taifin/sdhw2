# Homework #3 (Architectural styles)

## Solution
 
This repository contains three separate subprojects: 
  
* `cli-commands` -- library exposing necessary functionality to develop new commands and ship them as plugins
* `cli` -- main application
* `find-plugin` -- plugin with `find` command implementation

(note: probably, it would be more appropriate to make submodules in the `cli` library (such as `commands`, `parser`, etc.) as separate Gradle projects and thus
avoid making fully separate `cli-commands` library, but I am not that familiar with Gradle and Java packages concepts to
reason about what is better)

To run the application: 
1. Publish `cli-commands` library to your local Maven repository:
    ```bash
    cd cli-commands && ./gradlew publishToMavenLocal && cd ..
    ```
2. Create `.jar` archive with the `find` plugin:
    ```bash
    cd find-plugin && ./gradlew jar && cd ..
    ```
3. Run `cli` application with a path to your `.jar` file with plugin (by default: `find-plugin/build/libs/find.jar`):
    ```bash
    cd cli && ./gradlew run --args='../find-plugin/build/libs/find.jar'
    ```

## Statement

Extend your application from the previous homework using plugin-based architecture.

* Update your application to be extensible via plugins.
* Make a “plugin” `find word /path/to/file` that prints lines that contain the word

### Examples

Running the app without "plugins".

```
$ ./my-app 
> help
cat
help
lc
```

Running the app with a "plugin".

```
$ ./my-app /path/to/plugin /path/to/config/file/if/necessary
> help
cat
find 
help
lc
> cat /Users/ravil/txt.csv 
Linux, 
Git, 
HTTP,
> find git /Users/ravil/txt.csv 
2: Git,
```

### Some hints

The word “plugin” is too broad. Depending on your programming language, multiple ways to implement it might exist.
I.e., it can dynamically load libraries for C++, dynamic imports for Python, or classloading for Java.
All popular languages have the ability to load code.
You can use any kind of configuration files if it’s necessary.
