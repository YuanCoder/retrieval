package com.dot.fashion.retrieval.core.api;

/**
 * title:重试任务
 * author:吉
 * since:2018/12/19
 */
@FunctionalInterface
public interface Retryable<T> {

    T proceed(int round, long nanos) throws Exception;

    /**
     * proceed 报错时回调
     *
     * @param e     ex
     * @param round 重试次数
     * @param nanos 消耗时间
     * @return 是否跳出循环  true:跳出  false:继续
     */
    default boolean whenError(Throwable e, int round, long nanos) {
        return false;
    }

    /**
     * 执行结束时，返回结果处理
     *
     * @param ret proceed执行结果
     * @return 处理后结果
     */
    default T whenFinish(T ret, int round, long nanos) {
        return ret;
    }

    /**
     * 循环后置条件
     *
     * @param ret proceed执行结果
     * @return 是否  结束循环  true:结束循环  false:继续循环
     */
    default boolean postCondition(T ret, int round, long nanos) {
        return true;
    }


    /**
     * 循环前置条件
     *
     * @param round 重试次数
     * @return 是否  继续执行 true:继续循环 false:结束循环
     */
    default boolean preCondition(int round, long nanos) {
        return true;
    }

    /**
     * 超时
     */
    default void whenTimeout() {

    }

}
