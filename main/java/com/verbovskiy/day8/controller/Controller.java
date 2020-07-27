package com.verbovskiy.day8.controller;

import com.verbovskiy.day8.controller.command.ActionCommand;
import com.verbovskiy.day8.controller.provider.CommandProvider;

import java.util.Map;

public class Controller {
    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    public Map<String, Object> processRequest(String commandType, Map<String, Object> actionParameters) {
        CommandProvider command = new CommandProvider();
        ActionCommand actionCommand = command.defineCommand(commandType);
        Map<String, Object> actionResult = actionCommand.execute(actionParameters);

        return actionResult;
    }
}
