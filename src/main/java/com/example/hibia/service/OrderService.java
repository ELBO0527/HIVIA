package com.example.hibia.service;

import com.example.hibia.advice.exception.CResourceNotExistException;
import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.Cart;
import com.example.hibia.domain.Order;
import com.example.hibia.domain.Item;
import com.example.hibia.domain.User;
import com.example.hibia.dto.CartDTO;
import com.example.hibia.dto.OrderDTO;
import com.example.hibia.repository.OrderRepository;
import com.example.hibia.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final CartService cartService;

    public List<Order> findAllOrderItems(String name) {//주문내역 전체 조회
        return orderRepository.findByUser(userService.findUser(name));
    }

    public Order findOrderItem(Long id) {//주문내역상세조회
        return orderRepository.findById(id).orElseThrow(CResourceNotExistException::new);
    }

    public Order addOrder(String itemname, String email, OrderDTO orderDTO,CartDTO cartDTO) {//주문하기
        Cart cart = cartService.findCartItem(cartDTO.getId());
        Order order = new Order();
        return null;
    }
    
    public Order returnOrder(Long id, String uid, OrderDTO OrderDTO) {//주문 환불
        Order Order = findOrderItem(id);
        User user = Order.getUser();
        if (!uid.equals(user.getEmail())) {
            new CUserNotFoundException();
        }

        return null;
    }


    public Order cancleOrder(Long id, String uid, OrderDTO OrderDTO) {//주문 취소
        Order Order = findOrderItem(id);
        User user = Order.getUser();
        if (!uid.equals(user.getEmail())) {
            new CUserNotFoundException();
        }

        return null;
    }
    
    public boolean deleteOrderItem(Long id, String uid) {//주문 내용 삭제
        Order Order = findOrderItem(id);

        return true;
    }
}
