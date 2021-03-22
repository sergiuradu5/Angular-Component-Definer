# Angular Component Definer
## 1. Description
### 1.1 Description and Purpose of The Tool
__Angular Component Definer__ is a tool for separating and grouping the files of any Angular project into Angular components, while also highlighting the Angular module files, service files, directives and guards. This project is both a standalone tool and a plugin developed for _DX Platform_, a platform for visualizing data and extracting information from software systems. The programming language used to implement the tool is _Kotlin_.

Moreover, this is also a university project implemented by [_Radu Sergiu Valentin_](https://github.com/sergiuradu5), and [_Manolache Miruna_](https://github.com/manolachemiruna), under the supervision of professor _Mario Riviş_, for the _CES_ course at _Politehnica University of Timişoara_.
### 1.2 The Tool's Usefulness As a Plugin for _DX Platform_
Once paired with _DX Platform_ it can be of great use when analyzing Angular projects. Possible valuable system information that could be extracted using the __Angular Component Definer__ plugin: \
    ✔️ Gauging each developer's knowledge on each component \
    ✔️ Tracking the system evolution based on how new components were being added through time \
    ✔️ Identifying problematic components, and bug magnets \
    ✔️ Estimating a ratio of number of components to number of modules etc. 

## 2. Installation and Prerequisites
The tool can be run in two ways: using _Java_ with _Maven_, or via a _Docker image_.
### 2.1 Prerequisites for Running The Tool Locally With Java
[**OpenJDK**](https://openjdk.java.net/) **11** or above and ***is required*** in order to be able to run the `angular-component-definer.jar` file with _Java_. [OpenJDK Link](https://openjdk.java.net/)

### 2.2 Prerequisites for Editing The Source Code and Building The `.jar` File with Maven
[**Maven**](https://maven.apache.org/install.html) has to be installed in case the user wants to edit the _Kotlin_ source code inside _Main.kt_. [Maven link](https://maven.apache.org/install.html) \
After successfully installing **Maven**, the user builds the edited source code by using the following command, which creates a new `angular-component-definer.jar` file inside the `target` folder: \
```mvn clean install```

### 2.3 Prerequisites for Running The Tool via Docker Image
[**Docker**](https://docs.docker.com/get-docker/) is needed if the user prefers running the tool without _Java_, and/or doesn't have _OpenJDK_ installed. [Docker link](https://docs.docker.com/get-docker/)

### 2.4 Adding The Tool as Plugin in DX Platform
To do this, simply copy the `angular-component-definer.jar` and also copy the `plugin-info.json`, make a new folder `angular-component-definer` inside the `plugins` folder of _DX Platform_, which is namely at the following path: `~/.dx-platform/plugins/`, and paste the both files there. 

The `plugin-info.json` file will make _DX Platform_ recognize and add the Angular Component Definer to its plugins list by running the tool locally with _Java_ by default.

In case the user wants to **make _DX Platform_ run the tool via _Docker_**, then the user must follow the section [3.3 of the documentation](https://github.com/sergiuradu5/Angular-Component-Definer#33-how-to-run-the-tool-with-docker). The full `docker run` command from this section should be copied entirely and the user should replace the value of the `"commandTempate"` field inside `plugin-info.json` with the copied `docker run` command.

## 3. Usage
### 3.1 General Description of How The Tool Works
When running the tool it takes two arguments: an **outputFile** and a **filesToGroup** in _.txt_ format.
* **outputFile** should be in _.json_ format. It's where the tool will write its output results. After outputting the results into it, the file looks like this:
![alt text](https://lh3.googleusercontent.com/ZfpzCeaM6nrwIlP5v37zCq054U0kUFCXvJ9oQJDL6CgcbkMAiBKqY4f3uxyJIYXBjMHwuFilSTd41N_tZz2kjeyDa-ZcdFj2XfYIXrJfOOrdcxKxqf9JzGpp5HoAxhhnRYjDGSd8R5QkwzoNQTAX4Mm2kJ8CNuwMrMzz-QBEVQHx1SKLHnrrlb2_qKXPFResPJVSUrhJ19K8aZ6DLkfK2-kcj_THwq-IjHU-NWAYhua2SM0mZNV7bC4jhWQso9qEn9_6PIIVrPz-Nw_C4ZcoKMSuUnw1PDabHQCXhWhq1k7pJTsjbtRQJ8o108tAnGH4fUwF8dKZUKb7rEpkNSVZJmU_1aJ3frgdk4UNfAaYx0APn-hl-gzkJTN4jzVZfdCp5CQddGUaCVVO5wHGmmsKrqywKUFUtiXiKvGbr_2HGmhOkNe7O-JciDZ5PyolyDFdmDjMn4FtiArDxXcA0AJC-Ds_MGIgEdo5NtSmqS94mndCE6JtYJmG9QE10HQnXOAbP9_LIGHQcpXVG-2sVA9ow6JkZFkIqjZAQ2NSba9hYjq2ZSAl7rk8wxL3be5cq7zbSggkoks-eYq9y9Jvk65tiP0HroQR-j-eojqM4l5-bXZVJ97LPkLRphIhx2kbHCkQ20-IAhn6GWpxCw4Y_ivRidWybLg0nO3XSuCC1eYACNnQegQOYv87ZEJ8woCOANpkq7dlJlask3M2KkrIIOlFFVLG=w767-h572-no?authuser=0 "An outputFile from Angular Component Definer")
* **filesToGroup** should be in _.txt_ format. It's a file that contains a file path on each line. All these are file paths to the files of the Angular project which you would like to separate into components. The tool parses through all the lines and extracts the Angular components based on the file name. This is how it should look like:
![altText](https://lh3.googleusercontent.com/Sdo-v9XyUVInyThSinYmCuMS6AVFr4AdEXOUTk0DkWQNcTgbTja5SeR6MddKX1IAtb8mqd5cT8KWqRypPkVnioBZ7_eoGx3c-nyYUIDf_xZQ2h1INF68_f93gXVWjNez5y9CefI-O7Z-omU3YwR7qMUgHF3tUQGB0Y14oLFZ3q9hAk9AjEuIt4UzyRFg9ZWOLBFz8AZk396-f-eI7NHkoQAWixeK6Dh0Hdz1LI_B5wHwbadH0jJLfhlnk_Ogm_oQVeCNSA39cFSIgany7pfkOH6BNzVuih1JkvPg3DeATNPqwlr4qwUEoejWb5CVEW9BPo-1-0sBxR-xh7_aaz8HZC8msjVz56rfgyDTpn2wf3ucGyYePwJYY0IgbE585PGlejtCYDSl_fm4eDcbue7Kw39XSeXZj9EC2i-kKA6q71MR0XLN1syxvJBXUmoA0asvOX8LRBbe3EX6lAp01-0wD0EB54gIgBOInbF36BgjRceSAOgVEgqOS-hspCEhrXT6yPCtZ5XokHy_AnkaHhw4SerLc6SOawmSb9xyfkKllF8m91onuaCyndvQl19n_AmVCevCAJkW4n6sYjsD8lPYdmTWMhBGAIgAy6Qy000cBRFAAdk4rFzTttAAh3Gpd8CyTAw_pYvS7jcsQyvzMPFAVKeVpcNhJNlh5CM7e8RHlGQ4AI_1PPeYtrgaJMoBe2XoaGXR9tVPp1CU3ifxNnO5x3j_=w692-h572-no?authuser=0 "A filesToGroup for Angular Component Definer")


### 3.2 How to Run The Tool with Java
Navigate to the directory where `angular-component-definer.jar` file is located, and use the following command, as follows: \
    ```java -jar angular-component-definer.jar ${outputFile} ${filesToGroup}```
* Replace **`${outputFile}`** with the path to a _.json_ file in which you would like to store your results. Exclude the dollar sign (`$`) and the curly brackets (`{}`).
* Replace **`${filesToGroup}`** with the path to a _.txt_ file. Exclude the dollar sign (`$`) and the curly brackets (`{}`) 

### 3.3 How to Run The Tool with Docker
After you made sure _Docker_ is installed successfully, pull the following image from [**Docker Hub**](https://hub.docker.com/r/sergiuradu/angular-component-definer) by accessing [this link](https://hub.docker.com/r/sergiuradu/angular-component-definer), or by using the following command: \
    ```docker pull sergiuradu/angular-component-definer```

Next, run the pulled image with this command: \
    ```
    docker run -v ${outputFile}:/app/r/result.json 
    -v ${filesToGroup}:/app/ftg/filesToGroup.txt sergiuradu/angular-component-definer```
* In order to create and run a container successfully, by running this command, you will copy the path of the **outputFile** and of the **filesToGroup** from your machine to the exact specific file paths `/app/r/result.json` and `/app/ftg/filesToGroup.txt` respectively of the _Docker container_. This is done using the `-v` Mount Volume command. The specific file paths of the _Docker container_ must not be mistyped.
* Replace **`${outputFile}`** with the path to a _.json_ file on your machine in which you would like to store your results. Exclude the dollar sign (`$`) and the curly brackets (`{}`).
* Replace **`${filesToGroup}`** with the path to a _.txt_ file with a file path on each line. All these are file paths to the files of the Angular project which you would like to separate into components. Exclude the dollar sign (`$`) and the curly brackets (`{}`)

##   4. Contributing
Since this is a simple university project, no contribution is required or expected for this tool.

##  5. Authors and acknowledgment
Authors: [Radu Sergiu Valentin](https://github.com/sergiuradu5), [Manolache Miruna Andreea](https://github.com/manolachemiruna). \
Special acknowledgements to our professor Mario Riviş.

## 6. Licence
Licence type: [apache-2.0](https://github.com/sergiuradu5/Angular-Component-Definer/blob/master/LICENCE)
