package test.verbovskiy.day8.controller.command;

import com.verbovskiy.day8.controller.command.ActionCommand;
import com.verbovskiy.day8.controller.command.CommandParameter;
import com.verbovskiy.day8.controller.command.impl.FindByPageNumberCommand;
import com.verbovskiy.day8.model.entity.CustomBook;
import com.verbovskiy.day8.model.entity.Library;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class FindByPageNumberCommandTest {
    ActionCommand findByPageNumberCommand;

    @BeforeClass
    public void setUp() {
        findByPageNumberCommand = new FindByPageNumberCommand();
    }

    @Test
    public void executePositiveTest() {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> books = new ArrayList<>();
        books.add(book1);
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        expected.put(CommandParameter.RESPONSE_RESULT, books);
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.NUMBER_OF_PAGE, 100);
        Map<String, Object> actual = findByPageNumberCommand.execute(actionParameters);
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> books = new ArrayList<>();
        books.add(book1);
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, CommandParameter.RESPONSE_STATUS_SUCCESS);
        expected.put(CommandParameter.RESPONSE_RESULT, books);
        Map<String, Object> actionParameters = new HashMap<>();
        actionParameters.put(CommandParameter.NUMBER_OF_PAGE, 150);
        Map<String, Object> actual = findByPageNumberCommand.execute(actionParameters);
        assertNotEquals(actual, expected);
    }
}