package com.deepamin.domain;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.lookup.PlanningId;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;
import lombok.Getter;
import lombok.Setter;

@PlanningEntity
@Getter
@Setter
public class Queen {
    @PlanningId
    private int id;

    @PlanningVariable
    private Row row;

    private Column column;

    public int getRowIndex() {
        return row.getIndex();
    }

    public int getColumnIndex() {
        return column.getIndex();
    }

    public int getAscendingDiagonalIndex() {
        return this.getColumnIndex() + this.getRowIndex();
    }

    public int getDescendingDiagonalIndex() {
        return this.getColumnIndex() - this.getRowIndex();
    }

    @Override
    public String toString() {
        return "Queen{" +
                "id=" + id +
                ", row=" + row +
                ", column=" + column +
                '}';
    }
}
