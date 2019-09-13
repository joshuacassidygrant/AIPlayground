package com.company;

import MarkovDecisionProcesses.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Running sample MDP");
        MDPModel model= createSampleMDP();
        ValueIterationSolver vis = new ValueIterationSolver(model, 10, 1);
        MDPPolicy optimalPolicy = vis.getPolicy();
        System.out.println("Best Policy:");
        System.out.println(optimalPolicy);
    }

    public static MDPModel createSampleMDP(){
        MDPModel model = new MDPModel();

        MDPModelState s11 = new MDPModelStateGrid(1, 1, -0.04);
        MDPModelState s12 = new MDPModelStateGrid(1, 2, -0.04);
        MDPModelState s13 = new MDPModelStateGrid(1, 3, -0.04);
        MDPModelState s21 = new MDPModelStateGrid(2, 1, -0.04);
        MDPModelState s23 = new MDPModelStateGrid(2, 3, -0.04);
        MDPModelState s31 = new MDPModelStateGrid(3, 1, -0.04);
        MDPModelState s32 = new MDPModelStateGrid(3, 2, -0.04);
        MDPModelState s33 = new MDPModelStateGrid(3, 3, -0.04);
        MDPModelState s41 = new MDPModelStateGrid(4, 1, -0.04);
        MDPModelState s42 = new MDPModelStateGrid(4, 2, -1);
        MDPModelState s43 = new MDPModelStateGrid(4, 3, 1);

        model.addState(s11);
        model.addState(s12);
        model.addState(s13);
        model.addState(s21);
        model.addState(s23);
        model.addState(s31);
        model.addState(s32);
        model.addState(s33);
        model.addState(s41);
        model.addState(s42);
        model.addState(s43);

        s11.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s12, 0.8), new SRE(s11, 0.1), new SRE(s21, 0.1)});
        s11.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s21, 0.8), new SRE(s11, 0.1), new SRE(s12, 0.1)});
        s11.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s11, 0.9), new SRE(s21, 0.1)});
        s11.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s11, 0.9), new SRE(s12, 0.1)});

        s12.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s13, 0.8), new SRE(s12, 0.2)});
        s12.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s12, 0.8), new SRE(s11, 0.1), new SRE(s13, 0.1)});
        s12.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s11, 0.8), new SRE(s12, 0.2)});
        s12.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s12, 0.8), new SRE(s11, 0.1), new SRE(s13, 0.1)});

        s13.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s13, 0.9), new SRE(s23, 0.1)});
        s13.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s23, 0.8), new SRE(s13, 0.1), new SRE(s12, 0.1)});
        s13.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s12, 0.8), new SRE(s13, 0.1), new SRE(s23, 0.1)});
        s13.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s13, 0.9), new SRE(s12, 0.1)});

        s21.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s11, 0.1), new SRE(s21, 0.8), new SRE(s31, 0.1)});
        s21.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s31, 0.8), new SRE(s21, 0.2)});
        s21.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s21, 0.8), new SRE(s11, 0.1), new SRE(s31, 0.1)});
        s21.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s11, 0.8), new SRE(s21, 0.2)});

        s23.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s13, 0.1), new SRE(s23, 0.8), new SRE(s33, 0.1)});
        s23.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s33, 0.8), new SRE(s23, 0.2)});
        s23.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s23, 0.8), new SRE(s13, 0.1), new SRE(s33, 0.1)});
        s23.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s13, 0.8), new SRE(s23, 0.2)});

        s31.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s21, 0.1), new SRE(s32, 0.8), new SRE(s41, 0.1)});
        s31.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s41, 0.8), new SRE(s31, 0.1), new SRE(s32, 0.1)});
        s31.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s31, 0.8), new SRE(s21, 0.1), new SRE(s41, 0.1)});
        s31.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s21, 0.8), new SRE(s32, 0.1), new SRE(s31, 0.1)});

        s32.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s42, 0.1), new SRE(s33, 0.8), new SRE(s32, 0.1)});
        s32.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s42, 0.8), new SRE(s33, 0.1), new SRE(s31, 0.1)});
        s32.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s31, 0.8), new SRE(s32, 0.1), new SRE(s42, 0.1)});
        s32.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s32, 0.8), new SRE(s33, 0.1), new SRE(s31, 0.1)});

        s33.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s33, 0.8), new SRE(s43, 0.1), new SRE(s23, 0.1)});
        s33.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s43, 0.8), new SRE(s33, 0.1), new SRE(s32, 0.1)});
        s33.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s32, 0.8), new SRE(s43, 0.1), new SRE(s23, 0.1)});
        s33.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s23, 0.8), new SRE(s33, 0.1), new SRE(s32, 0.1)});

        s41.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s42, 0.8), new SRE(s41, 0.1), new SRE(s33, 0.1)});
        s41.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s41, 0.9), new SRE(s42, 0.1)});
        s41.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s41, 0.9), new SRE(s31, 0.1)});
        s41.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s31, 0.8), new SRE(s42, 0.1), new SRE(s41, 0.1)});

        s42.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s43, 0.8), new SRE(s32, 0.1), new SRE(s42, 0.1)});
        s42.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s42, 0.8), new SRE(s41, 0.1), new SRE(s43, 0.1)});
        s42.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s41, 0.8), new SRE(s32, 0.1), new SRE(s42, 0.1)});
        s42.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s32, 0.8), new SRE(s41, 0.1), new SRE(s43, 0.1)});

        s43.addActionToStochasticStateTransitionMap("UP", new SRE[] {new SRE(s43, 0.9), new SRE(s33, 0.1)});
        s43.addActionToStochasticStateTransitionMap("RIGHT", new SRE[] {new SRE(s43, 0.9), new SRE(s42, 0.1)});
        s43.addActionToStochasticStateTransitionMap("DOWN", new SRE[] {new SRE(s42, 0.8), new SRE(s33, 0.1), new SRE(s43, 0.1)});
        s43.addActionToStochasticStateTransitionMap("LEFT", new SRE[] {new SRE(s33, 0.8), new SRE(s42, 0.1), new SRE(s43, 0.1)});

        return model;

    }
}
