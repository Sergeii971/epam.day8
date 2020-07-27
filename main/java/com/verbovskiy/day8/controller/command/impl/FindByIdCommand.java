package com.verbovskiy.day8.controller.command.impl;

import com.verbovskiy.day8.controller.command.ActionCommand;
import com.verbovskiy.day8.controller.command.CommandParameter;
import com.verbovskiy.day8.exception.ServiceException;
import com.verbovskiy.day8.model.entity.CustomBook;
import com.verbovskiy.day8.model.service.LibraryService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FindByIdCommand implements ActionCommand {
    @Override
    public Map<String, Object> execute(Map<String, Object> actionParameters) {
        Map<String, Object> response = new HashMap<>();
        LibraryService libraryService = new LibraryService();
        try {
            CustomBook book = libraryService.findById((long) actionParameters
                    .get(CommandParameter.ID));
            response.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
            response.put(CommandParameter.RESPONSE_RESULT, book);
        } catch (ServiceException e) {
            response.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_FAIL);
        }
        return response;
    }
}
