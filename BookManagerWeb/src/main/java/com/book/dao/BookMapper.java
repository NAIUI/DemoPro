package com.book.dao;

import com.book.entity.Book;
import com.book.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    @Results({
            @Result(column = "bid", property = "book_id"),
            @Result(column = "title", property = "book_name"),
            @Result(column = "time", property = "time"),
            @Result(column = "name", property = "student_name"),
            @Result(column = "sid", property = "student_id"),
            @Result(column = "id", property = "borrow_id")
    })
    @Select("select * from borrow, student, book where borrow.sid = student.sid and borrow.bid = book.bid")
    List<Borrow> getBorrowList();

    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(String id);

    @Select("select * from book")
    List<Book> getBookList();

    @Insert("insert into borrow(sid,bid,time) values(#{sid},#{bid},NOW())")
    void addBorrow(@Param("sid") int sid, @Param("bid") int bid);

    @Delete("delete from book where bid = ${bid}")
    void deleteBook(int bid);

    @Insert("insert into book(title,`desc`,price) values(#{title},#{desc},#{price})")
    void addBook(@Param("title") String title,@Param("desc") String desc,@Param("price") double price);
}
