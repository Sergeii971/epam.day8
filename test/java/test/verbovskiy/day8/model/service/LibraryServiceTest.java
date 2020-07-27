package test.verbovskiy.day8.model.service;

import com.verbovskiy.day8.exception.ServiceException;
import com.verbovskiy.day8.model.entity.CustomBook;
import com.verbovskiy.day8.model.entity.SortType;
import com.verbovskiy.day8.model.service.LibraryService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class LibraryServiceTest {
    LibraryService libraryService;

    @BeforeMethod
    public void setUp() {
        libraryService = new LibraryService();
    }

    @Test(expectedExceptions = ServiceException.class)
    public void addExceptionTest() throws ServiceException {
        libraryService.add(null);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void removeExceptionTest() throws ServiceException {
        libraryService.remove(null);
    }

    @Test
    public void findByIdPositiveTest() throws ServiceException {
        CustomBook actual = libraryService.findById(345346);
        CustomBook expected = new CustomBook();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() throws ServiceException {
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook actual = libraryService.findById(235364);
        CustomBook expected = book2;
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByNamePositiveTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = libraryService.findByName("Book1");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book2", "Ivan", "Moscow", 100);
        List<CustomBook> actual = libraryService.findByName("Book1");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByNameExceptionTest() throws ServiceException {
        libraryService.findByName(null);
    }

    @Test
    public void findByAuthorPositiveTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = libraryService.findByAuthor("Ivan");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorNegativeTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Dima", "Moscow", 100);
        List<CustomBook> actual = libraryService.findByAuthor("Ivan");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByAuthorExceptionTest() throws ServiceException {
        libraryService.findByAuthor(null);
    }

    @Test
    public void findByEditionPositiveTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = libraryService.findByEdition("Moscow");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByEditionNegativeTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = libraryService.findByEdition("Minsk");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByEditionExceptionTest() throws ServiceException {
        libraryService.findByEdition(null);
    }

    @Test
    public void findByPageNumberPositiveTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = libraryService.findByPageNumber(100);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPageNumberNegativeTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = libraryService.findByPageNumber(150);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByPageNumberExceptionTest() throws ServiceException {
        libraryService.findByPageNumber(-1);
    }

    @Test
    public void sortPositiveTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "Minsk", 150);
        List<CustomBook> actual = libraryService.sort(SortType.SORT_BY_AUTHOR);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void sortNegativeTest() throws ServiceException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "Minsk", 150);
        List<CustomBook> actual = libraryService.sort(SortType.SORT_BY_AUTHOR);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void sortExceptionTest() throws ServiceException {
        libraryService.sort(null);
    }
}