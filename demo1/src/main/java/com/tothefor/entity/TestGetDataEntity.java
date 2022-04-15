package com.tothefor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author DragonOne
 * @Date 2021/11/29 16:08
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestGetDataEntity {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "TestGetDataEntity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
