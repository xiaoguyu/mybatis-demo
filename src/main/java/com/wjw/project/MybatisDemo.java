package com.wjw.project;

import com.wjw.project.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author wjw
 * @title: MybatisDemo
 * @date 2022/5/12 16:22
 */
public class MybatisDemo {

    public static void main(String[] args) throws Exception {
        // 配置文件路径
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1.读取配置，创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.通过工厂获取SqlSession
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 3.获取mapper代理对象
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            // 4.执行查询，此处才真正连接数据库
            System.out.println(mapper.selectByName("张三"));
//            System.out.println(mapper.selectByName("张三"));
        } finally {
            // 5.关闭连接
            session.close();
        }
    }
}
