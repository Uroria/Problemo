package com.uroria.problemo.internal;

import com.uroria.problemo.AbstractProblem;

import java.util.Optional;

public final class UnknownProblem extends AbstractProblem {
    public UnknownProblem(String cause) {
        super(0, cause);
    }

    @Override
    public Optional<Throwable> getError() {
        return Optional.empty();
    }
}
