import java.util.Scanner;
import java.util.concurrent.*;

/*
    Author: Alexis Chiu
    Date: Finished on 05-10-2023
    This is Lab 3.1 Adventure Time. In this game, the user will play an escape room in an attempt to escape.

 */

public class TextBasedGame {
    public static Scanner scanner = new Scanner (System.in);
    public static int roomOneAnswer;
    public static String username = scanner.nextLine();

    public static void main(String[] args){
        System.out.println("Welcome to the ESCAPE ROOM!" );
        System.out.println("Please enter a name to continue: ");
        username = scanner.nextLine();
        creatingProfile(username);
        clearScreen();
        rulesOfGame(username);
        roomOneMathQuestion();
        determineRoom2();
    }

    //Creating the user's profile for the game
    public static void creatingProfile(String username){
        System.out.println("I see " + username + ". Why don't I give you a chance to make a profile, just in case you don't make it out alive...");
        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Now enter your preferred nickname/username: ");
        String nickname = scanner.nextLine();
        System.out.println("What about your favourite food? ");
        String faveFood = scanner.nextLine();
        System.out.println("And maybe your favourite color?: ");
        String faveColour = scanner.nextLine();
        System.out.println("\nWell This is your profile, why don't you tell me how it looks?\nName:" + username + "\nPreferred Nickname:" + nickname + "\nAge:" + age + "\nFavourite Food: " + faveFood + "\nFavourite Color: " + faveColour);
        System.out.println("How does that look?...\nPress [1] to confirm your choices, press [2] to redo the profile.");
        int profileConfirmation = scanner.nextInt();
        while(profileConfirmation == 2){
            System.out.println("Alright " + username + ".");
            System.out.println("Please enter your age: ");
            age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Now enter your preferred nickname/username: ");
            nickname = scanner.nextLine();
            System.out.println("What about your favourite food? ");
            faveFood = scanner.nextLine();
            System.out.println("And maybe your favourite color?: ");
            faveColour = scanner.nextLine();
            System.out.println("\nWell This is your profile, why don't you tell me how it looks?\nName:" + username + "\nPreferred Nickname:" + nickname + "\nAge:" + age + "\nFavourite Food: " + faveFood + "\nFavourite Color: " + faveColour);
            System.out.println("How does that look?...\nPress [1] to confirm your choices, press [2] to redo the profile.");
            profileConfirmation = scanner.nextInt();
        }
    }

    //These are the rules of this game
    public static void rulesOfGame(String username){
        System.out.println("Now " + username + ", you have started the escape room. Lets review some instructions of the game");
        System.out.println("In each room you enter, there is a question. You will get a certain amount of time to answer the question. Each question leads you to a different room. Theres only one correct route, others will eventually lead you to death.");
        System.out.println("The instructions are simple, solve the answer and input your answer.");
        System.out.println("Are you ready to being your journey? Press [1] to confirm your fate.");
        scanner.nextInt();

    }

    //First room --> math question
    public static void roomOneMathQuestion(){
        System.out.println("Welcome to room 1... Your fate relies on the choice you make here...");
        System.out.println("A shop sells bicycles and tricycles. In total there are 7 cycles (cycles include both bicycles and tricycles) and 19 wheels. Determine how many of each there are, if a bicycle has two wheels and a tricycle has three wheels.");
        System.out.println("""
                Answers:
                Room 1: 3 bicycles and 5 tricycles
                Room 2: 5 bicycles and 2 tricycles
                Room 3: 2 bicycles and 5 tricycles
                Room 4: 5 bicycles and 3 tricycles
                Enter your answer:\s""");
        roomOneAnswer = scanner.nextInt();
        System.out.println("Your current answer is: " + roomOneAnswer + ". Are you sure? If yes, press [1] if no, press [2]");
        int room1AnswerConformation = scanner.nextInt();
        while(room1AnswerConformation == 2) {
            System.out.println("What is your new answer?");
            roomOneAnswer = scanner.nextInt();
            System.out.println("Your new answer is: " + roomOneAnswer + "Is this Alright. Press [1] for yes and [2] for no");
            room1AnswerConformation = scanner.nextInt();
        }
    }

