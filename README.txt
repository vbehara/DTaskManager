CS542 Design Patterns
Spring 2015
PROJECT 2 README FILE

Due Date:Friday, APRIL,3, 2015
Submission Date:FRIDAY, APRIL,3, 2015
Grace Period Used This Project: 15 Days
Grace Period Remaining: 0 Days


Author: Venkata Ramana Murthy Behara
e-mail: vbehara1@binghamton.edu


PURPOSE:
This Project is mainly dealing with the implementation of the observers method with the subject as Dashborad TaskManager and 3 observers Processes , Performance , Users and 1 default observer .

DeBug Levels :

0 No output should be printed . Only error messages will be printed from catch blocks.
1 output from the display methods from Observers will be printed
2 messages from constructors will be printed to console
3 messages from all remaining methods will be printed to console
4 Only messages from Filter methods of the observers will be printed to console

PERCENT COMPLETE:

 "I believe I have completed 100% of this project."


PARTS THAT ARE NOT COMPLETE:

N/A


BUGS:

N/A


FILES:

Included with this project are 19 files:

README, the text file you are present viewing
build.xml, the ant file required for building ,cleaning and runing
Driver.java , contains the main driver to start the DashBoard TaskManager according to the user input
FileProcessor.java , Contains File Input outPut operatins into the File
DashBoardSubject.java , Contains the main DashBoardSubject implementing the subject
Subject.java , contains the subject interface
Observer.java , contains the observer interface 
ProcessesTab.java , ProcessesTab obsrver implementing observer and display interface
PerformanceTab.java , PerformanceTab obsrver implementing observer and display interface
DefaultTab.java , DefaultTab obsrver implementing observer and display interface
UsersTab.java , UsersTab obsrver implementing observer and display interface
ProcessesTabFilterImpl , Processes observer having the filter implementation implementing Filter Interface
PerformanceTabFilterImpl , Performance observer having the filter implementation implementing Filter Interface
UsersTabFilterImpl , Users observer having the filter implementation implementing Filter Interface
DefaultTabFilterImpl , Default observer having the filter implementation implementing Filter Interface
DisplayFile.java , contains the interface for Display
DashboardFilter.java , contains the interface for filter
new_in3.txt , contains the input file
new_out3.txt , contains the output file given by Teaching Assistant
outputfile.txt , contains the output of code

SAMPLE OUTPUT:
---TAB(s) BEGIN---
---TAB(s) END---
---TAB(s) BEGIN---
---PERFORMANCE---
Memory Total: 2058364  Memory Used: 1949304  Memory  Free: 109060  Memory  Cached: 1539620
CPU Idle: 94.8  CPU User Level: 4.4  CPU System Level: 0.6

---TAB(s) END---
---TAB(s) BEGIN---
---USERS---
User: (unknown)  Status: inactive
User: jakyuz1  Status: active
User: jakyuz1  Status: active
User: root  Status: inactive
User: bsendir1  Status: inactive
User: jakyuz1  Status: active
User: jakyuz1  Status: active
User: tbarten1  Status: active
User: jbelles1  Status: active
User: spinho1  Status: active
User: thung1  Status: active
User: bsendir1  Status: active
User: awiesin1  Status: active
User: jakyuz1  Status: active
User: hpittin1  Status: active
User: rashong1  Status: active
User: egarbad1  Status: active
26392 sh              jakyuz1   0.0  0.0
26393 vim             jakyuz1   0.0  0.7
26552 bash            root      0.0  0.1
26699 edit            jakyuz1   0.0  0.2
26701 sh              jakyuz1   0.0  0.0
26702 vim             jakyuz1   0.0  0.7
26721 watch           root      0.0  0.1
27017 tcsh            awiesin1  0.0  0.1
27104 gdb             awiesin1  0.0  0.7
27221 tcsh            jakyuz1   0.0  0.1
27362 make            jakyuz1   0.0  0.1
27363 gdb             jakyuz1   0.0  0.7
27449 tcsh            jbelles1  0.0  0.1
30589 bomb            jakyuz1   0.0  0.0

