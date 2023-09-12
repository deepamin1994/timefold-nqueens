package com.deepamin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Row {
    private int index;

    @Override
    public String toString() {
        return "Row{" +
                "index=" + index +
                '}';
    }
}
