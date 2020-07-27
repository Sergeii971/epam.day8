package com.verbovskiy.day8.model.dao.impl;

import com.verbovskiy.day8.exception.DaoException;
import com.verbovskiy.day8.model.connection.ConnectionPool;
import com.verbovskiy.day8.model.dao.BookListDao;
import com.verbovskiy.day8.model.entity.CustomBook;
import com.verbovskiy.day8.model.entity.SortType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookListDaoImpl implements BookListDao {
    private  final String ADD_BOOK = "INSERT INTO book(name, author, edition, pageNumber)" +
            "VALUES (?, ?, ?, ?)";
    private  final String REMOVE_BOOK = "DELETE FROM book " +
            "WHERE name = ? AND author = ? AND edition = ? AND pageNumber = ? ";
    private final String FIND_ALL_BOOKS = "SELECT bookId, name, author, edition, pageNumber " +
            "FROM book ";
    private final String FIND_BOOK_BY_ID = FIND_ALL_BOOKS + " WHERE bookId = ? ";
    private final String FIND_BOOKS_BY_NAME = FIND_ALL_BOOKS + " WHERE name = ? ";
    private final String FIND_BOOKS_BY_AUTHOR = FIND_ALL_BOOKS + " WHERE author = ? ";
    private final String FIND_BOOKS_BY_EDITION = FIND_ALL_BOOKS + " WHERE edition = ? ";
    private final String FIND_BOOKS_BY_PAGE_NUMBER = FIND_ALL_BOOKS + " WHERE pageNumber = ? ";
    private final String ID_COLUMN_NAME = "bookId";
    private final String AUTHOR_COLUMN_NAME = "author";
    private final String NAME_COLUMN_NAME = "name";
    private final String EDITION_COLUMN_NAME = "edition";
    private final String PAGE_NUMBER_COLUMN_NAME = "pageNumber";

    @Override
    public void add(CustomBook book) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(ADD_BOOK)) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getEdition());
            statement.setInt(4, book.getPageNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while adding book to database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void remove(CustomBook book) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(REMOVE_BOOK)) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getEdition());
            statement.setInt(4, book.getPageNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error while removing book from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    public List<CustomBook> findAll() throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_BOOKS)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while get all books from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public CustomBook findById(long bookId) throws DaoException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        CustomBook book = new CustomBook();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOK_BY_ID)) {
            statement.setLong(1, bookId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    book = createBookFromSql(resultSet);

                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding book by Id from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return book;
    }

    public List<CustomBook> findByName(String name) throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOKS_BY_NAME)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding books by name from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> findByAuthor(String author) throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOKS_BY_AUTHOR)) {
            statement.setString(1, author);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding books by author from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> findByEdition(String edition) throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOKS_BY_EDITION)) {
            statement.setString(1, edition);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding books by edition from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> findByPageNumber(int pageNumber) throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(FIND_BOOKS_BY_PAGE_NUMBER)) {
            statement.setInt(1, pageNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding books by pageNumber from database", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    @Override
    public List<CustomBook> sort(SortType sortType) throws DaoException {
        List<CustomBook> books = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        String sqlQuery = String.format("%s%s", FIND_ALL_BOOKS, sortType.toString());
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    CustomBook book = createBookFromSql(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error while sort books", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return books;
    }

    private CustomBook createBookFromSql(ResultSet resultSet) throws DaoException {
        CustomBook book = new CustomBook();
        try {
            book.setId(resultSet.getInt(ID_COLUMN_NAME));
        book.setName(resultSet.getString(NAME_COLUMN_NAME));
        book.setAuthor(resultSet.getString(AUTHOR_COLUMN_NAME));
        book.setEdition(resultSet.getString(EDITION_COLUMN_NAME));
        book.setPageNumber(resultSet.getInt(PAGE_NUMBER_COLUMN_NAME));
        } catch (SQLException e) {
            throw new DaoException("Error while finding books", e);
        }
        return book;
    }
}
