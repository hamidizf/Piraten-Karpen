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
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar`
  * To run the simulator:
    * `mvn exec:java -Dexec.args="random combo"`
    * or
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar random combo`
  * To turn the trace mode on, open the file log4j2.xml and change `OFF` to `ALL` in this section of code:
>
    <Loggers>
        <Root level="OFF">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers> 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < The program, upon successful compilation and execution, produces the intended output and is prepared for user evaluation and testing.  >

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
| x   | F08 | Score points: 3 of a kind(priority in terms of business value) | D | 23/01/23 | 23/01/23|
| x   | F09 | Score points: 4 of a kind and above(priority in terms of business value) | D | 23/01/23 | 23/01/23|
| x   | F10 | New Strategy: Keep Diamond or Gold coins that are more than 2 | D | 24/01/23 | 24/01/23 |
| x   | F11 | New strategy: rerolling the dices that are not 3 of a kind and above | D | 24/01/23 | 24/01/23|
| x   | F12 | New card(Sea Battle card): 2 swords | D | 24/01/23 | 24/01/23|
| x   | F13 | Sea Battle card: 3swords or more | D | 24/01/23 | 24/01/23|
| x   | F14 | new strategy: gain points according to Sea Battle cards | D | 24/01/23 | 24/01/23|
| x   | F15 | New card: Monkey Business card | D | 24/01/23 | 25/01/23|
| x   | F16 | new strategy: gain points according to  Monkey Business cards | D | 25/01/23 | 25/01/23|
| x   | F17 | New card: Sorceress card | D | 28/01/23 | 28/01/23|
| ... | ... | ... |

