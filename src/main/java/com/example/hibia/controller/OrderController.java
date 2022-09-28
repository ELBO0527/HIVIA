package com.example.hibia.controller;

import com.example.hibia.domain.Order;
import com.example.hibia.dto.CartDTO;
import com.example.hibia.dto.OrderDTO;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.service.OrderService;
import com.example.hibia.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;
    private final ResponseService responseService;

    @GetMapping("/")
    public ListResult<Order> selectAllOrders(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();

        return responseService.getListResult(orderService.findAllOrderItems(uid));
    }

    @PostMapping("/{id}")
    public SingleResult<Order> addOrder(@PathVariable String id, @RequestBody OrderDTO orderDTO){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();

        return responseService.getSingleResult(orderService.addOrder(uid,orderDTO));
    }
}
