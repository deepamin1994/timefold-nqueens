package com.deepamin.domain;

import ai.timefold.solver.core.api.domain.lookup.PlanningId;
import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.simple.SimpleScore;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Getter
@Setter
@PlanningSolution
public class NQueens {
    @PlanningId
    private int id;

    private int n;

    @PlanningEntityCollectionProperty
    public List<Queen> queens;

    public List<Row> rows;

    private List<Column> columns;

    @PlanningScore
    private SimpleScore score;

    @ValueRangeProvider
    private List<Row> getRows() {
        int n = this.getN();
        return IntStream.range(0, n)
                .boxed()
                .map(Row::new)
                .toList();
    }

    @Override
    public String toString() {
        Map<String, Queen> queenMap = new HashMap<>();
        for (Queen q: queens) {
            queenMap.put(q.getRowIndex() + " " + q.getColumnIndex(), q);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  ");
        for (int c = 0; c < n; c++) {
            stringBuilder.append((char) (c + 65)).append(" ");
        }
        stringBuilder.append("\n");
        int column = 0;
        for (int r = 0; r < n; r++) {
            stringBuilder.append(column++).append(" ");
            for (int c = 0; c < n; c++) {
                if (queenMap.containsKey(r + " " + c)) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}


