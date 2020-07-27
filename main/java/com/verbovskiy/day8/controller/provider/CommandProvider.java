package com.verbovskiy.day8.controller.provider;

import com.verbovskiy.day8.controller.command.ActionCommand;
import com.verbovskiy.day8.controller.command.CommandType;

public class CommandProvider {
    public ActionCommand defineCommand(String command){
        ActionCommand definedAction;

        if ((command != null) && (!command.isEmpty())) {
            try{
                definedAction = CommandType.valueOf(command.toUpperCase()).getCommand();
            } catch (IllegalArgumentException e) {
                definedAction = CommandType.EMPTY_COMMAND.getCommand();
            }
        } else {
            definedAction = CommandType.EMPTY_COMMAND.getCommand();
        }
        return definedAction;
    }
}
