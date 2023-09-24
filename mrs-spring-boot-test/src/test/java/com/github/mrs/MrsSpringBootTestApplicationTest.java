package com.github.mrs;

import com.github.mrs.po.Person;
import com.github.mrs.service.MyJsonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * date: 2023/9/24 15:30
 * author: MR.孙
 */
@SpringBootTest
public class MrsSpringBootTestApplicationTest {

    @Autowired
    MyJsonService myJsonService;

    @Test
    void test1() {
        Person person = new Person("Mr.nobody", 18, "拉斯维加斯");
        String json = myJsonService.objectToMyJson(person);
        System.out.println(json);
    }

}
