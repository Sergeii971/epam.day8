package com.verbovskiy.day8.model.dao;

import com.verbovskiy.day8.exception.DaoException;
import com.verbovskiy.day8.model.entity.CustomBook;
import com.verbovskiy.day8.model.entity.SortType;

import java.util.List;
import java.util.UUID;

public interface BookListDao {
    void add(CustomBook book) throws DaoException;

    void remove(CustomBook book) throws DaoException;

    List<CustomBook> findAll() throws DaoException;

    CustomBook findById(long id) throws DaoException;

    List<CustomBook> findByName(String name) throws DaoException;

    List<CustomBook> findByAuthor(String author) throws DaoException;

    List<CustomBook> findByEdition(String edition) throws DaoException;

    List<CustomBook> findByPageNumber(int pageNumber) throws DaoException;

    List<CustomBook> sort(SortType sortType) throws DaoException;
}