    //Based on the answer that the user chose for Room 1, this will determine the next room
    public static void determineRoom2(){
        if (roomOneAnswer == 1){
            if(roomTwoFirstChoice() == true){
                roomThreeChoiceOne();
            }
            else {
                System.out.println("Oh no.... You've entered Room 3 and theres shadow in the corner? Oh wait, its just Grace!");
                System.out.println("But...\n She's holding a knife in her hands...");
                System.out.println("Rest in Pieces.");
                System.exit(1);
            }
        }
        if(roomOneAnswer == 2)
        {
            roomTwoSecondChoice();
        }
        if(roomOneAnswer ==3){ //correct answer to previous question
            roomTwoThirdChoice();
        }
        if(roomOneAnswer == 4){
            roomTwoFourthChoice();

        }
    }
     //If the user chose 1 as the answer, this will be the second room
    public static boolean roomTwoFirstChoice(){
        System.out.println("Welcome to Room 2. I guess you've survived the first room...");
        System.out.println("Now now, why don't you give me two factors of 20");
        System.out.println("First Number: ");
        int room2Result1 = scanner.nextInt();
        System.out.println("Second Number: ");
        int room2Result2 = scanner.nextInt();
        int room2Result = room2Result1 * room2Result2;
        if(room2Result == 20){
            return true;
        }
        else {
            return false;
        }
    }

    //If the user chose 2 as the answer, this will be the second room
    public static void roomTwoSecondChoice(){
        System.out.println("Welcome to Room 2. I guess you've survived the first room... There are now four doors in front of you. Choose wisely, only one will make it.");
        System.out.println("Solve this riddle: All about, but cannot be seen. Can be captured, cannot be held. No throat, but can be heard. Who am I?....");
        System.out.println("The four rooms are:\n1. Fire\n2. Water\n3.Wind\n4.Air\nTake Your Pick: ");
        int roomTwoTwoResults = scanner.nextInt();
        if (roomTwoTwoResults == 1){
            System.out.println("You walk into the next room, everything seems fine...");
            System.out.println("Theres something shiny on the floor, it seems like its just oil, you'll be fine!");
            System.out.println("Will you?...");
            try{
                Thread.sleep(1000);
            } catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            System.out.println("The light fell down and the oil caught on fire! The whole room is burning");
            System.exit(1);
        }
        if(roomTwoTwoResults == 2){
            System.out.println("Oh, whats that there?...");
            try{
                Thread.sleep(1000);
            } catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            System.out.println("Oh no!! A flood is coming at you, you're going to drown!");
            System.out.println("I guess you drowned...");
            System.exit(1);
        }
        if (roomTwoTwoResults == 3) {
            roomThreeMathQuestionOne(username);

        }
        if(roomTwoTwoResults == 4){
            System.out.println("Are you kidding me... Air can't even be heard...I'm disappointed...so I'm personally sending in Grace the murderer");
            System.out.println("Rest in Pieces.");
            System.exit(1);
        }
    }

