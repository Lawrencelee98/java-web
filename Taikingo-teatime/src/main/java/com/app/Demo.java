package com.app;

import com.app.myobjects.object1;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        String resource = "mybaits-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<object1> users = session.selectList("group10.resource.selectAll");
            System.out.println(users.get(0).getUsername());
            session.close();
//            object1 mapper = session.getMapper(object1.class);
//            object1 blog = mapper.selectAll(101);
        }
    }
}
