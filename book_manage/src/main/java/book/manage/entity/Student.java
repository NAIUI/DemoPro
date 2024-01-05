package book.manage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    int sid;
    String sex;
    int grade;
    String name;

    public Student(String sex, int grade, String name) {
        this.sex = sex;
        this.grade = grade;
        this.name = name;
    }
}
