package book.test;

import book.manage.sql.SqlUtil;
import org.junit.jupiter.api.Test;

public class MainTset {
    @Test
    public void test1(){
        SqlUtil.doSqlWord(mapper->{
            mapper.getBorrowList().forEach(System.out::println);
        });
    }
}
