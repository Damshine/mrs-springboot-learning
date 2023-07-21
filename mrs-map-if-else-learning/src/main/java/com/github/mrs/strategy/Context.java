package com.github.mrs.strategy;

/**
 * description:
 * date: 2023/7/21 11:41
 * author: MR.孙
 */
public class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public String query() {
        return strategy.query();
    }
}
