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
| x   | F01 | Roll a dice |  S | 01/01/23 |  |
| x   | F02 | Roll remaining dices  |  B (F01) |   |
| x   | F03 | Play 42 games  |  P  |   |
| x   | F04 | end of turn with three skulls | P | |
| x   | F05 | Player keeping random dice at their turn | B (F02) | | 
| x   | F06 | Score points: number of gold coins and diamonds multiplied 
by 100 | B (F04) | | 
| x   | F07 | Print the percentage of wins for each player | B (F03) | |
| ... | ... | ... |

