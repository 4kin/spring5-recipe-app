package guru.springframework.domain;

import org.springframework.util.Assert;

import java.util.Set;

public class test {
    public static void main(String[] args) {
        System.out.println(String.valueOf("category".equals("category")));

        Set<Integer> integerSet = null;
        Assert.notNull(integerSet, "Entities must not be null");
    }
}
