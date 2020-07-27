package test.verbovskiy.day8.controller.provider;

import com.verbovskiy.day8.controller.command.ActionCommand;
import com.verbovskiy.day8.controller.command.CommandType;
import com.verbovskiy.day8.controller.provider.CommandProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CommandProviderTest {
    CommandProvider provider;

    @BeforeClass
    public void setUp() {
        provider = new CommandProvider();
    }

    @Test
    public void provideCommandPositiveTest() {
        ActionCommand expected = CommandType.ADD_BOOK.getCommand();
        ActionCommand actual = provider.defineCommand("add_book");
        assertEquals(actual, expected);
        }

    @Test
    public void provideCommandNegativeTest() {
        ActionCommand expected = CommandType.ADD_BOOK.getCommand();
        ActionCommand actual = provider.defineCommand("delete_book");
        assertNotEquals(actual, expected);
    }
}