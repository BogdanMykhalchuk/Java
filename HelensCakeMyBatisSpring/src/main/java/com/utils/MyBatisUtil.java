package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;

/**
 * Created by Dreawalker on 05.08.2017.
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis-config.xml";
        try(InputStream inputStream = Resources.getResourceAsStream(resource)){
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    public static <T, M> T test(Class<M> mapperClass, Function<M, T> function) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        M mapper = session.getMapper(mapperClass);
        T result = function.apply(mapper);
        session.commit();
        session.close();
        return result;
    }

    public static <T, M> T testSearch(Class<M> mapperClass, Function<M, T> function) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        M mapper = session.getMapper(mapperClass);
        T result = function.apply(mapper);
        session.close();
        return result;
    }
}
