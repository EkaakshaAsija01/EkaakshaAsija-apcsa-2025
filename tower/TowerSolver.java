package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }// for commit

    public void solve(TowerModel model)
    {
        this.model = model;
        // Call the missing solve method (not this one
        solve(model.height(), 0, 2, 1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    // auxillary is the temporory holding spot to help move disks around, it is the "other" tower that is not the original spot or intendeed goal.
    private void solve(int n, int source, int destination, int auxiliary) {
        if (n == 1) { //base case, only one disk to move
            model.move(source, destination);
        } else {//move n-1 disks from source to auxiliary, then move the nth disk to destination, then move the n-1 disks from auxiliary to destination
            solve(n - 1, source, auxiliary, destination);
            model.move(source, destination);// move remaining biggest disk to where it belongs.
            solve(n - 1, auxiliary, destination, source);
        }//^ move n-1 disks from auxiliary to where they belong
    }

}