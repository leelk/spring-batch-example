package me.leelkarunarathne.springbatchexample.config;

import me.leelkarunarathne.springbatchexample.entity.InputUser;
import me.leelkarunarathne.springbatchexample.entity.User;
import org.springframework.batch.item.ItemProcessor;

import java.util.Random;


public class Processor implements ItemProcessor<InputUser, User> {


    private final String fileName;


    public Processor(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public User process(InputUser item) throws Exception {

        System.out.println("SSSSS" + " " + fileName);

        Random random = new Random();
        return new User(random.nextInt(), item.getName(), item.getSalary());
    }
}



