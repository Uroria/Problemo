package com.uroria.problemo.result;

import com.uroria.problemo.Problem;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public abstract sealed class Result<T> permits Result.Problematic, Result.Some, Result.None {
    private final T value;

    private Result(T value) {
        this.value = value;
    }

    public static <T> Result<T> of(@Nullable T value) {
        if (value == null) return new None<>();
        return new Some<>(value);
    }

    public static <T> Some<T> some(@NonNull T value) {
        return new Some<>(value);
    }

    public static <T> None<T> none() {
        return new None<>();
    }

    public static <T> Problematic<T> problem(@NonNull Problem problem) {
        return new Problematic<>(problem);
    }

    public abstract boolean isPresent();

    public abstract boolean isProblematic();

    public final Problematic<T> getAsProblematic() {
        if (!(this instanceof Result.Problematic<T> error)) {
            throw new UnsupportedOperationException("Result is not an error.");
        }
        return error;
    }

    public final @Nullable T get() {
        return this.value;
    }

    public final Result<T> ifPresent(Consumer<T> consumer) {
        if (isPresent()) consumer.accept(this.value);
        return this;
    }

    @Getter
    public static non-sealed class Problematic<T> extends Result<T> {
        private final Problem problem;

        private Problematic(Problem problem) {
            super(null);
            this.problem = problem;
        }

        @Override
        public boolean isPresent() {
            return false;
        }

        @Override
        public boolean isProblematic() {
            return true;
        }
    }

    public static non-sealed class Some<T> extends Result<T> {

        private Some(T value) {
            super(value);
        }

        @Override
        public boolean isPresent() {
            return true;
        }

        @Override
        public boolean isProblematic() {
            return false;
        }
    }

    public static non-sealed class None<T> extends Result<T> {

        private None() {
            super(null);
        }

        @Override
        public boolean isPresent() {
            return false;
        }

        @Override
        public boolean isProblematic() {
            return false;
        }
    }
}
