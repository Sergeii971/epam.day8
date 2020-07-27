package test.verbovskiy.day8.model.dao;

import com.verbovskiy.day8.exception.DaoException;
import com.verbovskiy.day8.model.dao.BookListDao;
import com.verbovskiy.day8.model.dao.impl.BookListDaoImpl;
import com.verbovskiy.day8.model.entity.CustomBook;
import com.verbovskiy.day8.model.entity.SortType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class BookListDaoImplTest {
    BookListDao bookListDao;

    @BeforeMethod
    public void setUp() {
        bookListDao = new BookListDaoImpl();
    }

    @Test
    public void findByIdPositiveTest() throws DaoException {
        CustomBook actual = bookListDao.findById(145355235);
        CustomBook expected = new CustomBook();
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdNegativeTest() throws DaoException {
        CustomBook book2 = new CustomBook("Book2", "Dima", "New-York", 150);
        CustomBook actual = bookListDao.findById(534536456);
        CustomBook expected = book2;
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByNamePositiveTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = bookListDao.findByName("Book1");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameNegativeTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book2", "Ivan", "Moscow", 100);
        List<CustomBook> actual = bookListDao.findByName("Book1");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByAuthorPositiveTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = bookListDao.findByAuthor("Ivan");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorNegativeTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Dima", "Moscow", 100);
        List<CustomBook> actual = bookListDao.findByAuthor("Ivan");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByEditionPositiveTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = bookListDao.findByEdition("Moscow");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByEditionNegativeTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = bookListDao.findByEdition("Minsk");
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void findByPageNumberPositiveTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = bookListDao.findByPageNumber(100);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPageNumberNegativeTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        List<CustomBook> actual = bookListDao.findByPageNumber(150);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        assertNotEquals(actual, expected);
    }

    @Test
    public void sortPositiveTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "Minsk", 150);
        List<CustomBook> actual = bookListDao.sort(SortType.SORT_BY_AUTHOR);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book1);
        assertEquals(actual, expected);
    }

    @Test
    public void sortNegativeTest() throws DaoException {
        CustomBook book1 = new CustomBook("Book1", "Ivan", "Moscow", 100);
        CustomBook book2 = new CustomBook("Book2", "Dima", "Minsk", 150);
        List<CustomBook> actual = bookListDao.sort(SortType.SORT_BY_AUTHOR);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book1);
        expected.add(book2);
        assertNotEquals(actual, expected);
    }
}