package org.txazo.project.mini.mybatis.executor;

public class CachingExecutor implements Executor {

    private Executor delegate;

    public CachingExecutor(Executor delegate) {
        this.delegate = delegate;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public Object query() {
        return null;
    }

}