---TAB(s) END---
---TAB(s) BEGIN---
---PROCESSES---
  PID COMMAND         USER     %CPU %MEM
 3492 Xorg            root      0.0  0.1
 4078 getty           root      0.0  0.0
 4079 getty           root      0.0  0.0
 4080 getty           root      0.0  0.0
 4081 getty           root      0.0  0.0
 4082 getty           root      0.0  0.0
 4083 getty           root      0.0  0.0
 6130 tcsh            thung1    0.0  0.2
 8030 tcsh            egarbad1  0.0  0.1
 8526 tcsh            jakyuz1   0.0  0.1
 8614 tcsh            bsendir1  0.0  0.1
10189 tcsh            hpittin1  0.0  0.1
10191 bash            hpittin1  0.0  0.1
10986 tcsh            jakyuz1   0.0  0.1
11008 tcsh            jakyuz1   0.0  0.1
11018 tcsh            jakyuz1   0.0  0.1
11548 tcsh            rashong1  0.0  0.1
13269 gdb             thung1    0.0  0.7
13367 bomb            thung1    0.0  0.0
15430 gdb             rashong1  0.0  0.7
15726 bomb            awiesin1  0.0  0.0
17866 tcsh            tbarten1  0.0  0.1
17992 gedit           tbarten1  0.4  2.0
18003 dbus_launch     tbarten1  0.0  0.1
18005 gdb             jbelles1  0.0  0.7
18012 bomb            jbelles1  0.0  0.0
19254 tcsh            bsendir1  0.0  0.1
19317 python          bsendir1  0.1  0.4
19821 make            jakyuz1   0.0  0.1
19822 gdb             jakyuz1   0.0  0.6
19824 bomb            jakyuz1   0.0  0.0
19954 tcsh            spinho1   0.0  0.1
20283 bomb            rashong1  0.0  0.0
20339 nano            spinho1   0.2  0.1
20423 sh              bsendir1  0.0  0.0
20424 ps              bsendir1  0.0  0.0
26390 edit            jakyuz1   0.0  0.2
26392 sh              jakyuz1   0.0  0.0
26393 vim             jakyuz1   0.0  0.7
26552 bash            root      0.0  0.1
26699 edit            jakyuz1   0.0  0.2
26701 sh              jakyuz1   0.0  0.0
26702 vim             jakyuz1   0.0  0.7
26721 watch           root      0.0  0.1
27017 tcsh            awiesin1  0.0  0.1
27104 gdb             awiesin1  0.0  0.7
27221 tcsh            jakyuz1   0.0  0.1
27362 make            jakyuz1   0.0  0.1
27363 gdb             jakyuz1   0.0  0.7
27449 tcsh            jbelles1  0.0  0.1
30589 bomb            jakyuz1   0.0  0.0

---TAB(s) END---
  PID COMMAND         USER     %CPU %MEM
 3492 Xorg            root      0.0  0.1
 4078 getty           root      0.0  0.0
 4079 getty           root      0.0  0.0
 4080 getty           root      0.0  0.0
 4081 getty           root      0.0  0.0
 4082 getty           root      0.0  0.0
 4083 getty           root      0.0  0.0
 6130 tcsh            thung1    0.0  0.2
 8030 tcsh            egarbad1  0.0  0.1
 8526 tcsh            jakyuz1   0.0  0.1
 8614 tcsh            bsendir1  0.0  0.1
