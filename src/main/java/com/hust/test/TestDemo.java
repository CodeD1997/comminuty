package com.hust.test;

import com.hust.entity.DiscussPost;
import com.hust.entity.User;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        Book b1 = new Book("123",123);
        Book b2 = new Book("1234",1234);
        Person p1 = new Person("123Tom",123);
        Person p2 = new Person("1234Jerry",1234);
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        List<Map<String ,Object>> personsAndBooks = new ArrayList<>();
        for (Person person : persons) {
            Map<String, Object> map = new HashMap<>();
            map.put("person",person);
            Book book = books.get(1);
            map.put("book",book);
            personsAndBooks.add(map);
        }
        for (Map<String, Object> personsAndBook : personsAndBooks) {
            System.out.println(personsAndBook);
        }
    }

}
