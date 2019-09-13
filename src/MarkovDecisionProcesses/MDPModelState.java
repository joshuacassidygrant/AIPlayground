package MarkovDecisionProcesses;

import java.util.HashMap;
import java.util.Map;

public abstract class MDPModelState {
    //Maps each action to a probability to enter another state
    Map<String, StateProbabilityRow> actionToStochasticStateTransitionMap;
    double reward;

    public abstract String getName();
    public void addActionToStochasticStateTransitionMap(String actionName, SRE[] sres){
        if (!actionToStochasticStateTransitionMap.containsKey(actionName)) {
            actionToStochasticStateTransitionMap.put(actionName, new StateProbabilityRow(sres));
        }
    }

    public MDPModelState(double reward) {

        this.reward = reward;
        actionToStochasticStateTransitionMap = new HashMap<>();


    }
}
