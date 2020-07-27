package test.verbovskiy.day8.controller;

import com.verbovskiy.day8.controller.Controller;
import com.verbovskiy.day8.controller.command.CommandParameter;
import com.verbovskiy.day8.model.entity.CustomBook;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ControllerTest {
    @Test
    public void processRequestPositiveTest() {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        Map<String, Object> expected = new HashMap<>();
        List<CustomBook> books = new ArrayList<>();
        books.add(book1);
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        expected.put(CommandParameter.RESPONSE_RESULT, books);
        String currentCommand = "find_by_author";
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.AUTHOR, "Ivan");
        Map<String, Object> actual = Controller.getInstance().processRequest(currentCommand, actionParameters);
        assertEquals(actual, expected);
    }

    @Test
    public void processRequestNegativeTest() {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        Map<String, Object> expected = new HashMap<>();
        List<CustomBook> books = new ArrayList<>();
        books.add(book1);
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_FAIL);
        expected.put(CommandParameter.RESPONSE_RESULT, books);
        String currentCommand = "find_by_author";
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.AUTHOR, "Ivan");
        Map<String, Object> actual = Controller.getInstance().processRequest(currentCommand, actionParameters);
        assertNotEquals(actual, expected);
    }
}