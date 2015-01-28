finalProj
************* Student Organizer *************

by Emma Bernstein, Samuel Zhang, and Max Kong ***************** of pd 3 *****************

What does it do?
(GUI Version)
We have created a planner program that allows one to integrate their schedule into a format that both organizes tasks and limits procrastination. We have done this through adding attributes to the tasks as they are added to the list of tasks. In addition to the name of the task, we also ask for the priority of the task to better order the schedule, a projected time that will start a timer based off this and keep you from procrastinating and a due date to keep track of when you need to accomplish tasks. Bugs ---------------------------------------- Sometimes when you run the .class file the GUI doesn't display anything. Either wait a few seconds or recompile and run. The selected task on the left hand side has the wrong timer control if you add multiple tasks.
(Terminal Version)
The idea is the same as the GUI version, and this one is fully functional. The user is able to create new tasks, remove them, print them, start them, and save them to an external file which stores all user data. The Terminal version also includes an alarm when the task's timer is completed. (NOTE: The actual program itself should run off of Execute.java)
Special Compiling

The GUI works on Ubuntu systems that run java version 1.7.0_65.

The terminal version will work on all systems with java.

How the program should work
(GUI Version)
The program creates a GUI which has three bu- ttons: create task, delete task, and start t- imer.
The user ought to be able to create a task wi- th Name, Due date, priority, and time. Prio- rity determines the position of the task wit- hin the ArrayList of tasks, which (should) display in order on the panel. This fuction however, is currently broken. Ideally, if we were able to display our task buttons, the user would click their task and then be able to choose to work on the task ( i.e. using the timer), or delete the task.
(Terminal Version)
Works the same way as the GUI should, and is fully functional, unlike the GUI version. Instead of clicking buttons, the user would be prompted to type input in order to carry out functions.

Files
TaskList.java
Task.java
Timer.java
FileCreate.java
NewFile.csv
Alarm.wav

