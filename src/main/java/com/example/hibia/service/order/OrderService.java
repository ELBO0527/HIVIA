package com.example.hibia.service.order;

import com.example.hibia.advice.exception.CCartItemExistException;
import com.example.hibia.advice.exception.CResourceNotExistException;
import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.*;
import com.example.hibia.model.request.order.OrderDTO;
import com.example.hibia.model.response.user.UserResponse;
import com.example.hibia.repository.order.Item_OrderRepository;
import com.example.hibia.repository.order.OrderRepository;
import com.example.hibia.repository.user.UserRepository;
import com.example.hibia.service.user.UserService;
import com.example.hibia.service.cart.CartService;
import com.example.hibia.service.item.ItemService;
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
    private final UserRepository userRepository;
    private final UserService userService;
    private final CartService cartService;
    private final ItemService itemService;

    public List<Order> findAllOrderItems(long uid) {//주문내역 전체 조회
        return orderRepository.findByUser(userRepository.findById(uid).orElseThrow());
    }

    public Order findOrderItem(Long id) {//주문내역상세조회
        return orderRepository.findById(id).orElseThrow(CResourceNotExistException::new);
    }

    public Order addOrder(long userId, OrderDTO orderDTO) {//주문하기
        User user = userRepository.findById(userId).orElseThrow(CUserNotFoundException::new);

        List<Cart> cartList = cartService.findAllCartItems(user.getId());
        List<Item_order> itemOrderList = new ArrayList<>();

        int sum_cart = 0;

        for(Cart cart : cartList){
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

            //아이템수량제거
            Item item = itemService.findItem(cart.getItem().getName());
            item.setStock(cart.getItem().getStock() - cart.getQuantity());

            //장바구니 제거
            cartService.deleteCartItem(cart.getId(), user.getUsername());

            }else if (cart.getItem().getStock() < cart.getQuantity()){
                //수량이 적을시 예외 (수정필요)
                throw new CCartItemExistException();
            }
        }

        item_orderRepository.saveAll(itemOrderList);

        Order order = Order.builder()
                .needs(orderDTO.getNeeds())
                .price(sum_cart)
                .deliveryfee(orderDTO.getDeliveryfee())
                .totalprice(sum_cart + orderDTO.getDeliveryfee())
                .name(user.getUsername())
                .mobile(user.getMobile())
                .addr(user.getAddr())
                .addrdetail(user.getAddr_detail())
                .user(user)
                .order_status(orderDTO.getOrder_status())
                .build();

        //금액 차감
        user.setBalance(orderDTO.getTotalprice());

        return orderRepository.save(order);
    }
}
