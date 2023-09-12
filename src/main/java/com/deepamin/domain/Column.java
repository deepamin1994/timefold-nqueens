package com.deepamin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Column {
    private int index;

    @Override
    public String toString() {
        return "Column{" +
                "index=" + index +
                '}';
    }
}
