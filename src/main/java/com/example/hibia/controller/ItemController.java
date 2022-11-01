package com.example.hibia.controller;

import com.example.hibia.domain.Item;
import com.example.hibia.dto.ItemDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.service.ItemService;
import com.example.hibia.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;
    private final ResponseService responseService;

    @GetMapping(value= "/user/{id}")
    public SingleResult<Item> findItem(@PathVariable Long id){
        return responseService.getSingleResult(itemService.findItem(id));
    }


    @GetMapping(value = "/user")
    public ListResult<Item> findAllItem(){
        return responseService.getListResult(itemService.findAllItems());
    }

    @GetMapping(value = "/userpage")
    public ListResult<Item> findAllItems(Pageable pageable){
        logger.info("log : <<"+ pageable +">>");
        return responseService.getListResult(itemService.findAllItemss(pageable));
    }

    @PostMapping(value = "/")
    public SingleResult<Item> saveItem(@RequestBody ItemDTO itemDTO, MultipartFile file){
        return responseService.getSingleResult(itemService.saveItem(itemDTO));
    }

    @PutMapping(value = "/{id}")
    public SingleResult<Item> updateItem(@PathVariable Long id,@RequestBody ItemDTO itemDTO){
        return responseService.getSingleResult(itemService.updateItem(id,itemDTO));
    }

    @DeleteMapping(value = "/{id}")
    public CommonResult deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return responseService.getSuccessResult();
    }
}
