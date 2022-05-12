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
@Intercepts({
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})
})
public class SqlLogPlugin implements Interceptor {
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

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // 这是xml中配置的参数
        System.out.println(properties.propertyNames());
    }
}
