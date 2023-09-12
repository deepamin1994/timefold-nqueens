package com.deepamin.domain;

import ai.timefold.solver.core.api.score.buildin.simple.SimpleScore;
import ai.timefold.solver.core.api.score.stream.Constraint;
import ai.timefold.solver.core.api.score.stream.ConstraintFactory;
import ai.timefold.solver.core.api.score.stream.ConstraintProvider;

import static ai.timefold.solver.core.api.score.stream.Joiners.equal;

public class NQueensConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                horizontalConstraint(constraintFactory),
                verticalConstraint(constraintFactory),
                ascDiagonalConstraint(constraintFactory),
                descDiagonalConstraint(constraintFactory)
        };
    }

    private Constraint ascDiagonalConstraint(ConstraintFactory factory) {
        return factory
                .forEachUniquePair(Queen.class, equal(Queen::getAscendingDiagonalIndex))
                .penalize(SimpleScore.ONE)
                .asConstraint("Ascending diagonal constraint");
    }

    private Constraint descDiagonalConstraint(ConstraintFactory factory) {
        return factory
                .forEachUniquePair(Queen.class, equal(Queen::getDescendingDiagonalIndex))
                .penalize(SimpleScore.ONE)
                .asConstraint("Descending diagonal constraint");
    }

    private Constraint verticalConstraint(ConstraintFactory factory) {
        return factory
                .forEachUniquePair(Queen.class, equal(Queen::getColumnIndex))
                .penalize(SimpleScore.ONE)
                .asConstraint("Vertical constraint");
    }

    private Constraint horizontalConstraint(ConstraintFactory factory) {
        return factory
                .forEachUniquePair(Queen.class, equal(Queen::getRowIndex))
                .penalize(SimpleScore.ONE)
                .asConstraint("Horizontal constraint");
    }
}
