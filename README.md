# Creating Community Small Groups
A work by:  Thuan Nguyen and Abigail Joppa

The problem we are trying to solve with this program is creating weekly small group Bible studies from a list of church members that will change every week so everyone has a chance to vist everyone elses home by the end of the weeks. So, our goal with this project was to create a program that would take in a list of names and the desired group size from the user and print out the list of groups for each week such that everyone will eventually visit everyone's home. 

## Description

We utilized the language Java for our program, as well as the jgrapht library. 
Obviously first we have the user input the txt file that conatins the list of names and also the desired group size for the small groups. We store the names in an arrayList, and then create another arrayList that stores the number of people in each household from that name arrayList. 
For our program we relized that a complete directed graph (i.e. every node has a edge that conects to every other node) would represent the end product of the small groups. So, if we successfully got everyone to visit everyone's home, then we will have a complete graph. 
Then we calculate how many host's are needed per week, and how many extra people we will have. 
To do this, we have a directed graph (from jgrapht), a trackGroupMember, a groupMember, and a 2D array. The trackGroupMember is the arrayList that keeps track of the member who has alread been on the schedule for that particular week. The groupMember is the arrayList that keeps the member's name for each host. The 2D array is keeping track of the data of each week and host and the first one on each of the rows is the host. 
Both trackGroupMember and the 2D array will clear after each week schedule is made. GroupMember will clear after each host has enough members. 

We add then data of the host to the groupMember. 
Then we add members to the groups based on the condition of the number of people who have already been to that persons house. In the normal case we check the groupMember array to determine what members are have not been to that host yet and add members until the group becomes full. In the other case, we have two hosts that need the same members in order to make the graph complete so we have a separate section of code that makes two more weeks such that the both hosts have a chance to host the needed members to complete the graph. 

## Requirements

- We utilized Visual Studio Code with Microsoft's Java Extension Pack. (https://code.visualstudio.com/docs/languages/java)
- We also used the jgrapht library. (https://jgrapht.org/). We need to add this java library file in Referenced Library.

## User Manual

<u>YouTube Video:</u>

https://youtu.be/KVFUqtmFlMk

<u>Instructions:</u> 

1. Once you clone the program into your computer, ensure that the jgrapht jar files are in the Refernce Library. If not, you should add it into the Reference library in your Java Project
2. Run the program using java compiler
3. Input the name of the txt file that you want to create small groups from: 
<img src="image/instructions00.jpg"
     alt="instructions">
4. Once you input the txt file, it will output the names in that file and an array containing the number of people in each house hold. You then input the number of people in the small group you would like:
<img src="image/instructions01.jpg"
     alt="instructions1">
5. Once you enter, the algorithm will run and output the groups for each week, with the first person of each line being the host:
<img src="image/instructions02.jpg"
    alt="instructions2">


## Reflection

  
In order to find the set of sets of groups in the minimum number of iterations, the algorithm could use an adjacency matrix to store who has visited who’s home. First go through the list of names choosing the first person as the host and add members to the list until they reach the max group size noting who has been to whose house as you go (label in the adjacency matrix as week 1). Then from there repeat until all the names for the first week are accounted for. Then start on the second name for the host and repeat until all names are accounted for for week two keeping track of who has visited whose house and ensuring that there is no one who is repeating (labeling in the adjacency matrix as week two). Continue in this way until everyone has hosted everyone (labeling in the matrix which week they go to each host). 

The time complexity of that algorithm is 0(n^2) when n is the vertices. By create a adjacency matrix we need to build a square n*n.  When the graph is complete, we will have n(n-1)/2 edges. 

The time complexity of the algorithm we used for our programming is O(n^2), but worst case the time complexity is O(n^3). We used nested for loops in our algorithm to decide who is the host each of the small groups and to decide who the members are of the small groups for each week (O(n^2)); however, if we have to reenter the while loop because not everyone has visited everyone then the time complexity is worse case (O(n^3)). 

One of the biggest difficulties we had to overcome in this project was figuring out how to keep track of the names in such a way that ensured that every person visited every other person’s house. Because we started with using the directed graph as our data type we were able to know who was matched but struggled to figure out how to store who was where each week. To remedy this we implemented a 2D array to keep track of who has visited each home.
We also had troubles figuring out how to handle an uneven number of people. Like when the number of people in the txt file was 16 and we wanted groups of 6, there were 4 people we needed to account for and add onto the small groups. We remedy that by distributing them as evenly as possible to each of the small groups each week. Lastly one problem we had was the program stopped because it was not a complete graph but didn’t know how to handle two hosts that still needed the same members to finish the graph. To remedy this we created a separate “special” case that handled this by assigning the first host the people and repeating people for the other and then switching the next week thus “completing” the graph. 




## Results

<h3><u>Code Outputs and Screenshots:</u></h3>

<h3>GROUP1.TXT</h3>

<h3>
Please input your plaintext file with the smallgroup names:<br>
group1.txt<br>
file name is:group1.txt<br>
[Wanda,Vision, Tony,Pepper, Strange, Loki, Bruce, Clint, Carol, Nebula, Bucky, Gamora, TChallaa, Steve, Peggy, Sam]<br>
[2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]<br>
Please input the group size:<br>
5<br>
</h3>


The schedule for week 0<br>
Wanda,Vision Tony,Pepper Strange <br>
Loki Bruce Clint Carol Nebula <br>
Bucky Gamora TChallaa Steve Peggy Sam <br>

The schedule for week 1<br>
Gamora Wanda,Vision Tony,Pepper <br>
TChallaa Strange Loki Bruce Clint <br>
Steve Carol Nebula Bucky Peggy Sam <br>

The schedule for week 2<br>
Peggy Wanda,Vision Tony,Pepper <br>
Sam Strange Loki Bruce Clint <br>
Carol Nebula Bucky Gamora TChallaa Steve <br>

The schedule for week 3<br>
Nebula Wanda,Vision Tony,Pepper <br>
Bucky Strange Loki Bruce Clint <br>
Gamora Carol TChallaa Steve Peggy Sam <br>

The schedule for week 4<br>
TChallaa Wanda,Vision Tony,Pepper<br> 
Steve Strange Loki Bruce Clint <br>
Peggy Carol Nebula Bucky Gamora Sam <br>

The schedule for week 5<br>
Sam Wanda,Vision Tony,Pepper <br>
Strange Loki Bruce Clint Carol <br>
Nebula Bucky Gamora TChallaa Steve Peggy <br>

The schedule for week 6<br>
Bucky Wanda,Vision Tony,Pepper <br>
Gamora Strange Loki Bruce Clint <br>
TChallaa Carol Nebula Steve Peggy Sam <br>

The schedule for week 7<br>
Steve Wanda,Vision Tony,Pepper <br>
Peggy Strange Loki Bruce Clint <br>
Sam Carol Nebula Bucky Gamora TChallaa <br>

The schedule for week 8<br>
Wanda,Vision Loki Bruce Clint <br>
Tony,Pepper Strange Carol Nebula <br>
Bucky Gamora TChallaa Steve Peggy Sam <br>

The schedule for week 9<br>
Wanda,Vision Carol Nebula Bucky <br>
Tony,Pepper Loki Bruce Clint <br>
Strange Gamora TChallaa Steve Peggy Sam <br>

The schedule for week 10<br>
Loki Wanda,Vision Tony,Pepper <br>
Bruce Strange Clint Carol Nebula <br>
Bucky Gamora TChallaa Steve Peggy Sam <br>

The schedule for week 11<br>
Wanda,Vision Gamora TChallaa Steve <br>
Tony,Pepper Bucky Peggy Sam <br>
Strange Nebula Loki Bruce Clint Carol <br>

The schedule for week 12<br>
Wanda,Vision Peggy Sam Strange <br>
Tony,Pepper Gamora TChallaa Steve <br>
Clint Loki Bruce Carol Nebula Bucky <br>

The schedule for week 13<br>
Carol Wanda,Vision Tony,Pepper <br>
Nebula Strange Loki Bruce Clint <br>
Bucky Gamora TChallaa Steve Peggy Sam <br>

The schedule for week 14<br>
Tony,Pepper Wanda,Vision Strange <br>
Loki Bucky Gamora TChallaa Steve <br>
Carol Bruce Clint Peggy Sam Nebula <br>

The schedule for week 15<br>
Nebula Carol Sam Wanda,Vision <br>
Bucky Tony,Pepper Strange Loki <br>
Gamora Bruce Clint TChallaa Steve Peggy <br>

The schedule for week 16<br>
Strange Wanda,Vision Tony,Pepper <br>
Loki Peggy Sam Bruce Clint <br>
Carol Nebula Bucky Gamora TChallaa Steve <br>

The schedule for week 17<br>
Strange Bucky Wanda,Vision Loki <br>
Bruce Tony,Pepper Gamora TChallaa <br>
Carol Clint Nebula Steve Peggy Sam <br>

The schedule for week 18<br>
Loki Strange Wanda,Vision Bruce <br>
Clint Tony,Pepper Gamora TChallaa <br>
Carol Nebula Bucky Steve Peggy Sam <br>

The schedule for week 19<br>
Bruce Wanda,Vision Loki Bucky <br>
Clint Strange Steve Peggy Sam <br>
Carol Tony,Pepper Nebula Gamora TChallaa <br>

The schedule for week 20<br>
Bruce Steve Peggy Sam Strange <br>
Clint Wanda,Vision Tony,Pepper <br>
Carol Loki Nebula Bucky Gamora TChallaa <br>

The schedule for week 21<br>
Carol Strange Wanda,Vision Loki <br>
Bucky Nebula Tony,Pepper Bruce <br>
Gamora Clint TChallaa Steve Peggy Sam <br>

The schedule for week 22<br>
Bucky Carol Wanda,Vision Strange <br>
Gamora Nebula Tony,Pepper Loki <br>
TChallaa Bruce Clint Steve Peggy Sam <br>

The schedule for week 23<br>
Gamora Bucky Wanda,Vision Strange <br>
TChallaa Tony,Pepper Loki Bruce <br>
Steve Clint Carol Nebula Peggy Sam <br>

The schedule for week 24<br>
TChallaa Bucky Gamora Wanda,Vision <br>
Steve Tony,Pepper Strange Loki <br>
Peggy Bruce Clint Carol Nebula Sam <br>

The schedule for week 25<br>
Steve Gamora TChallaa Wanda,Vision <br>
Peggy Tony,Pepper Strange Loki <br>
Sam Bruce Clint Carol Nebula Bucky <br>

The schedule for week 26<br>
Peggy TChallaa Steve Wanda,Vision <br>
Tony,Pepper Strange Loki Bruce Sam <br>
Clint Carol Nebula Bucky Gamora Peggy <br>

The schedule for week 27<br>
Sam Steve Peggy Wanda,Vision <br>
Tony,Pepper Strange Loki Bruce Sam <br>
Clint Carol Nebula Bucky Gamora Peggy <br>

The program is finish


<img src="image/group1results.png"
     alt="result" width="500px" heigth="1000px">


<h3>GROUP2.TXT</h3>


<h3>
Please input your plaintext file with the smallgroup names:<br>
group2.txt<br>
File name is:group2.txt<br>
[Peter,Melissa, Ann, Mark, George, Lisa, Jenny, Alma, Jerry, Albert, Joan, Harry, Peter, John, Matt, Carrie, Stephen, Bob, Riley, Oliva, Carly, Samantha, Zach, Bridget, Carl, Harold, Kate, Kim, Rachel]<br>
[2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]<br>
Please input the group size:<br>
9<br>

</h3>

The schedule for week 0<br>
Peter,Melissa Ann, Mark George Lisa Jenny Alma Jerry <br>
Albert Joan Harry Peter John Matt Carrie Stephen Bob Rachel <br>
Riley Oliva Carly Samantha Zach Bridget Carl Harold Kate Kim <br>

The schedule for week 1<br>
Oliva Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Carly Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Samantha Stephen Bob Riley Zach Bridget Carl Harold Kate Kim <br>

The schedule for week 2<br>
Zach Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Bridget Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Carl Stephen Bob Riley Oliva Carly Samantha Harold Kate Kim <br>

The schedule for week 3<br>
Harold Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Kate Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Kim Stephen Bob Riley Oliva Carly Samantha Zach Bridget Carl <br>

The schedule for week 4<br>
Rachel Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Jerry Albert Joan Harry Peter John Matt Carrie Stephen Kim <br>
Bob Riley Oliva Carly Samantha Zach Bridget Carl Harold Kate <br>

The schedule for week 5<br>
Riley Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Oliva Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Carly Stephen Bob Samantha Zach Bridget Carl Harold Kate Kim <br>

The schedule for week 6<br>
Samantha Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Zach Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Bridget Stephen Bob Riley Oliva Carly Carl Harold Kate Kim <br>

The schedule for week 7<br>
Carl Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Harold Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Kate Stephen Bob Riley Oliva Carly Samantha Zach Bridget Kim <br>

The schedule for week 8<br>
Kim Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Rachel Jerry Albert Joan Harry Peter John Matt Carrie Kate <br>
Stephen Bob Riley Oliva Carly Samantha Zach Bridget Carl Harold <br>

The schedule for week 9<br>
Bob Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Riley Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Oliva Stephen Carly Samantha Zach Bridget Carl Harold Kate Kim <br>

The schedule for week 10<br>
Carly Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Samantha Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Zach Stephen Bob Riley Oliva Bridget Carl Harold Kate Kim <br>

The schedule for week 11<br>
Bridget Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Carl Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Harold Stephen Bob Riley Oliva Carly Samantha Zach Kate Kim <br>

The schedule for week 12<br>
Kate Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Kim Jerry Albert Joan Harry Peter John Matt Carrie Harold <br>
Rachel Stephen Bob Riley Oliva Carly Samantha Zach Bridget Carl <br>

The schedule for week 13<br>
Peter,Melissa Albert Joan Harry Peter John Matt Carrie <br>
Ann, Mark George Lisa Jenny Alma Jerry Stephen Bob Rachel <br>
Riley Oliva Carly Samantha Zach Bridget Carl Harold Kate Kim <br>

The schedule for week 14<br>
Peter,Melissa Stephen Bob Riley Oliva Carly Samantha Zach <br>
Ann, Mark Albert Joan Harry Peter John Matt Carrie Rachel <br>
George Lisa Jenny Alma Jerry Bridget Carl Harold Kate Kim <br>

The schedule for week 15<br>
Lisa Peter,Melissa Ann, Mark George Jenny Alma Jerry <br>
Albert Riley Oliva Carly Samantha Zach Bridget Carl Harold Rachel <br>
Joan Harry Peter John Matt Carrie Stephen Bob Kate Kim <br>

The schedule for week 16<br>
Harry Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Peter Jerry Albert Joan John Matt Carrie Stephen Bob Rachel <br>
Riley Oliva Carly Samantha Zach Bridget Carl Harold Kate Kim <br>

The schedule for week 17<br>
Peter,Melissa Bridget Carl Harold Kate Kim Rachel George <br>
Lisa Albert Joan Harry Peter John Matt Carrie Stephen Zach <br>
Jenny Ann, Mark Alma Jerry Bob Riley Oliva Carly Samantha <br>

The schedule for week 18<br>
Alma Peter,Melissa Ann, Mark George Lisa Jenny Jerry <br>
Joan Albert Riley Oliva Carly Samantha Zach Bridget Carl Rachel <br>
Harry Peter John Matt Carrie Stephen Bob Harold Kate Kim <br>

The schedule for week 19<br>
Peter Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
John Jerry Albert Joan Harry Matt Carrie Stephen Bob Rachel <br>
Riley Oliva Carly Samantha Zach Bridget Carl Harold Kate Kim <br>

The schedule for week 20<br>
Ann, Mark Peter,Melissa Riley Oliva Carly Samantha Zach <br>
George Albert Joan Harry Peter John Matt Carrie Stephen Rachel <br>
Jerry Lisa Jenny Alma Bob Bridget Carl Harold Kate Kim <br>

The schedule for week 21<br>
Albert Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Joan Jerry Harold Harry Peter John Matt Carrie Stephen Rachel <br>
Riley Bob Oliva Carly Samantha Zach Bridget Carl Kate Kim <br>

The schedule for week 22<br>
Ann, Mark Bridget Carl Harold Kate Kim Peter,Melissa <br>
George Bob Riley Oliva Carly Samantha Zach Lisa Jenny Rachel <br>
Alma Albert Joan Harry Peter John Matt Carrie Stephen Jerry <br>

The schedule for week 23<br>
Jerry Peter,Melissa Ann, Mark George Riley Oliva Carly <br>
Albert Kate Kim Lisa Jenny Alma Joan Harry Peter Rachel <br>
Matt John Carrie Stephen Bob Samantha Zach Bridget Carl Harold <br>

The schedule for week 24<br>
Carrie Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Stephen Jerry Albert Joan Harry Peter John Matt Kate Rachel <br>
Riley Bob Oliva Carly Samantha Zach Bridget Carl Harold Kim <br>

The schedule for week 25<br>
George Peter,Melissa Ann, Mark Lisa Jenny Alma Jerry <br>
Albert Joan Harry Peter John Matt Carrie Stephen Bob Rachel <br>
Riley Oliva Carly Samantha Zach Bridget Carl Harold Kate Kim <br>

The schedule for week 26<br>
Lisa Bob Riley Oliva Carly Samantha Bridget Carl Harold <br>
Jenny Peter,Melissa George Albert Joan Harry Peter John Kim <br>
Jerry Zach Rachel Ann, Mark Alma Matt Carrie Stephen Kate <br>

The schedule for week 27<br>
Lisa Kate Kim Rachel Peter,Melissa Ann, Mark George <br>
Alma Bob Riley Oliva Carly Samantha Zach Bridget Carl Harold <br>
Jerry Jenny Albert Joan Harry Peter John Matt Carrie Stephen <br>

The schedule for week 28<br>
Jenny Lisa Matt Carrie Stephen Zach Bridget Carl Harold <br>
Alma Kate Kim Rachel Peter,Melissa Ann, Mark George Carly <br>
Jerry Samantha Albert Joan Harry Peter John Bob Riley Oliva <br>

The schedule for week 29<br>
Jenny Kate Rachel Peter,Melissa Ann, Mark George Lisa <br>
Albert Jerry Alma Joan Harry Peter John Matt Carrie Harold <br>
Stephen Kim Bob Riley Oliva Carly Samantha Zach Bridget Carl <br>

The schedule for week 30<br>
Joan Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Harry Jerry Albert Riley Oliva Carly Samantha Zach Bridget Rachel <br>
Carrie Peter John Matt Stephen Bob Carl Harold Kate Kim <br>

The schedule for week 31<br>
Stephen Peter,Melissa Ann, Mark George Lisa Jenny Alma <br>
Bob Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Riley Oliva Carly Samantha Zach Bridget Carl Harold Kate Kim <br>

The schedule for week 32<br>
Harry Joan Carl Peter,Melissa Ann, Mark George Lisa <br>
Peter Riley Oliva Carly Samantha Zach Bridget Harold Kate Rachel <br>
Stephen Carrie Jenny Alma Jerry Albert John Matt Bob Kim <br>

The schedule for week 33<br>
Peter Harry Carl Kim Peter,Melissa Ann, Mark George <br>
John Lisa Jenny Alma Riley Oliva Carly Samantha Zach Rachel <br>
Bob Stephen Jerry Albert Joan Matt Carrie Bridget Harold Kate <br>

The schedule for week 34<br>
John Peter,Melissa Ann, Mark George Peter Bridget Carl <br>
Matt Lisa Jenny Alma Jerry Albert Joan Harry Riley Rachel <br>
Bob Kim Carrie Stephen Oliva Carly Samantha Zach Harold Kate <br>

The schedule for week 35<br>
John Harold Kate Kim Peter,Melissa Ann, Mark George <br>
Matt Peter Oliva Carly Lisa Jenny Alma Jerry Albert Rachel <br>
Riley Stephen Joan Harry Carrie Bob Samantha Zach Bridget Carl <br>

The schedule for week 36<br>
Matt Peter,Melissa Ann, Mark George Kate Kim Lisa <br>
Carrie Jerry Albert Joan Harry Riley Oliva Carly Samantha Rachel <br>
Zach Jenny Alma Peter John Stephen Bob Bridget Carl Harold <br>

The schedule for week 37<br>
Carrie Zach Bridget Peter,Melissa Ann, Mark George Lisa <br>
Oliva Bob Riley Jenny Alma Jerry Albert Joan Harry Rachel <br>
Carly Peter John Matt Stephen Samantha Carl Harold Kate Kim <br>

The schedule for week 38<br>
Carly Riley Oliva Peter,Melissa Ann, Mark George Lisa <br>
Samantha Jenny Alma Jerry Albert Joan Harry Peter John Rachel <br>
Zach Matt Carrie Stephen Bob Bridget Carl Harold Kate Kim <br>

The schedule for week 39<br>
Samantha Oliva Carly Peter,Melissa Ann, Mark George Lisa <br>
Zach Jenny Alma Jerry Albert Joan Harry Peter John Rachel <br>
Bridget Matt Carrie Stephen Bob Riley Carl Harold Kate Kim <br>

The schedule for week 40<br>
Zach Carly Samantha Peter,Melissa Ann, Mark George Lisa <br>
Bridget Jenny Alma Jerry Albert Joan Harry Peter John Rachel <br>
Carl Matt Carrie Stephen Bob Riley Oliva Harold Kate Kim <br>

The schedule for week 41<br>
Bridget Samantha Zach Peter,Melissa Ann, Mark George Lisa <br>
Carl Jenny Alma Jerry Albert Joan Harry Peter John Rachel <br>
Harold Matt Carrie Stephen Bob Riley Oliva Carly Kate Kim <br>

The schedule for week 42<br>
Carl Zach Bridget Peter,Melissa Ann, Mark George Lisa <br>
Harold Jenny Alma Jerry Albert Joan Harry Peter John Rachel <br>
Kate Matt Carrie Stephen Bob Riley Oliva Carly Samantha Kim <br>

The schedule for week 43<br>
Harold Bridget Carl Peter,Melissa Ann, Mark George Lisa <br>
Kate Jenny Alma Jerry Albert Joan Harry Peter John Zach <br>
Kim Rachel Matt Carrie Stephen Bob Riley Oliva Carly Samantha <br>

The schedule for week 44<br>
Kate Carl Harold Peter,Melissa Ann, Mark George Lisa <br>
Kim Jenny Alma Jerry Albert Joan Harry Peter John Bridget <br>
Rachel Matt Carrie Stephen Bob Riley Oliva Carly Samantha Zach <br>

The schedule for week 45<br>
Kim Kate Peter,Melissa Ann, Mark George Lisa Jenny <br>
Alma Jerry Albert Joan Harry Peter John Matt Carrie Rachel <br>
Stephen Bob Riley Oliva Carly Samantha Zach Bridget Carl Harold <br>

The schedule for week 46<br>
Rachel Harold Kim Peter,Melissa Ann, Mark George Lisa <br>
Jenny Alma Jerry Albert Joan Harry Peter John Matt Kate <br>
Carrie Stephen Bob Riley Oliva Carly Samantha Zach Bridget Carl <br>

The program is finish

<img src="image/group2results.png"
     alt="result" width="500px" heigth="1000px">

<h3>GROUP3.TXT</h3>

<h3>
Please input your plaintext file with the smallgroup names:<br>
group3.txt<br>
File name is:group3.txt<br>
[Nathan,Brianna, Pat,Heidi, Sara,Doug, Sean, Jack, Donald, Mary, Pamela, Kathleen, Andrew, Paul, Bella, Christine, Greg, Joe, Samuel, Sadie, Kendal, Emma, Austin, Grace, Blake, Ethan, Sabrina, Jay, Scott, David, Bryan, Cheryl, Eli, Katrina]<br>
[2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]<br>
Please input the group size:<br>
13<br>

</h3>

The schedule for week 0<br>
Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Andrew Jay David Cheryl Katrina <br>
Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 1<br>
Bella Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Christine Andrew Paul Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 2<br>
Greg Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Joe Andrew Paul Bella Christine Samuel Sadie Kendal Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 3<br>
Samuel Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Sadie Andrew Paul Bella Christine Greg Joe Kendal Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 4<br>
Kendal Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Emma Andrew Paul Bella Christine Greg Joe Samuel Sadie Austin Grace Blake Ethan Sabrina <br>

The schedule for week 5<br>
Austin Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Grace Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Blake Ethan Sabrina <br>

The schedule for week 6<br>
Blake Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Ethan Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Sabrina <br>

The schedule for week 7<br>
Sabrina Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Ethan David Cheryl Katrina <br>
Jay Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake <br>

The schedule for week 8<br>
Scott Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Ethan Jay Cheryl Katrina <br>
David Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake <br>

The schedule for week 9<br>
Bryan Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Ethan Jay David Katrina <br>
Cheryl Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake <br>

The schedule for week 10<br>
Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Ethan Jay David Cheryl <br>
Katrina Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake <br>

The schedule for week 11<br>
Nathan,Brianna Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Jay David <br>
Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Andrew Blake Ethan Sabrina Scott Bryan <br>

The schedule for week 12<br>
Sara,Doug Nathan,Brianna Pat,Heidi Sean Jack Donald Mary Pamela Kathleen Andrew Jay David Cheryl Katrina <br>
Bella Paul Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 13<br>
Christine Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Greg Andrew Paul Bella Joe Samuel Sadie Kendal Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 14<br>
Joe Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Samuel Andrew Paul Bella Christine Greg Sadie Kendal Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 15<br>
Sadie Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Kendal Andrew Paul Bella Christine Greg Joe Samuel Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 16<br>
Emma Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Austin Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Grace Blake Ethan Sabrina <br>

The schedule for week 17<br>
Grace Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Blake Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Ethan Sabrina <br>

The schedule for week 18<br>
Ethan Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Jay David Cheryl Katrina <br>
Sabrina Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake <br>

The schedule for week 19<br>
Jay Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Ethan David Cheryl Katrina <br>
Scott Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake <br>

The schedule for week 20<br>
David Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Ethan Jay Cheryl Katrina<br> 
Bryan Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake <br>

The schedule for week 21<br>
Cheryl Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Ethan Jay David Katrina <br>
Eli Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake <br>

The schedule for week 22<br>
Katrina Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Sabrina Scott Bryan Eli <br>
Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake Ethan <br>

The schedule for week 23<br>
Paul Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Blake Sabrina David Katrina <br>
Bella Andrew Scott Bryan Eli Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace <br>

The schedule for week 24<br>
Nathan,Brianna Blake Ethan Sabrina Scott Bryan Eli Pat,Heidi Sara,Doug Sean Emma Grace David Katrina <br>
Jack Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal <br>

The schedule for week 25<br>
Donald Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Mary Pamela Kathleen Andrew Austin Blake Sabrina Katrina <br>
Paul Jay Scott Bryan Cheryl Eli Bella Christine Greg Joe Samuel Sadie Kendal Emma <br>

The schedule for week 26<br>
Pat,Heidi Nathan,Brianna Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Jay David Cheryl <br>
Sean Sara,Doug Jack Donald Mary Pamela Kathleen Andrew Austin Grace Blake Ethan Sabrina Scott <br>

The schedule for week 27<br>
Jack Nathan,Brianna Pat,Heidi Sara,Doug Sean Emma Austin Grace Blake Ethan Pamela Andrew Cheryl Katrina <br>
Donald Paul Bella Christine Greg Joe Samuel Sadie Kendal Jay Scott David Bryan Mary <br>

The schedule for week 28<br>
Mary Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Pamela Kathleen Andrew Jay David Cheryl Katrina <br>
Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 29<br>
Pat,Heidi Austin Grace Eli Katrina Nathan,Brianna Sara,Doug Sean Jack Donald Kathleen Jay David Cheryl <br>
Mary Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Blake Ethan Sabrina Pamela <br>

The schedule for week 30<br>
Pamela Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Kathleen Andrew Jay David Cheryl Katrina <br>
Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake Ethan Sabrina <br>

The schedule for week 31<br>
Sara,Doug Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Pamela Andrew <br>
Jack Sabrina Jay Scott David Bryan Eli Nathan,Brianna Pat,Heidi Sean Donald Mary Kathleen Blake <br>

The schedule for week 32<br>
Sara,Doug Blake Ethan Sabrina Scott Bryan Eli Nathan,Brianna Pat,Heidi Sean Samuel Kendal Jay Katrina <br>
Donald Emma Grace Cheryl Jack Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe <br>

The schedule for week 33<br>
Sean Nathan,Brianna Pat,Heidi Paul Bella Christine Greg Joe Samuel Sadie Kendal Sabrina Scott Bryan <br>
Donald Ethan Eli Sara,Doug Jack Mary Pamela Kathleen Andrew Emma Austin Grace Blake Jay <br>

The schedule for week 34<br>
Sean Emma Jay David Cheryl Eli Katrina Nathan,Brianna Pat,Heidi Sara,Doug Joe Sadie Blake Sabrina <br>
Mary Austin Grace Scott Bryan Jack Donald Pamela Kathleen Andrew Paul Bella Christine Greg <br>

The schedule for week 35<br>
Mary Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Pamela Kathleen Sabrina Scott Bryan Katrina <br>
Paul Andrew Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake Ethan <br>

The schedule for week 36<br>
Pamela Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake Jay <br>
Kathleen Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Andrew Ethan Sabrina Scott Bryan Eli <br>

The schedule for week 37<br>
Andrew Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Kathleen Blake Sabrina David Katrina <br>
Christine Bella Scott Bryan Eli Paul Greg Joe Samuel Sadie Kendal Emma Austin Grace <br>

The schedule for week 38<br>
Pamela Ethan Sabrina Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Donald Andrew David Katrina <br>
Kathleen Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake Jack <br>

The schedule for week 39<br>
Andrew Jay Scott Bryan Cheryl Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Austin Blake Sabrina Katrina <br>
Greg Christine Jack Donald Mary Pamela Kathleen Paul Bella Joe Samuel Sadie Kendal Emma <br>

The schedule for week 40<br>
Kathleen Pamela Jay David Cheryl Katrina Nathan,Brianna Pat,Heidi Sara,Doug Sean Kendal Austin Blake Sabrina <br>
Greg Scott Bryan Eli Jack Donald Mary Andrew Paul Bella Christine Joe Samuel Sadie <br>

The schedule for week 41<br>
Joe Greg Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Blake Sabrina David Katrina <br>
Samuel Donald Mary Pamela Kathleen Andrew Paul Bella Christine Sadie Kendal Emma Austin Grace <br>

The schedule for week 42<br>
Samuel Joe Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Blake Sabrina David Katrina <br>
Sadie Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Kendal Emma Austin Grace <br>

The schedule for week 43<br>
Sadie Samuel Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Blake Sabrina David Katrina <br>
Kendal Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Emma Austin Grace <br>

The schedule for week 44<br>
Kendal Sadie Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Blake Sabrina David Katrina <br>
Emma Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Austin Grace <br>

The schedule for week 45<br>
Emma Kendal Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Blake Sabrina David Katrina <br>
Austin Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Grace <br>

The schedule for week 46<br>
Austin Emma Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Blake Sabrina David Katrina <br>
Grace Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal <br>

The schedule for week 47<br>
Grace Austin Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Emma Sabrina David Katrina <br>
Blake Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal <br>

The schedule for week 48<br>
Blake Grace Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Emma Sabrina David Katrina <br>
Ethan Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal <br>

The schedule for week 49<br>
Ethan Blake Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Kendal Austin David Katrina <br>
Sabrina Jay Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie <br>

The schedule for week 50<br>
Sabrina Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Austin Blake David Katrina <br>
Jay Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma <br>

The schedule for week 51<br>
Jay Sabrina Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Emma Grace Ethan Katrina <br>
David Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal <br>

The schedule for week 52<br>
Scott Sabrina David Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Emma Grace Ethan Katrina <br>
Cheryl Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal <br>

The schedule for week 53<br>
David Sabrina Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Emma Grace Ethan Katrina <br>
Cheryl Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal <br>

The schedule for week 54<br>
Bryan Sabrina Scott Cheryl Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Samuel Kendal Austin Blake <br>
Katrina Ethan Jay David Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe <br>

The schedule for week 55<br>
Cheryl Sabrina Scott Bryan Eli Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Emma Grace Ethan David <br>
Katrina Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal <br>

The schedule for week 56<br>
Eli Sabrina Scott Bryan Katrina Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Austin Blake Jay Cheryl <br>
Donald Mary Pamela Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma <br>

The schedule for week 57<br>
Katrina Cheryl Nathan,Brianna Pat,Heidi Sara,Doug Sean Jack Donald Mary Pamela Ethan Jay David Eli <br>
Kathleen Andrew Paul Bella Christine Greg Joe Samuel Sadie Kendal Emma Austin Grace Blake <br>

The program is finish     


<img src="image/group3results.png"
     alt="result" width="500px" heigth="1000px">
