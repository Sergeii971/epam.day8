package com.verbovskiy.day8.controller.command.impl;

import com.verbovskiy.day8.controller.command.ActionCommand;
import com.verbovskiy.day8.controller.command.CommandParameter;
import com.verbovskiy.day8.exception.ServiceException;
import com.verbovskiy.day8.model.entity.CustomBook;
import com.verbovskiy.day8.model.entity.SortType;
import com.verbovskiy.day8.model.service.LibraryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCommand implements ActionCommand {
    @Override
    public Map<String, Object> execute(Map<String, Object> actionParameters) {
        Map<String, Object> response = new HashMap<>();
        LibraryService libraryService = new LibraryService();
        try {
            List<CustomBook> books = libraryService.sort((SortType) actionParameters
                    .get(CommandParameter.SORT_TYPE));
            response.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
            response.put(CommandParameter.RESPONSE_RESULT, books);
        } catch (ServiceException e) {
            response.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_FAIL);
        }
        return response;
    }
}
