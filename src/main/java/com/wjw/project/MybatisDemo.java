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
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            System.out.println(mapper.selectByName("张三"));
        } finally {
            session.close();
        }
    }
}
