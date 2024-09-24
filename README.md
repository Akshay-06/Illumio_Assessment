# Illumio_Assessment
Illumio Technical Assessment Repository

# Assumptions
* The flow logs contain consistent data and adhere to the standards outlined in the AWS User Guide. 
* According to the AWS guidelines, the **7th field** in the logs is treated as the **destination port**, while the **8th field** corresponds to the **protocol**. 
* All entries in the input logs are assumed to be valid.

# How to run the log parser

## Step 1: Download the java project locally
* Install `git`, if not already present.
* Clone the repository using the command `git clone git@github.com:Akshay-06/Illumio_Assessment.git`
* Go to the root folder of the git repository.

## Step 2: Add input files under `resources/input` folder
* Add the Flow log data to `logs.txt` and place it under `Illumio_Assessment/src/main/resources/input`
* Add the Lookup table data to `lookup_table.csv` and place it under `Illumio_Assessment/src/main/resources/input`

## Step 3: Ensure Java is installed
* This project is written using Java language. It should ideally work for any version of java above Java 8. Make sure java is installed by running `java --version`

## Step 4: Compile and run the program
* Open a command terminal, go to the repository root `Illumio_Assessment` and run the following commands.
```
javac -d ./out $(find ./src/main -type f -name "*.java" 2> /dev/null)
java -cp ./out src/main/java/org/illumio/Main.java

Note: If using a system other than MAC or Linux, kindly substitute appropriate command for `find`.
```

* Alternatively, if you are using an IDE, you can right-click on `Main.java` class and run the program directly from the IDE. It will generate the same result.

## Step 5: Output
* The results will be saved in the output folder. 
* `port_protocol_combination_counts.csv` will contain the counts of port and protocol combinations.
* `tag_counts.csv` will contain the counts of tags.

## Step 6: Testing
* Conducted unit tests to verify that the individual methods are functioning as intended.
* Executed the program to generate the two output files and manually validated the results against the dataset provided in the `src/main/resources/input` folder to ensure accuracy.

# Links
* AWS User Guide https://docs.aws.amazon.com/vpc/latest/userguide/flow-log-records.html <br>
* Protocol Numbers https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml
