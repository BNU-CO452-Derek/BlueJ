# Objects First with Java: BlueJ version 6
Contains all the separate BlueJ projects that will be used in CO452 2020 in a single repository
These versions are model answers to the independant study questions.  The projects are listed below.
## App01 LabClass
### Task 1: Testing
* Test App01 the LabClass project by creating a new LabClass called co452Lab and enrolling three new Students.  This LabClass will be held on Tuesday 29th September 2020 in room G100 taken by instructor Nicholas Day.
* Also test that the students can be updated with 20 credits,  and that a student name could be updated to correct a spelling mistake for example. 
* Document your testing by selecting View ->  Show Terminal in BlueJ and then Select Options -> Record Method Calls.  When the testing is complete save to a txt file as LabClassTests.txt
### Task 2: Extensions
* Create a new class called Course which contains a code number and a title, e.g. G400, Computing.
* Add a new field to the Student class for Course and a method to add a course to a student.
* Modify the Student.print() method so that it prints out the student’s course.
* Test that it works
## App02 TicketMachine
### Requirements
Take a copy of the better-ticket-machine as a starting point and make it more realistic by offering tickets to three local stations
1. Aylesbury costing £2.20
2. Amersham costing £3.00
3. High Wycombe costing £3.30</br>

Each ticket should have a destination, a cost and the date purchased.  
Add methods to the TicketMachine so that a user can insert 10p, 20, £1.00 and £2.00 coins.  
After each coin is inserted the machine should display the amount entered and the current balance.
### Testing
Create a TicketMachine and use it to purchase all three tickets.  Make sure that your tests include trying to purchase a ticket with too little money inserted, and also with too much money inserted.  Show that excess money can be refunded.  Use the terminal window to record your tests.
### Useful Java Concepts
YOU CAN GET A FIRST CLASS MARK (80%) FOR FUNCTIONALITY WITHOUT USING THE CONCEPTS BELOW IN App02.  However the following concepts are a better way of implementing some of the TicketMachine's functionality, and if used will gain you a further 20%.
#### Constants
Whenever you have values in a program that are not going to be changed, it is better if they are defined as constants, in Java that can be done by defining them as **static final**
~~~
  public static final Ticket AYLESBURY_TICKET = new Ticket("Aylesbury", 200);
~~~
This concept is not introduced until Chapter 5 in BlueJ, and you can use a variable instead.  In the next Chapter 3 they use literals, 60 and 24.  Although in this case they may be instantly recognised, constants like MINUTES_IN_HOUR and HOURS_IN_DAY make the program clearer and easier to read.
#### Dates
There is a Date data type in Java in the java.util package which can be used as shown below, but for simplicity you can simply use a String e.g. "15/Sep/2020" as this concepts is not covered in BlueJ.
~~~
    import java.util.Date;
    ...
    private Date today = new Date();
~~~
By creating a new date, the variable will contain today's date.
In order to print out a date in the correct local date form you will need a SimpleDateFormat
~~~
    import java.text.SimpleDateFormat;
    ...
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
    ...
    String date = formatter.format(currentTicket.getDate());
~~~
#### Enumerations
Whenever you have a piece of data that only has a limited range of values, an enumeration is the best way to go.  So for example you could define Coin as where P10 has a value of 10
~~~
    public enum Coin
    {
        P10 (10),
        P20 (20),
        P100 (100),
        P200 (200);

        private final int value;

        private Coin(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
     }
~~~
This concept is introduced in Chpater 6 of BlueJ
## App03 24HourClock
## App04
## Appo5

