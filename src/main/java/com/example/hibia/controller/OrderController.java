package com.example.hibia.controller;

import com.example.hibia.domain.Order;
import com.example.hibia.domain.User;
import com.example.hibia.model.request.order.OrderDTO;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.model.response.order.ItemOrderResponse;
import com.example.hibia.service.order.Item_OrderService;
import com.example.hibia.service.order.OrderService;
import com.example.hibia.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;
    private final Item_OrderService itemOrderService;
    private final ResponseService responseService;

    @GetMapping("/")
    public ListResult<Order> selectAllOrders(Principal principal){
        User user = (User) principal;
        return responseService.getListResult(orderService.findAllOrderItems(user.getId()));
    }

    //단건 주문
    @PostMapping("/{id}")
    public SingleResult<Order> addOrder(Authentication authentication, @RequestBody OrderDTO orderDTO){
        User user = (User) authentication.getPrincipal();
        return responseService.getSingleResult(orderService.addOrder(user.getId(),orderDTO));
    }
    
    //수정 주문
    //주문 취소
    //주문 상세
}
