package tower;

public class TowerModel {

    // 2d array storing game state
    private IntegerStack[] towers;
    // Final tower height
    private int towerHeight = 0;

    // Debug metrics
    private int printCounter = 0;
    private int moveCounter = 0;

    public TowerModel(int height)
    {
        towerHeight = height;
        towers = new IntegerStack[3];
        towers[0] = new IntegerStack(height);
        towers[1] = new IntegerStack(height);
        towers[2] = new IntegerStack(height);

        for (int i = 0; i < height; i++)
        {
            towers[0].push(height - i);
        }
    }

    // get the total number of disks
    public int height()
    {
        return towerHeight;
    }

    // Move one disk from the source stack to the destination stack.
    public void move(int source, int destination)
    {
        System.out.println("Move #" + ++moveCounter + " from " + source + " to " + destination);
// check that index are within the range
        if (source < 0 || source >= towers.length || destination < 0 || destination >= towers.length) {
            return;
        }
// check top disk 
        int disk = towers[source].peek();
        if (disk == 0) {
            // Nothing to move from empty tower
            return;
        }

        int destTop = towers[destination].peek();
        if (destTop != 0 && destTop < disk) {
            // Illegal move: cannot place larger disk on smaller disk
            return;
        }
// do the legal disk move
        towers[source].pop();
        towers[destination].push(disk);
    }

    // Helper method to nicely print the current model state.
    public void print()
    {
        System.out.print("Print #" + ++printCounter + " Towers of Hanoi\n");

        for (int layer = towerHeight - 1; layer >= 0; layer--) {
            System.out.print("\n");
            for (int tower = 0; tower < towers.length; tower++) {
                int value = towers[tower].get(layer);
                if (value == 0) {
                    System.out.print(" |");
                } else {
                    System.out.print(" " + value);
                }
            }
        }
        System.out.println();
        for (int i = 0; i < towers.length; i++) {
            System.out.print(" =");
        }
        System.out.println();
    }

    // Test instrumentation
    public IntegerStack[] getTowers()
    {
        return towers;
    }

    public int getHeight()
    {
        return towerHeight;
    }
}