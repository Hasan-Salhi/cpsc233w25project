IMPORTANT: Follow these steps before running the program in IntelliJ.
---
Add the JavaFX SDK as a library to the Project
File -> Project Structure -> Modules -> Dependencies -> Add -> Add Library -> New Library

Then navigate to the location of the JavaFX SDK on your computer, adding the 'lib' folder.

---

Afterward, to run the program itself you must go to the TrackerController.java run configuration, and edit the VM options.

Change it so --module-path leads to where you have the Java SDK library installed on your computer.
You should be able to run the program after doing this. 