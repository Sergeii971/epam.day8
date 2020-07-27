package com.verbovskiy.day8.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private static Library instance;

    private List<CustomBook> books;

    private Library() {
        books = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public boolean add(CustomBook book) {
        boolean result = true;

        if (books.contains(book)) {
            result = false;
        } else {
            books.add(book);
        }
        return result;
    }

    public boolean remove(CustomBook book) {
        boolean result = true;
        if (!books.contains(book)) {
           result = false;
        } else {
        books.remove(book);
        }
        return result;
    }

    public void removeAll() {
        books.removeAll(books);
    }

    public List<CustomBook> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public int size() {
        return books.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((this == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        Library library = (Library) o;

        if (books == null) {
            if (library.books != null) {
                return false;
            }
        } else {
            if (!books.equals(library.books)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return books == null ? 0 : books.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder().append(books).toString();
    }
}
