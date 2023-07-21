package com.github.mrs.strategy;

/**
 * description: 查询红包发放方式
 * date: 2023/7/21 11:40
 * author: MR.孙
 */
public class Shopping implements Strategy{
    @Override
    public String query() {
        return "查询红包发放方式";
    }
}
