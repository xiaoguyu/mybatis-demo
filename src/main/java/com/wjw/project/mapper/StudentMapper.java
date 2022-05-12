package com.wjw.project.mapper;

import com.wjw.project.entity.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @author wjw
 * @description: 学生dao
 * @title: StudentMapper
 * @date 2022/5/12 16:11
 */
public interface StudentMapper {

    Student selectByName(@Param("name") String name);

}
