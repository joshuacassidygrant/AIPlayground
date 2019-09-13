package MarkovDecisionProcesses;

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
}
