package com.nhpatt.asde.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    public static final int N_THREADS = 3;
    private static ExecutorService executor;

    public synchronized static ExecutorService getExecutor() {
        if (executor == null) {
            executor = Executors.newFixedThreadPool(N_THREADS);
        }
        return executor;
    }

    public static void execute(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("Runnable to execute cannot be null");
        }
        getExecutor().execute(runnable);
    }

}
