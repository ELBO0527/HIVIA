package com.example.hibia.service.cart;

import com.example.hibia.advice.exception.CCartItemExistException;
import com.example.hibia.advice.exception.CResourceNotExistException;
import com.example.hibia.advice.exception.CUserNotFoundException;
import com.example.hibia.domain.Cart;
import com.example.hibia.domain.Item;
import com.example.hibia.domain.User;
import com.example.hibia.model.request.cart.CartDTO;
import com.example.hibia.repository.cart.CartRepository;
import com.example.hibia.service.item.ItemService;
import com.example.hibia.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final UserService userService;
    private final ItemService itemService;

    public List<Cart> findAllCartItems(String name){//장바구니 전체 조회
        return cartRepository.findByUser(userService.findUser(name));
    }

    public Cart findCartItem(Long id){//단건조회
        return cartRepository.findById(id).orElseThrow(CResourceNotExistException::new);
    }

    public Cart addCartItem(String itemname, String email, CartDTO cartDTO){//장바구니 추가

        Item item = itemService.findItem(itemname);
        User user = userService.findUser(email);
        /*
        * 아래 코드처럼 코드 짜니 장바구니에 담았을 때 해당 사용자 + 아이템에 대한 validation을 하는 것이 아닌
        * 장바구니에 유저 상관없이 아이템만 있을 때 예외가 터짐, repository에서
        * */
        //Cart ValidCart = cartRepository.findByItem(item);
        Cart ValidCart = cartRepository.findByItemAndUser(item, user);

        if (ValidCart != null){
            throw new CCartItemExistException();
        }

        Cart cart = Cart.builder()
                .user(user)
                .item(item)
                .quantity(cartDTO.getQuantity())
                .total(item.getPrice() * cartDTO.getQuantity())
                .build();
        return cartRepository.save(cart);
    }

    public Cart updateCartItem(long id, String uid, CartDTO cartDTO){//장바구니 수정
        Cart cart = findCartItem(id);
        User user = cart.getUser();
        if (!uid.equals(user.getEmail())){
            throw new CUserNotFoundException();
        }
        cart.setCart(cartDTO.getQuantity());
        return cart;
    }

    public boolean deleteCartItem(Long id, String uid) {//장바구니 내용 삭제
        Cart cart = findCartItem(id);
        User user = cart.getUser();
        if (!uid.equals(user.getUsername())) {
            throw new CUserNotFoundException();
        }
        cartRepository.delete(cart);

        return true;
    }
}
