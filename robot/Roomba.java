package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    // Main method to make this self-contained
    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        //String worldName = "robot/basicRoom.wld";
        String worldName = "robot/TestWorld-1.wld";
        World.setDelay(1);
        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 25, 13);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");  
    }

    // declared here so it is visible in all the methods!
    private Robot roomba;

    // You will need to add many variables!!

    public int cleanRoom(String worldName, int startX, int startY) {

        // A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

        World.readWorld(worldName);
        World.setVisible(true);
        roomba = new Robot(startX, startY, East, 0);

        int totalBeepers = 0; // defining what our starting values are.
        int numPiles = 0;
        int largestPile = 0;

        while (true) { // while true to keep this chunk of code running forever.
            while(roomba.frontIsClear()){
                roomba.move();  //while loop to increase pille size
                int pileSize = 0;
                while(roomba.nextToABeeper()){
                    roomba.pickBeeper();
                    totalBeepers++;
                    pileSize++;
                }
                if (pileSize > 0) { // put this in the while loop so it keeps updating until the end. Also this determines
                    numPiles++;
                    if (pileSize > largestPile) {
                        largestPile = pileSize;
                    }
                }
            }
            int pileSize = 0;
            while(roomba.nextToABeeper()){ // this chunk is for pilsize. if it picks up the beeper, it adds to the total amt of beepers and adds 1 to the pile size.
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++; //this is for finding the largest pilesize possible.
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
            if (!roomba.frontIsClear() && roomba.facingEast()) {
                roomba.turnLeft();
                if (roomba.frontIsClear()) { //to keep it going in the right direction.
                    roomba.move();
                    roomba.turnLeft();
                } else {
                    break;
                }
            }
            if (!roomba.frontIsClear() && roomba.facingWest()) {
                turnRight(roomba);
                if (roomba.frontIsClear()) {
                    roomba.move(); // same purpose as the if statement above but for the other direction.
                    turnRight(roomba);
                } else {
                    break;
                }
            }
            if (!roomba.frontIsClear() && !roomba.facingEast() && !roomba.facingWest()) {
                break;
            } // this was just to break after the roomba cleans everything
        }


        
       // this was just so i could commit.
        /** This section will have all the logic that takes the Robot to every location
         * and cleans up all piles of beepers. Think about ways you can break this
         * large, complex task into smaller, easier to solve problems.
         */

        // the line below causes a null pointer exception
        // what is that and why are we getting it?

        System.out.println("Number of piles: " + numPiles);
        System.out.println("Largest pile size: " + largestPile);

        // This method should return the total number of beepers cleaned up.
        return totalBeepers;
    }

    public static void turnRight(Robot roomba){
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
    }
}