package com.example.hibia.model.request.order;

import com.example.hibia.domain.User;
import lombok.Data;

@Data
public class OrderDTO {

    private Long id;
    private String needs;
    private int price;
    private int deliveryfee;
    private int totalprice;
    private String name;
    private String mobile;
    private String addr;
    private String addrdetail;
    private int order_status;
    private User user;
}
