package com.example.hibia.controller;

import com.example.hibia.domain.Item;
import com.example.hibia.dto.ItemDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.service.ItemService;
import com.example.hibia.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService itemService;
    private final ResponseService responseService;

    @GetMapping(value= "/{id}")
    public SingleResult<Item> findItem(@PathVariable Long id){
        return responseService.getSingleResult(itemService.findItem(id));
    }

    @GetMapping(value = "/")
    public ListResult<Item> findAllItem(){
        return responseService.getListResult(itemService.findAllItems());
    }

    @PostMapping(value = "/")
    public SingleResult<Item> saveItem(@RequestBody ItemDTO itemDTO){
        return responseService.getSingleResult(itemService.saveItem(itemDTO));
    }

    @PutMapping(value = "/{id}")
    public SingleResult<Item> updateItem(@RequestBody ItemDTO itemDTO, @PathVariable Long id){
        return responseService.getSingleResult(itemService.updateItem(id,itemDTO));
    }

    @DeleteMapping(value = "/{id}")
    public CommonResult deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return responseService.getSuccessResult();
    }
}
