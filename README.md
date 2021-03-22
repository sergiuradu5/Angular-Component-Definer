# Angular Component Definer
## 1. Description
### 1.1 Description and Purpose of The Tool
__Angular Component Definer__ is a tool for separating and grouping the files of any Angular project into Angular components, while also highlighting the Angular module files, service files, directives and guards. This project is both a standalone tool and a plugin developed for _DX Platform_, a platform for visualizing data and extracting information from software systems. The programming language used to implement the tool is _Kotlin_.

Moreover, this is also a university project implemented by _Radu Sergiu Valentin_, and _Manolache Miruna Andreea_, under the supervision of professor _Mario Riviş_, for the _CES_ course at _Politechnic University of Timişoara_.
### 1.2 The Tool's Usefulness As a Plugin for _DX Platform_
Once paired with _DX Platform_ it can be of great use when analyzing Angular projects. Possible valuable system information that could be extracted using the __Angular Component Definer__ plugin: \
    ✔️ Gauging each developer's knowledge on each component \
    ✔️ Tracking the system evolution based on how new components were being added through time \
    ✔️ Identifying problematic components, and bug magnets \
    ✔️ Estimating a raport of number of components to number of modules etc. 

## 2. Installation and Prerequisites
The tool can be run in two ways: using _Java_ with _Maven_, or via a _Docker image_.
### 2.1 Running The Tool Locally With Java
[**OpenJDK**](https://openjdk.java.net/) **11** or above and ***is required*** in order to be able to run the `angular-component-definer.jar` file with _Java_. [OpenJDK Link](https://openjdk.java.net/)

### 2.2 Editing The Source Code And Building The `.jar` File with Maven
[**Maven**](https://maven.apache.org/install.html) has to be installed in case the user wants to edit the _Kotlin_ source code inside _Main.kt_. [Maven link](https://maven.apache.org/install.html) \
After successfully installing **Maven**, the user builds the edited source code by using the following command, which creates a new `angular-component-definer.jar` file inside the `target` folder:
```mvn clean install```

### 2.3 Running The Tool via Docker Image
[**Docker**](https://docs.docker.com/get-docker/) is needed if the user prefers running the tool without _Java_, and/or doesn't have _OpenJDK_ installed. [Docker link](https://docs.docker.com/get-docker/)

### 2.4 Adding The Tool As Plugin in DX Platform
To do this, simply copy the whole `angular-component-definer` folder to the `plugins` folder of _DX Platform_, which is namely the following path: `~/.dx-platform/plugins/` \
This folder contains a `plugin-info.json` file which will make _DX Platform_ recognize and add the Angular Component Definer to its plugins list by running the tool locally with _Java_ by default. \
In case the user wants to **make _DX Platform_ run the tool via _Docker_**, then the user must follow the section [3.3 of the documentation](https://github.com/sergiuradu5/Angular-Component-Definer#33-how-to-run-the-tool-with-docker). The full `docker run` command from this section should be copied entirely and the user should replace the value of the `"commandTempate"` field inside `plugin-info.json` with the copied `docker run` command.

## 3. Usage
### 3.1 General Description of How The Tool Works
When running the tool it takes two arguments: an **outputFile** and a **filesToGroup** in _.txt_ format.
* **outputFile** should be in _.json_ format. It's where the tool will write its output results. After outputting the results into it, the file looks like this:
![alt text](https://lh3.googleusercontent.com/SaNTXL7bH_gVSmDTQOz4S--z3d6ccAvdqtERPhHaBhFeozm7SUx63HaALcPGg7EbbEqJ_lymTHq2qDRqyBkzkKJ4pXzCiboeNFzXRL9wq5Nj90Xy2NtDFZHzPAVTjBtq8cjex3Jl1AUIJaluM7Vf_fnYUbVNFGihUIijA3Dv9_-6iHbecYVWPCQRjn0-lpcedMmnEL1Rcpd0TSkmy0KE0X59o2LrSkXfQRxw57kcUWX1p6xN7LoOK4akRVlV9YeHNdZ0NdeuSTseOSOvbzR8s6foF34F70Xr0cVc-GsEbQnofwldj-CpYURh1SpvC_EVEmStJ0NEvkS-YNbXNRaYYYYb-ZTUnlONEz-l33i1epTCXPJ7nsP_y1UF7HRlKPQB1znkjrsGbAOmLj2tSZRcbRq8vl0g0PeLO77rcdXVfVLW93XkVXGfg2k2Y1N_b6JITq9oNCALMKxOyg9oXQ96E2hJfgn6axozG8o9KcWETyniOvEEARk8Tn6meMgGlKbNT7BfVmqSsPx7xbKy7rN3ivSqakx4D8Lbsch1QjMz0mUKqR-Hv0CCBJwzlbR8YMDzIZpI9xq3JmT1f7XiCAlrVZKnIjDVcGteOi27Hzw7ijdL-MEI7Y3u7ELq13pCIKbxly1702dBDifgWCg5kBEVGggCJXQjfILduSvZb8qcpQ8Z4AMfoNtqGC6Ip-EfTzFcSDM5MEnzrEffRGsc2JgPhyYz=w767-h572-no?authuser=0 "An outputFile from Angular Component Definer")
* **filesToGroup** should be in _.txt_ format. It's a file that contains a file path on each line. All these are file paths to the files of the Angular project which you would like to separate into components. The tool parses through all the lines and extracts the Angular components based on the file name. This is how it should look like:
![altText](https://lh3.googleusercontent.com/Agg9rku6vY43q8cNH1kM0fVJDacLiiwcjtaudhryixTYP-tKlS5KQ-EwonzJ7AKGs7Bsgty6bnvrE5JiPYypk-MjT2Aix1WIyPSljdz5eFRg6GElMWxJDy73g5fNy1NKYm8HFXTuRVsoXzvuStYuNdku2V56XEZvm7tzrsZVO9l_NV5p1OH_p5f080GhaexH3fxvBDqx3388tqvMyVFwLe695qp2g-1VjMCD1iFbB1V8lVhQIyyBcm7-mnY5J9A5JZcm1vN6vlGl8sANvZbGgZXMeE0CqHJ56H_K58f_zKWhvS93THt2GwPCW2MLyVApblbYpbY8bJQjNibwO70C7Slcll7OduZFhQtx-HCV6RQ6iDbSnUJD3F_mdpdnAwz7fsNcVPUOuBT5GeHyQ1DBiRy0n3IM5PvZ4XWB9MlhBP-c-PLxFVLSr3twOqGV35KkhOiTnVhMlKPatUZVnYtWq-I0dKzjRwN7LOMKkvgDM9vzalCE754PPEUDZzRmd21qVuTA9E8VHKzdqsl42O2oKqUdMGw1GjzCZ_JCUhKvXs3u2PHgYDlaKyI_qrrfeFUtmEU1gW-hZiCkU1JY_r2J3RidzsbJ1ncCY3W58GQGBKsMo2YuVuHKN4CXnFxmxsJwrgsg4F0zQfsrkbdBud-VsnXDshEpf-f21HtPxvS3OZDq4o3Jzb8HQQdDq7H5pXI0xRym85UanxoNb0q1FqJwrTpl=w681-h563-no?authuser=0 "A filesToGroup for Angular Component Definer")


### 3.2 How to Run The Tool with Java
Navigate to the directory where `angular-component-definer.jar` file is located, and use the following command, as follows:
    ```java -jar angular-component-definer.jar ${outputFile} ${filesToGroup}```
* Replace **`${outputFile}`** with the path to a _.json_ file in which you would like to store your results. Exclude the dollar sign (`$`) and the curly brackets (`{}`).
* Replace **`${filesToGroup}`** with the path to a _.txt_ file. Exclude the dollar sign (`$`) and the curly brackets (`{}`) 

### 3.3 How to Run The Tool with Docker
After you made sure _Docker_ is installed successfully, pull the following image from [**Docker Hub**](https://hub.docker.com/r/sergiuradu/angular-component-definer) by accessing [this link](https://hub.docker.com/r/sergiuradu/angular-component-definer), or by using the following command:
    ```docker pull sergiuradu/angular-component-definer```

Next, run the pulled image with this command:
    ```
    docker run -v ${outputFile}:/app/r/result.json 
    -v ${filesToGroup}:/app/ftg/filesToGroup.txt sergiuradu/angular-component-definer```
* In order to create and run a container successfully, by running this command, you will copy the path of the **outputFile** and of the **filesToGroup** from your machine to the exact specific file paths `/app/r/result.json` and `/app/ftg/filesToGroup.txt` respectively of the _Docker container_. This is done using the `-v` Mount Volume command. The specific file paths of the _Docker container_ must not be mistyped.
* Replace **`${outputFile}`** with the path to a _.json_ file on your machine in which you would like to store your results. Exclude the dollar sign (`$`) and the curly brackets (`{}`).
* Replace **`${filesToGroup}`** with the path to a _.txt_ file with a file path on each line. All these are file paths to the files of the Angular project which you would like to separate into components. Exclude the dollar sign (`$`) and the curly brackets (`{}`) 

##   4. Contributing
Since this is a simple university project, no contribution is required/for this tool.

##  5. Authors and acknowledgment
Authors: [Radu Sergiu Valentin](https://github.com/sergiuradu5), [Manolache Miruna Andreea](https://github.com/manolachemiruna). \
Special acknowledgements to our professor Mario Riviş.

## 6. Licence
Licence type: [apache-2.0](https://github.com/sergiuradu5/Angular-Component-Definer/blob/master/LICENCE)
