package com.example.hibia.controller;

import com.example.hibia.advice.exception.CCartItemExistException;
import com.example.hibia.domain.Cart;
import com.example.hibia.dto.CartDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.repository.CartRepository;
import com.example.hibia.service.CartService;
import com.example.hibia.service.ResponseService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;
    private final CartRepository cartRepository;
    private final ResponseService responseService;

    
    @GetMapping("/")
    public ListResult<Cart> findCartList(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        return responseService.getListResult(cartService.findAllCartItems(uid));
    }

    @GetMapping("/{id}")
    public SingleResult<Cart> findCartItem(@PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        return responseService.getSingleResult(cartService.findCartItem(id));
    }

    @PostMapping("/{itemname}")
    public SingleResult<Cart> addCartItem(@PathVariable String itemname, @RequestBody CartDTO cartDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();

        return responseService.getSingleResult(cartService.addCartItem(itemname, uid, cartDTO));
    }

    @PutMapping("/{id}")
    public SingleResult<Cart> updateCartItem(@PathVariable Long id, @RequestBody CartDTO cartDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        return responseService.getSingleResult(cartService.updateCartItem(id, uid, cartDTO));
    }

    @DeleteMapping("/{id}")
    public CommonResult deleteCartItem(@PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        cartService.deleteCartItem(id, uid);
        return responseService.getSuccessResult();
    }
}
