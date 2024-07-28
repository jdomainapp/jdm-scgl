# JDM-SCGL: Knowledge graph to SCCL parser

Implemented for ResFes 2024.

The code in this repository can be run without any further configuration. Please follow the following steps to run the program:

1. Clone the repository to your local machine.
2. Open the project with your preferred IDE. We recommend using IntelliJ IDEA to run the program as it will automatically download the necessary dependencies and save you time.
3. Download the Maven dependencies as listed in the `pom.xml` file. This project depends on two libraries: Neo4j driver and Freemarker.
4. The entry point to this application is in the `Main.java` source file. Simply run the `main` function to generate the output.
5. After the program is successfully executed, it will print a message informing you of the output location. By default, this will be the automatically-generated `/output` directory in your current working directory. You can view all the generated files here.