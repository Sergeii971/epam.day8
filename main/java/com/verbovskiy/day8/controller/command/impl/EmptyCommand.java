package com.verbovskiy.day8.controller.command.impl;

import com.verbovskiy.day8.controller.command.ActionCommand;
import com.verbovskiy.day8.controller.command.CommandParameter;

import java.util.HashMap;
import java.util.Map;

public class EmptyCommand implements ActionCommand {
    private static final String MESSAGE = "Something went wrong";

    @Override
    public Map<String, Object> execute(Map<String, Object> actionParameters) {
        Map<String, Object> response = new HashMap<>();
        response.put(CommandParameter.RESPONSE_STATUS, MESSAGE);

        return response;
    }
}
