package MarkovDecisionProcesses;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ValueIterationSolver {
    //TODO
    MDPModel model;
    double gamma;
    Map<MDPModelState, Double> summedValues = new HashMap<>();
    MDPPolicy policy;
    int iterations;

    public ValueIterationSolver(MDPModel model, int iterations, double gamma) {
        this.model = model;
        this.iterations = iterations;
        this.gamma = gamma;

        //Initialize summedValues at 0 for each state
        for (MDPModelState state : model.states) {
            summedValues.put(state, 0.0);
        }

        //Initialize optimal policy with a default action
        policy = new MDPPolicy(model, "DOWN");


        for (int i = 0; i < iterations; i++) {
            for (MDPModelState state : model.states) {
                double val = state.reward + gamma * getMaxRewardProbability(state);
                summedValues.put(state, val);
            }

            printSummedValuesGrid();

        }
    }

    public MDPPolicy getPolicy() {
         return policy;
    }

    private double getMaxRewardProbability(MDPModelState state) {

        double maxVal = 0;
        String maxPolicyAction = "NULL";

        for (Map.Entry<String, StateProbabilityRow> entry : state.actionToStochasticStateTransitionMap.entrySet()) {
            double val = sumOutLineRewardProbability(entry.getValue());
            if (val >= maxVal) {
                maxVal = val;
                maxPolicyAction = entry.getKey();
            }
        }

        policy.putActionForState(state, maxPolicyAction);

        return maxVal;
    }

    private double sumOutLineRewardProbability(StateProbabilityRow row) {
        double total = 0;
        for (SRE cell : row.cells) {
            total += summedValues.get(cell.state) * cell.chance;
        }
        return total;
    }

    private void printSummedValuesGrid() {
        //TODO: allow arbitrary grid size
        DecimalFormat df = new DecimalFormat("#.00");

        MDPModelStateGrid stateGrid[][] = new MDPModelStateGrid[3][4];
        for (MDPModelState state : summedValues.keySet() ) {
            MDPModelStateGrid gS = (MDPModelStateGrid) state;
            stateGrid[gS.y-1][gS.x-1] = gS;
        }
        StringBuilder b = new StringBuilder();
        b.append(" |\n  ---------------------------\n");

        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= 3; j++) {
                if (stateGrid[i][j] != null) {
                    b.append(" | ");
                    //b.append(stateGrid[i][j].getName());
                    //b.append(":");
                    b.append(df.format(summedValues.get(stateGrid[i][j])));
                } else {
                    b.append(" | ####");
                }
            }
            b.append(" |\n  ---------------------------\n");
        }

        System.out.println(b.toString());
    }
}
