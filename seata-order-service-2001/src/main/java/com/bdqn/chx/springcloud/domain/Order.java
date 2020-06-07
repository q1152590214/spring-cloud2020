package com.bdqn.chx.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order  implements Serializable {

    private int id;
    private  int userId;
    private int productId;
    private  int count;
    private  double money;
    private  int seata;

}
