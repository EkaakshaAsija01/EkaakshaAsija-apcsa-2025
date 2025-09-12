package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        //String worldName = "robot/basicRoom.wld";
        String worldName = "robot/basicRoom.wld";
        World.setDelay(1);
        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
        System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");  
    }

    private Robot roomba;

    public int cleanRoom(String worldName, int startX, int startY) {

        World.readWorld(worldName);
        World.setVisible(true);
        roomba = new Robot(startX, startY, East, 0);

        int totalBeepers = 0; // defining what our starting values are.
        int numPiles = 0;
        int largestPile = 0;
        int unitsSquared = 0;
        int UnitsMovedToFindMax = 0;
        int UnitsMovedToFindMaxMax = 0;

        // Clean starting square
        int pileSize = 0;
        while (roomba.nextToABeeper()) {
            roomba.pickBeeper();
            totalBeepers++;
            pileSize++;
            UnitsMovedToFindMax++;

        }
        if (pileSize > 0) {
            numPiles++;
            if (pileSize > largestPile) {
                largestPile = pileSize;
            }
        }
        unitsSquared++; // Count starting square

        while (true) {
            while(roomba.frontIsClear()){
                roomba.move();  //while loop to increase pille size
                unitsSquared++; //whenever it moves add to area
                pileSize = 0;
                while(roomba.nextToABeeper()){
                    roomba.pickBeeper();
                    totalBeepers++;
                    pileSize++;
                    UnitsMovedToFindMax++;
                }
                if (pileSize > 0) { // put this in the while loop so it keeps updating until the end. Also this determines
                    numPiles++;
                    if (pileSize > largestPile) {
                        largestPile = pileSize;
                    }
                }
            }
            pileSize = 0;
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
                    unitsSquared++; // Count the square you move to at row start
                    roomba.turnLeft();

                } else {
                    break;
                }
            }
            if (!roomba.frontIsClear() && roomba.facingWest()) {
                turnRight(roomba);
                if (roomba.frontIsClear()) {
                    roomba.move(); // same purpose as the if statement above but for the other direction.
                    unitsSquared++; // Count the square you move to at row start
                    turnRight(roomba);
                } else {
                    break;
                }
            }
            if (!roomba.frontIsClear() && !roomba.facingEast() && !roomba.facingWest()) {
                break;
            } // this was just to break after the roomba cleans everything
        }
        double PercentageDirty= (double)numPiles/unitsSquared; // this is to find the percent dirty
        double AveragePileSize= (double)totalBeepers/numPiles; // this is for average pile size.
    
        // this was just so i could commit.
        
        
        System.out.println("Number of piles: " + numPiles);
        System.out.println("Largest pile size: " + largestPile);
        System.out.println("Total area is "+ unitsSquared + " units squared" );
        System.out.println("The percentage dirty is "+ PercentageDirty);
        System.out.println("The average Pile Size was " +  AveragePileSize);
        // This method should return the total number of beepers cleaned up.
        return totalBeepers;
    }

    public static void turnRight(Robot roomba){
        roomba.turnLeft();
        roomba.turnLeft();
        roomba.turnLeft();
    }
}