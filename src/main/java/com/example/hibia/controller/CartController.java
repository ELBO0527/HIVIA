package com.example.hibia.controller;

import com.example.hibia.domain.Cart;
import com.example.hibia.dto.CartDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.service.CartService;
import com.example.hibia.service.ResponseService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;
    private final ResponseService responseService;

    @GetMapping("/{email}/{id}")
    public ListResult<Cart> findCartList(@PathVariable String email, Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        return responseService.getListResult(cartService.findAllCartItems(email,id));
    }

    @GetMapping("/{id}")
    public SingleResult<Cart> findCartItem(@PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        return responseService.getSingleResult(cartService.findCartItem(id));
    }

    @PostMapping("/{name}")
    public SingleResult<Cart> addCartItem(@PathVariable String name, @RequestBody CartDTO cartDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        return responseService.getSingleResult(cartService.createCartItem(name, uid, cartDTO));
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
