package com.example.hibia.service;

import com.example.hibia.advice.exception.CCartItemExistException;
import com.example.hibia.advice.exception.CResourceNotExistException;
import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.*;
import com.example.hibia.dto.Item_OrderDTO;
import com.example.hibia.dto.OrderDTO;
import com.example.hibia.repository.CartRepository;
import com.example.hibia.repository.Item_OrderRepository;
import com.example.hibia.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final Item_OrderRepository item_orderRepository;
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final CartService cartService;
    private final CartRepository cartRepository;
    private final ItemService itemService;

    public List<Order> findAllOrderItems(String name) {//주문내역 전체 조회
        return orderRepository.findByUser(userService.findUser(name));
    }

    public Order findOrderItem(Long id) {//주문내역상세조회
        return orderRepository.findById(id).orElseThrow(CResourceNotExistException::new);
    }

    public Order addOrder(String name, OrderDTO orderDTO) {//주문하기
        User user = userService.findUser(name);
        if (!name.equals(user.getUsername())) {
            new CUserNotFoundException();
        }

        List<Cart> cartList = cartService.findAllCartItems(name);
        List<Item_order> itemOrderList = new ArrayList<>();

        int sum_cart = 0;

        for(Cart cart : cartList){

            System.out.println(cart.getItem().getName());
            //아이템 수량 체크
            if (cart.getItem().getStock() >= cart.getQuantity()){
            //item_order 저장
            Item_order itemOrder = Item_order.builder()
                    .item(cart.getItem())
                    .name(cart.getItem().getName())
                    .price(cart.getItem().getPrice())
                    .quantity(cart.getQuantity())
                    .total(cart.getTotal())
                    .build();

            sum_cart += itemOrder.getTotal();
            itemOrderList.add(itemOrder);
            item_orderRepository.saveAll(itemOrderList);

            //아이템수량제거
            Item item = itemService.findItem(cart.getItem().getName());
            item.setStock(cart.getItem().getStock() - cart.getQuantity());

            //장바구니 제거
            cartService.deleteCartItem(cart.getId(), user.getUsername());

            }else if (cart.getItem().getStock() < cart.getQuantity()){
                //수량이 적을시 예외 (수정필요)
                new CCartItemExistException();
            }
        }

        Order order = Order.builder()
                .needs(orderDTO.getNeeds())
                .price(sum_cart)
                .deliveryfee(orderDTO.getDeliveryfee())
                .totalprice(sum_cart + orderDTO.getDeliveryfee())
                .name(user.getUsername())
                .mobile(user.getMobile())
                .addr(user.getAddr())
                .addrdetail(user.getAddr_detail())
                .user(userService.findUser(name))
                .build();

        return orderRepository.save(order);
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
