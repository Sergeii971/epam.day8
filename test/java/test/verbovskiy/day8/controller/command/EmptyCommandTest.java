package test.verbovskiy.day8.controller.command;

import com.verbovskiy.day8.controller.command.ActionCommand;
import com.verbovskiy.day8.controller.command.CommandParameter;
import com.verbovskiy.day8.controller.command.impl.EmptyCommand;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class EmptyCommandTest {
    ActionCommand emptyCommand;

    @BeforeClass
    public void setUp() {
        emptyCommand = new EmptyCommand();
    }

    @Test
    public void executePositiveTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, "Something went wrong");
        Map<String, Object> actual = emptyCommand.execute(new HashMap<>());
        assertEquals(actual, expected);
    }

    @Test
    public void executeNegativeTest() {
        Map<String, Object> expected = new HashMap<>();
        expected.put(CommandParameter.RESPONSE_STATUS, "");
        Map<String, Object> actual = emptyCommand.execute(new HashMap<>());
        assertNotEquals(actual, expected);
    }
}