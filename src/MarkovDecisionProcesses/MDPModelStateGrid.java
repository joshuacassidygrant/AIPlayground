package MarkovDecisionProcesses;

import java.util.Map;

public class MDPModelStateGrid extends MDPModelState {

    int x;
    int y;



    public String getName() {
        return String.format("(%d, %d)", x, y);
    }

    public MDPModelStateGrid(int x, int y, double reward) {
        super(reward);
        this.x = x;
        this.y = y;
    }
}
