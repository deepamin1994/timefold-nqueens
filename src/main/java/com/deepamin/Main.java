package com.deepamin;

import ai.timefold.solver.core.api.solver.Solver;
import ai.timefold.solver.core.api.solver.SolverFactory;
import ai.timefold.solver.core.config.solver.SolverConfig;
import com.deepamin.domain.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int n = 16;
        SolverFactory<NQueens> nQueensSolverFactory = SolverFactory.create(new SolverConfig()
                .withSolutionClass(NQueens.class)
                .withEntityClasses(Queen.class)
                .withConstraintProviderClass(NQueensConstraintProvider.class)
                .withTerminationSpentLimit(Duration.ofSeconds(10)));
        Solver<NQueens> nQueensSolver = nQueensSolverFactory.buildSolver();

        Main main = new Main();
        NQueens nQueensProblem = main.buildNQueensProblem(n);
        NQueens nQueensSolution = nQueensSolver.solve(nQueensProblem);
        main.printSolution(nQueensSolution);
    }

    private void printSolution(NQueens nQueensSolution) {
        System.out.println(nQueensSolution);
    }

    private NQueens buildNQueensProblem(int n) {
        NQueens nQueens = new NQueens();
        nQueens.setId(0);
        nQueens.setN(n);
        nQueens.setColumns(createColumns(nQueens));
        nQueens.setQueens(createQueens(nQueens));
        return nQueens;
    }

    private List<Column> createColumns(NQueens nQueens) {
        int n = nQueens.getN();
        return IntStream.range(0, n)
                .boxed()
                .map(Column::new)
                .toList();
    }

    private List<Queen> createQueens(NQueens nQueens) {
        int n = nQueens.getN();
        List<Queen> queenList = new ArrayList<>(n);
        int id = 0;
        for (Column column : nQueens.getColumns()) {
            Queen queen = new Queen();
            queen.setId(id);
            id++;
            queen.setColumn(column);
            queenList.add(queen);
        }
        return queenList;
    }
}
