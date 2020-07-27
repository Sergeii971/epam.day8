package com.verbovskiy.day8.controller.command.impl;

import com.verbovskiy.day8.controller.command.ActionCommand;
import com.verbovskiy.day8.controller.command.CommandParameter;
import com.verbovskiy.day8.exception.ServiceException;
import com.verbovskiy.day8.model.entity.CustomBook;
import com.verbovskiy.day8.model.service.LibraryService;

import java.util.HashMap;
import java.util.Map;

public class AddBookCommand implements ActionCommand {
    @Override
    public Map<String, Object> execute(Map<String, Object> actionParameters) {
        Map<String, Object> response = new HashMap<>();
        LibraryService libraryService = new LibraryService();

        CustomBook book = new CustomBook((String) actionParameters.get(CommandParameter.BOOK_NAME),
                (String) actionParameters.get(CommandParameter.AUTHOR),
                (String) actionParameters.get(CommandParameter.EDITION),
                (int) actionParameters.get(CommandParameter.NUMBER_OF_PAGE));
        try {
            libraryService.add(book);
            response.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        } catch (ServiceException e) {
            response.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_FAIL);
        }
        return response;

    }
}
