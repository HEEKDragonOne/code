package com.tothefor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author DragonOne
 * @Date 2021/11/15 14:28
 */

@Getter
@Setter
public class Thing {
    private String thingName; //物品名称
    private String thingID; //物品ID
    private String tingTypeID; //物品类型ID
    private double thingPrice; //物品价格
    private int thingNumber; //物品数量
    private String fromUserID; //物品出售者PTID
    private String toUserID; //物品购买者PTID

}
