package com.verbovskiy.day8.controller.command;

import java.util.Map;

public interface ActionCommand {
    Map<String, Object> execute(Map<String, Object> actionParameters);
}

