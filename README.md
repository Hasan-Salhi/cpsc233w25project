Pokemon Tracker
@Version: 1.0
@Authors: Jade Torres, Jordan Tran, Hasan Salhi

IMPORTANT: Follow these steps before running the program in IntelliJ.
---
Add the JavaFX SDK as a library to the Project
File -> Project Structure -> Modules -> Dependencies -> Add -> Add Library -> New Library

Then navigate to the location of the JavaFX SDK on your computer, adding the 'lib' folder.

---

Afterward, to run the program itself you must go to the TrackerController.java run configuration, and edit the VM options.

Change it so --module-path leads to where you have the Java SDK library installed on your computer.
You should be able to run the program after doing this. 

---
Hasan Salhi
To open it via jar:

Open terminal in directory where jar file is stored
Enter 'java --module-path "C:\Location of javafx library" --add-modules javafx.controls,javafx.fxml -jar cpsc233w25project.jar'