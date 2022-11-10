package edu.javacourse.studentorder.dao;

import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryDaoImplTest
{
    @BeforeClass
    public static void startUp() throws Exception {
        URL urlFirst = DictionaryDaoImplTest.class.getClassLoader()
                .getResource("student_project.sql");
        URL urlSecond = DictionaryDaoImplTest.class.getClassLoader()
                .getResource("student_data.sql");

        List<String> stringFirst = Files.readAllLines(Paths.get(urlFirst.toURI()));
        String sqlFirst = stringFirst.stream().collect(Collectors.joining());

        List<String> stringSecond = Files.readAllLines(Paths.get(urlSecond.toURI()));
        String sqlSecond = stringSecond.stream().collect(Collectors.joining());

        try (Connection connection = ConnectionBuilder.getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(sqlFirst);
            statement.executeUpdate(sqlSecond);
        }
    }

    @Test
    public void testExampleFirst() {
        System.out.println("TEST 1");
    }

    @Test
    public void testExampleSecond() {
        System.out.println("TEST 2");
    }

    @Test
    public void testExampleThird() {
        System.out.println("TEST 3");
    }
}
