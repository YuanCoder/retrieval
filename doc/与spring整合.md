#与spring整合

> 确保扫描到`com.dot.fashion.retrieval.spring.aop`路径

### 使用方式

``` java
@Retrieval(retry = 3,
            delayMilli = 1000,
            module = RetryModule.ASYNC,
            timeLimitMilli = 15000,
            failOn = IllegalArgumentException.class,
            continueOn = IllegalAccessException.class)
    public String test(int a) {
        return "success";
    }
```

- 使用condition形式方式与spring整合
- 注解使用在方法上，该方法作为重试目标