    //If the user chose 3 (which is the correct answer), this will be the second room
    public static boolean roomTwoThirdChoice(){
        System.out.println("Welcome to Room 2. I guess you've survived the first room... Theres a door in front of you... theres also a piece of paper on the floor");
        System.out.println("You pick up the paper, it says \"R B E A D S\"");
        System.out.println("Unscramble the word to get into the next room. However, theres a ticking bomb... hurry up!");
        System.out.println("Enter your answer: ");
        try{
            String roomTwoUnscrambleAnswer = CompletableFuture.supplyAsync(scanner::nextLine)
                .get(60L, TimeUnit.SECONDS);
            System.out.println("Your answer is: " + roomTwoUnscrambleAnswer);
            if (roomTwoUnscrambleAnswer.equalsIgnoreCase("Breads")) {
                return true;
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("It seems that your time has ran out, goodbye.");}
        return false;
    }

    //If the user chose 4 as the answer, this will be room 2
    public static void roomTwoFourthChoice(){
        ThreadLocalRandom.current().nextInt();
        int number;
        System.out.println("Oh, theres a green door?... Is that the exit?!");
        number = ThreadLocalRandom.current().nextInt(0, 20);
        System.out.println("You walk closer to the door, theres a number " + number + " on it");
        System.out.println("Your task is to enter a number which has " + number + " as a factor");
        System.out.println("What is your answer: ");
        int roomOneFourthChoice = scanner.nextInt();
        if(roomOneFourthChoice%number == 0){
            roomThreeChoiceTwo();
        }
        else{
            System.out.println("Moral of the story: You should've checked your answer before you submitted it. Bye.");
            System.exit(1);
        }

    }

    //If the user went into the first Room2 option, this will be the third room
    public static void roomThreeChoiceOne(){
        System.out.println("Congrats, you made it to room three. Its outdoors, thats weird... \nHmm... theres a grey horse standing there??");
        System.out.println("Theres a piece of paper on its saddle, it says \"This is Banjo, you must get onto him and ride to the pitstop on the other side of the field.\"");
        System.out.println("So you get on and ride...");
        try{
            Thread.sleep(2000);
        } catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("But is there even a pitstop....?");
        System.out.println("Oh look, theres a flag over there, it must be the pitstop!");
        System.out.println("OOPS! Banjo got scared of the flag and decked you off! Oh well, I guess you can't really get there now... I'll call an ambulance for you I guess...");
        System.exit(1);
    }

    //If the user went into the second Room2 and picked 3 (the correct answer) this will be room 3
    public static void roomThreeMathQuestionOne(String username){
        System.out.println("Well well... welcome to Room 3, I'm surprised you made it this far...");
        System.out.println("Theres a door, its green, it looks like the exit...but theres a code you need to solve on the door...");
        int number = ThreadLocalRandom.current().nextInt(0, 20);
        int number2 = ThreadLocalRandom.current().nextInt(0, 20);
        int number3 = ThreadLocalRandom.current().nextInt(0, 20);
        System.out.println("It says to solve: (" + number + " + " + number2 + ") /" + number3 + ".");
        try{
            double roomThreeMathQuestionAnswer = CompletableFuture.supplyAsync(scanner::nextDouble)
                    .get(120L, TimeUnit.SECONDS);
            System.out.println("You have 2 minutes to provide an answer: ");
            if (roomThreeMathQuestionAnswer == (number + number2)/number3) {
                System.out.println("Congratulations" + username + ", you made it out of the escape room!");
                System.exit(0);
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("It seems that your time has ran out, goodbye.");}
    }

    //If the user went into the fourth room2 and answered the question correctly, this will be the third room
    public static void roomThreeChoiceTwo(){
        System.out.println("Well well... you;ve made it to Room 3, I'm surprised you made it this far...");
        int number = ThreadLocalRandom.current().nextInt(0, 20);
        int number2 = ThreadLocalRandom.current().nextInt(0, 20);
        System.out.println("Now... You need to give me a number that is less than " + number + " but also more than " + number2);
        try{
            int roomThreeChoiceTwoAnswer = CompletableFuture.supplyAsync(scanner::nextInt)
                    .get(120L, TimeUnit.SECONDS);
            System.out.println("You have 2 minutes to provide an answer: ");
            if (roomThreeChoiceTwoAnswer>number2 && roomThreeChoiceTwoAnswer<number) {
                System.out.println("Congratulations" + username + ", you made it out of the escape room!");
                System.exit(0);
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("It seems that your time has ran out, goodbye.");}
    }

    public static void clearScreen(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }




}