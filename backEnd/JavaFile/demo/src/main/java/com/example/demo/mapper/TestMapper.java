package com.example.demo.mapper;

import com.example.demo.model.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-14 21:05
 */
@Mapper
public interface TestMapper {
    @Select("select id, value " +
            "from " +
            "test " +
            "where id = #{id}")
    TestDto queryTest(int id);
}
