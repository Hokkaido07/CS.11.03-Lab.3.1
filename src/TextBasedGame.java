import java.util.Scanner;
import java.util.Random;
public class TextBasedGame {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static String[] items = {"Grass", "Real Knife", "Yoshi Plushie", "Gold Locket"};

    public static void main(String[] args) {
        //Ask for user's username
        System.out.print("What is your name?");
        String username = scanner.nextLine();
        System.out.println("So it's " + username + "? Hmm... Interesting.\nPress [Enter] to proceed.\n");
        scanner.nextLine();
        //Story Background
        storyBackground(username);
        //The Game
        doorsGame(username);
        scanner.close();
    }

    //storyBackground
    public static void storyBackground(String username) {
        System.out.println("...Wake up " + username + ". You're late for class!");
        scanner.nextLine();
        System.out.println("But don't panic. One of the doors will eventually lead to your classroom.");
        scanner.nextLine();
        System.out.println("There may be surprises behind each door. But be careful, not all are pleasing to encounter!");
        scanner.nextLine();
        System.out.println("It's a game of chance, and don't be late to class! Good luck! :)");
        scanner.nextLine();
        System.out.print("Press [Enter] to proceed.");
        scanner.nextLine();
    }

    public static void doorsGame(String username) {
        //Starting variables
        int doorsOpened = 0;
        boolean hasGoldLocket = false;
        boolean hasRealKnife = false;
        //Main game
        String item = randomItem();
        System.out.println("\nYou scanned the room and found: " + item + ".");
        System.out.print("Enter '1' to use the item, or press [Enter] to dispose the item and proceed: ");
        String useItem = scanner.nextLine();
        if (useItem.equals("1")) {
            if (item.equals("Grass")) {
                System.out.println("\nYou touched grass, and died instantly! Oh well, better luck next time :')");
                System.out.println("GAME OVER. Don't give up just yet!");
                return;
            }
            else if (item.equals("Real Knife")){
                System.out.println("\nYou used the Real Knife. Hopefully you won't encounter any Killers on your way to class.");
                hasRealKnife = true;
            }
            else if (item.equals("Yoshi Plushie")) {
                System.out.println("\nYou used the Yoshi Plushie and teleported directly to class on time! Don't oversleep next time :)");
                System.out.println("The End! You did it!");
                return;
            }
            else {
                System.out.println("\nYou used the Gold Locket! Hopefully nothing will happen to you in the next room!");
                hasGoldLocket = true;
            }
        }
        System.out.print("\n...A door lies before you. "+username+", please press [Enter] to proceed.");
        scanner.nextLine();
        String event = randomEvent();
        System.out.println("\nEvent: "+event);
            if ((event.equals("Drowning") || event.equals("Suffocation")) && !hasGoldLocket) {
                System.out.println("\nIt's hard to breathe, isn't it?");
                scanner.nextLine();
                System.out.println("Well, it looks like you're never gonna get to class! Farewell, " + username);
                scanner.nextLine();
                System.out.println("GAME OVER. Don't give up just yet!");
                return;
            }
            else if (event.equals("Burning") && !hasGoldLocket) {
                System.out.println("\nIt's getting a bit hot, isn't it?");
                scanner.nextLine();
                System.out.println("...You ask why?");
                scanner.nextLine();
                System.out.println("That's because you're on fire!");
                scanner.nextLine();
                System.out.println("You can't go to class if you're reduced to ashes. Farewell, " + username);
                scanner.nextLine();
                System.out.println("GAME OVER. Don't give up just yet!");
                return;
            }
            else if (event.equals("Alexis the Killer")) {
                if(hasRealKnife||hasGoldLocket){
                   fightAlexis(username, hasGoldLocket);
                   return;
                }
                else{
                    noRealKnife(username);
                    return;
                }
            }
            else if(event.equals("Nothing") && !hasGoldLocket){
                System.out.println("\nNothing happened.");
            }
            else{
            System.out.println("\nThe Golden Locket cracked. Seems like it can't be used anymore.");
            }
            doorsOpened++;
            if (doorsOpened == 1) {
                System.out.println("\nCongratulations! You successfully went to class on time!");
                System.out.println("The End! You did it!");
            }
    }
    public static void fightAlexis(String username, Boolean hasGoldLocket){
        //Player and Alexis stats
        int[] userHP={50};
        int[] enemyHP= new int[]{randomHP()};

        //Dialogue
        System.out.println("\nUh oh, that looks like Alexis the Killer!");
        scanner.nextLine();
        System.out.println(username+", it looks like you're in a battle! Good luck.");
        scanner.nextLine();

        //Fight
        boolean battleStatus=true;
        while(true){
            System.out.println("\n"+username+"'s HP: "+userHP[0]);
            System.out.println("Alexis's HP: "+enemyHP[0]);
            System.out.println("\nIt's your turn first!");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Run");
            System.out.println("4. Drink a Potion");
            System.out.print("Enter your choice: ");

            //Read user input
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (userHP[0] <= 0) {
                System.out.println("\n"+username + " has been defeated by Alexis the Killer.");
                scanner.nextLine();
                System.out.println("GAME OVER. Don't give up just yet!");
                return;
            }
            else if
            (enemyHP[0] <= 0) {
                System.out.println("\n...It seems that you've finally defeated Alexis.");
                scanner.nextLine();
                System.out.println("It's been a long day, hasn't it?");
                scanner.nextLine();
                System.out.println("Why don't you just take a break for today? I'm sure your teacher wouldn't mind.");
                scanner.nextLine();
                System.out.println("Congratulations! "+username+" has reached the True Ending.");
                scanner.nextLine();
                System.out.println("...and this is indeed, The End :)");
                scanner.nextLine();
                return;
            }
            if(choice==1){
                playerAttack(username, enemyHP, userHP);
            }
            else if(choice==2){
                playerDefend(username, userHP);
            }
            else if(choice==3){
                playerRun(username, hasGoldLocket, battleStatus);
                return;
            }
            else{
                playerDrinkPotion(username);
            }
        }
    }
    public static void playerAttack(String username, int[] enemyHP, int[] userHP){
        //Player's Attack
        int playerDamage = random.nextInt(10) + 1;
        enemyHP[0] -= playerDamage;
        System.out.println("\n"+username+" attacks Alexis and deals " +playerDamage+ " damage.");
        System.out.println("Alexis now has "+enemyHP[0]+" left.");

        //Enemy's Attack
        if (enemyHP[0] > 0) {
            int enemyDamage = random.nextInt(5) + 1;
            userHP[0] -= enemyDamage;
            System.out.println("Alexis attacks " + username + " and deals " + enemyDamage + " damage.");
            System.out.println("You now have "+userHP[0]+" left.");
        }
    }
    public static void playerDefend(String username, int[] userHP){
        //Player's Defense
        int playerDefense = random.nextInt(5) + 1;
        //Enemy's Attack
        int enemyDamage = random.nextInt(5) + 1 - playerDefense;
        if (enemyDamage<0) {
            enemyDamage=0;
        }
        userHP[0] -= enemyDamage;
        //Dialogue
        System.out.println("\n"+username+" defends and reduces Alexis's damage by " +playerDefense);
        System.out.println("Alexis attacks " + username + " and deals " + enemyDamage + " damage.");
        System.out.println("You now have "+userHP[0]+" left.");
    }
    public static boolean playerRun(String username, Boolean hasGoldLocket, Boolean battleStatus){
        //Player's Escape
        if (hasGoldLocket) {
            System.out.println("\n"+username+" distracts Alexis with the Gold Locket, and runs from the battle.");
            scanner.nextLine();
            System.out.println("\nCongratulations! You successfully went to class on time!");
            System.out.println("The End! You did it!");
            return !battleStatus;
        }
        else{
            System.out.println("\n"+username+" runs from the battle.");
            scanner.nextLine();
            System.out.println("Did you seriously think you could run?");
            scanner.nextLine();
            System.out.println("...");
            scanner.nextLine();
            System.out.println("GAME OVER. Don't give up just yet!");
            return false;
        }
    }
    public static void playerDrinkPotion(String username){
        //Potion Variables
        int potionEffect = random.nextInt(2);
        int luck = random.nextInt(10) + 1;
        int modifiedLuck;
        String potionEffectMessage;

        //Potion Effects
        if (potionEffect == 0) {
            modifiedLuck = luck * 2;
            potionEffectMessage = "luckier";
        } else {
            modifiedLuck = luck % 2;
            potionEffectMessage = "doomed";
        }

        System.out.println("\n"+username + " drinks a potion. You feel " + potionEffectMessage + ".");
        System.out.println("Your luck is now "+modifiedLuck);
    }
    public static void noRealKnife(String username){
        System.out.println("\nWho's that?");
        scanner.nextLine();
        System.out.println("Oh no! It's Alexis the killer!");
        scanner.nextLine();
        System.out.println("But it's too late to run, isn't it?");
        scanner.nextLine();
        System.out.println("You can't go to class if you're dead! Farewell, " + username);
        scanner.nextLine();
        System.out.println("GAME OVER");
    }
    public static int randomHP(){
        int minHP=25;
        int maxHP=70;
        return random.nextInt(maxHP - minHP + 1) + minHP;
    }
    public static String randomEvent(){
        String[] events = {"Drowning", "Burning", "Nothing", "Suffocation", "Alexis the Killer"};
        int index = random.nextInt(events.length);
        return events[index];
    }
    public static String randomItem(){
        int index = random.nextInt(items.length);
        return items[index];
    }
}