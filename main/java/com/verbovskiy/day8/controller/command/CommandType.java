package com.verbovskiy.day8.controller.command;

import com.verbovskiy.day8.controller.command.impl.*;

public enum CommandType {
    ADD_BOOK(new AddBookCommand()),
    REMOVE_BOOK(new RemoveBookCommand()),
    FIND_BY_ID(new FindByIdCommand()),
    FIND_BY_NAME(new FindByNameCommand()),
    FIND_BY_NUMBER_OF_PAGE(new FindByPageNumberCommand()),
    FIND_BY_AUTHOR(new FindByAuthorCommand()),
    EMPTY_COMMAND(new EmptyCommand()),
    SORT_COMMAND(new SortCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
