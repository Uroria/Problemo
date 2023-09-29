package com.uroria.problemo.internal;

import com.uroria.problemo.AbstractProblem;

import java.util.Optional;

public final class PlainProblem extends AbstractProblem {

    public PlainProblem(String cause) {
        super(3, cause);
    }

    @Override
    public Optional<Throwable> getError() {
        return Optional.empty();
    }
}
