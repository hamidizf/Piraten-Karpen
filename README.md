# A1 - Piraten Karpen

  * Author: < Fatemeh(Haniye) Hamidizadeh >
  * Email: < hamidizf@mcmaster.ca >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
<<<<<<< HEAD
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar`
  * To turn the trace mode on, open the file log4j2.xml and change `OFF` to `ALL` in this section of code:
>
    <Loggers>
        <Root level="OFF">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers> 
=======
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
  * To turn the trace mode on, open the file log4j2.xml and change `OFF` to `ALL` in this section of the code: 
>
    <Loggers>
        <Root level="OFF">
            <AppenderRef ref="Console"/>   
        </Root>
    </Loggers>
>>>>>>> Haniye

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < The program is compiled and runs without failure, gives the desired 
output, and is ready to be tested by the user.  >

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 15/01/23 | 15/01/23  |
| x   | F02 | Roll remaining dices  | D | 15/01/23 | 15/01/23  |
| x   | F03 | Play 42 games  |  D  | 18/01/23 | 19/01/23 |
| x   | F04 | end of turn with three skulls | D | 17/01/23 | 17/01/23|
| x   | F05 | Player keeping random dice at their turn | D | 16/01/23 | 16/01/23 | 
| x   | F06 | Score points: number of gold coins and diamonds multiplied by 100 | D | 17/01/23 | 17/01/23 | 
| x   | F07 | Print the percentage of wins for each player |  D  | 18/01/23 | 19/01/23 |
| x   | F08 | Score points: 3 of a kind | D | 23/01/23 | 23/01/23|
| x   | F09 | Score points: 4 of a kind and above | D | 23/01/23 | 23/01/23|
| x   | F10 | new strategy: rerolling the dices that are not 3 of a kind and above |  | /01/23 | /01/23|
| x   | F11 |  |  | /01/23 | /01/23|
| ... | ... | ... |