10189 tcsh            hpittin1  0.0  0.1
10191 bash            hpittin1  0.0  0.1
10986 tcsh            jakyuz1   0.0  0.1
11008 tcsh            jakyuz1   0.0  0.1
11018 tcsh            jakyuz1   0.0  0.1
11548 tcsh            rashong1  0.0  0.1
13269 gdb             thung1    0.0  0.7
13367 bomb            thung1    0.0  0.0
15430 gdb             rashong1  0.0  0.7
15726 bomb            awiesin1  0.0  0.0
17866 tcsh            tbarten1  0.0  0.1
17992 gedit           tbarten1  0.4  2.0
18003 dbus_launch     tbarten1  0.0  0.1
18005 gdb             jbelles1  0.0  0.7
18012 bomb            jbelles1  0.0  0.0
19254 tcsh            bsendir1  0.0  0.1
19317 python          bsendir1  0.1  0.4
19821 make            jakyuz1   0.0  0.1
19822 gdb             jakyuz1   0.0  0.6
19824 bomb            jakyuz1   0.0  0.0
19954 tcsh            spinho1   0.0  0.1
20283 bomb            rashong1  0.0  0.0
20339 nano            spinho1   0.1  0.1
20442 sh              bsendir1  0.0  0.0
20443 ps              bsendir1  0.0  0.0
26390 edit            jakyuz1   0.0  0.2
26392 sh              jakyuz1   0.0  0.0
26393 vim             jakyuz1   0.0  0.7
26552 bash            root      0.0  0.1
26699 edit            jakyuz1   0.0  0.2
26701 sh              jakyuz1   0.0  0.0
26702 vim             jakyuz1   0.0  0.7
26721 watch           root      0.0  0.1
27017 tcsh            awiesin1  0.0  0.1
27104 gdb             awiesin1  0.0  0.7
27221 tcsh            jakyuz1   0.0  0.1
27362 make            jakyuz1   0.0  0.1
27363 gdb             jakyuz1   0.0  0.7
27449 tcsh            jbelles1  0.0  0.1
30589 bomb            jakyuz1   0.0  0.0

---TAB(s) END---
---TAB(s) BEGIN---
---PROCESSES---
  PID COMMAND         USER     %CPU %MEM
 3492 Xorg            root      0.0  0.1
 4078 getty           root      0.0  0.0
 4079 getty           root      0.0  0.0
 4080 getty           root      0.0  0.0
 4081 getty           root      0.0  0.0
 4082 getty           root      0.0  0.0
 4083 getty           root      0.0  0.0
 6130 tcsh            thung1    0.0  0.2
 8030 tcsh            egarbad1  0.0  0.1
 8526 tcsh            jakyuz1   0.0  0.1

 ---TAB(s) BEGIN---
---PERFORMANCE---
Memory Total: 2058364  Memory Used: 1958180  Memory  Free: 100184  Memory  Cached: 1539912
CPU Idle: 94.8  CPU User Level: 4.4  CPU System Level: 0.6

---USERS---
User: (unknown)  Status: inactive
User: jakyuz1  Status: active
User: jakyuz1  Status: active
User: root  Status: inactive
User: bsendir1  Status: inactive
User: jakyuz1  Status: active
User: jakyuz1  Status: active
User: tbarten1  Status: active
User: jbelles1  Status: active
User: spinho1  Status: active
User: thung1  Status: active
User: bsendir1  Status: active
User: awiesin1  Status: active
User: jakyuz1  Status: active
User: hpittin1  Status: active
User: rashong1  Status: active
User: egarbad1  Status: active

---TAB(s) END---
---TAB(s) BEGIN---
---TAB(s) END---
---TAB(s) BEGIN---
---PERFORMANCE---
Memory Total: 2058364  Memory Used: 1952204  Memory  Free: 106160  Memory  Cached: 1539912
CPU Idle: 94.8  CPU User Level: 4.4  CPU System Level: 0.6

---TAB(s) END---
---TAB(s) BEGIN---
---TAB(s) END---
---TAB(s) BEGIN---
---PERFORMANCE---
Memory Total: 2058364  Memory Used: 1952904  Memory  Free: 105460  Memory  Cached: 1539916
CPU Idle: 94.8  CPU User Level: 4.4  CPU System Level: 0.6


---TAB(s) END---

BUILD SUCCESSFUL
Total time: 2 seconds


Assuming you are in the directory containing this README:

TO COMPILE: 
ant -buildfile src/build.xml all

TO RUN:
To run as the server I am replacing the args1="new_in3.txt" and args2="outputfile.txt" and arg3="1" in the ant file .
ant -buildfile src/build.xml run

TO CLEAN:
ant -buildfile src/build.xml clean

To create tarball for submission
ant -buildfile src/build.xml tarzip

EXTRA CREDIT:

Written the unregister method from observer side.


BIBLIOGRAPHY:

http://www.tutorialspoint.com/java/java_documentation.htm


ACKNOWLEDGEMENTS:

cs542 LISTSERV