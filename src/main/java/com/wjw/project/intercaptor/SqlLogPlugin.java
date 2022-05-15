package com.wjw.project.intercaptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author wjw
 * @description: 测试插件类
 * @title: SqlLogPlugin
 * @date 2022/5/12 16:28
 */
// 注解配置需要拦截的类以及方法
@Intercepts({
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})
})
// 实现Interceptor接口
public class SqlLogPlugin implements Interceptor {

    /**
     * 具体的拦截逻辑
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long begin = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            long time = System.currentTimeMillis() - begin;
            System.out.println("sql 运行了 ：" + time + " ms");
        }
    }

    /**
     * 判断是否需要进行代理
     * 此方法有默认实现，一般无需重写
     */
    /*@Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }*/

    /**
     * 自定义参数
     */
    @Override
    public void setProperties(Properties properties) {
        // 这是xml中配置的参数
        properties.forEach((k, v) -> {
            System.out.printf("SqlLogPlugin---key:%s, value:%s%n", k, v);
        });
    }
}
