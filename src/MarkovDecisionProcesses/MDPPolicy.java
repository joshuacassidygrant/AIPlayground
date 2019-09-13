package MarkovDecisionProcesses;

import java.util.HashMap;
import java.util.Map;

public class MDPPolicy {

    Map<MDPModelState, String> statesToActions;

    public MDPPolicy(MDPModel model, String defaultAction) {
        statesToActions = new HashMap<>();
        for (MDPModelState state : model.states) {
            statesToActions.put(state, defaultAction);
        }
    }

    public String getActionForState(MDPModelState state) {
        if (!statesToActions.containsKey(state)) {
            System.out.println("No state found in policy");
            return "";
        }

        return statesToActions.get(state);
    }

    public void putActionForState(MDPModelState state, String action) {
        statesToActions.put(state, action);
    }

    public String toString() {
        String string = "";
        for (Map.Entry<MDPModelState, String> entry : statesToActions.entrySet()) {
            string += String.format("%s : %s\n", entry.getKey().getName(), entry.getValue());
        }
        return string;
    }

}
