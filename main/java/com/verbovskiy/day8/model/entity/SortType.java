package com.verbovskiy.day8.model.entity;

public enum SortType {
    SORT_BY_NAME("ORDER BY name;"),
    SORT_BY_AUTHOR("ORDER BY author;"),
    SORT_BY_EDITION("ORDER BY edition"),
    SORT_BY_PAGE_NUMBER("ORDER BY pageNumber");

    private String sortType;

   SortType(String sortType) {
    this.sortType = sortType;
}

 public String toString() {
     return sortType;
 }
}
