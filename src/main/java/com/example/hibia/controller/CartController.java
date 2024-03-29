package com.example.hibia.controller;

import com.example.hibia.domain.Cart;
import com.example.hibia.domain.User;
import com.example.hibia.model.request.cart.CartDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.repository.cart.CartRepository;
import com.example.hibia.service.cart.CartService;
import com.example.hibia.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;
    private final CartRepository cartRepository;
    private final ResponseService responseService;


    @GetMapping("/")
    public ListResult<Cart> findCartList(Principal principal){
        return responseService.getListResult(cartService.findAllCartItems(((User) principal).getId()));
    }

    @GetMapping("/{id}")
    public SingleResult<Cart> findCartItem(@PathVariable Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();
        return responseService.getSingleResult(cartService.findCartItem(id));
    }

    @PostMapping("/{itemname}")
    public SingleResult<Cart> addCartItem(@PathVariable String itemname, @RequestBody CartDTO cartDTO, Authentication authentication, @RequestParam(value = "ko",required = false) String lang){
        User user = (User) authentication.getPrincipal();
        return responseService.getSingleResult(cartService.addCartItem(itemname, user.getId(), cartDTO));
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
