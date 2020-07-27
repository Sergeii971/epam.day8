package com.verbovskiy.day8.model.service;

import com.verbovskiy.day8.exception.DaoException;
import com.verbovskiy.day8.exception.ServiceException;
import com.verbovskiy.day8.model.dao.BookListDao;
import com.verbovskiy.day8.model.dao.impl.BookListDaoImpl;
import com.verbovskiy.day8.model.entity.CustomBook;
import com.verbovskiy.day8.model.entity.SortType;

import java.util.List;

public class LibraryService {
    public void add(CustomBook book) throws ServiceException {
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            List<CustomBook> books = bookListDao.findAll();

            if ((book == null) || (books.contains(book))) {
                throw new ServiceException("incorrect data");
            }
            bookListDao.add(book);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void remove(CustomBook book) throws ServiceException {
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            List<CustomBook> books = bookListDao.findAll();

            if ((book == null) || (!books.contains(book))) {
                throw new ServiceException("incorrect data");
            }
            bookListDao.remove(book);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public CustomBook findById(long id) throws ServiceException {
        CustomBook book;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            book = bookListDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return book;
    }

    public List<CustomBook> findByName(String name) throws ServiceException {
        if ((name == null) || (name.isEmpty())) {
            throw new ServiceException("incorrect data");
        }
        List<CustomBook> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<CustomBook> findByAuthor(String author) throws ServiceException {
        if ((author == null) || (author.isEmpty())) {
            throw new ServiceException("incorrect data");
        }
        List<CustomBook> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByAuthor(author);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<CustomBook> findByEdition(String edition) throws ServiceException {
        if ((edition == null) || (edition.isEmpty())) {
            throw new ServiceException("incorrect data");
        }
        List<CustomBook> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByEdition(edition);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<CustomBook> findByPageNumber(int pageNumber) throws ServiceException {
        if (pageNumber <= 0) {
            throw new ServiceException("incorrect data");
        }
        List<CustomBook> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.findByPageNumber(pageNumber);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }

    public List<CustomBook> sort(SortType sortType) throws ServiceException {
        if (sortType == null) {
            throw new ServiceException("incorrect data");
        }
        List<CustomBook> foundBooks;
        try {
            BookListDao bookListDao = new BookListDaoImpl();
            foundBooks = bookListDao.sort(sortType);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return foundBooks;
    }
}
