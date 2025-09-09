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

        int totalBeepers = 0;
        int numPiles = 0;
        int largestPile = 0;

        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }
        roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }
        roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }
        roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }
         roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }
         roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }
         roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }
         roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }
         roomba.turnLeft();
        roomba.move();
        roomba.turnLeft();
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }

        turnRight(roomba);
        roomba.move();
        turnRight(roomba);
        while(roomba.frontIsClear()){
            roomba.move();
            int pileSize = 0;
            while(roomba.nextToABeeper()){
                roomba.pickBeeper();
                totalBeepers++;
                pileSize++;
            }
            if (pileSize > 0) {
                numPiles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                }
            }
        }


        
       
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