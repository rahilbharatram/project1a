1) Problems
- The ant file is able to compile the program to a .jar and execute on input and output files if hardcoded into the main function situated in "SearchMap.java". This can be done by executing "ant init compile dist run // ant run"
- When trying to read the args an error is displayed in the console "Target "input.txt" does not exist in the project "SearchMap"
- The ant "test" does not compile properly; however works when unit testing the classes from eclipse

2) What is working
- The program is able to read files and output the correct flight plans to the specified files
- The unit tests work and are able to test the public methods correctly when executed by eclipse
- Ant commands for clean, init, compile and dist all work when the argument files (input and output) are hard coded into main
- Git was used to maintain version control

3) How to test
- Possibly if input and output files could be hard coded to test, the program will run correctly
- The JUnit tests can be executed by eclipse when imported 


