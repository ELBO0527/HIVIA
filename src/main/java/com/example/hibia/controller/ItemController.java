package com.example.hibia.controller;

import com.example.hibia.domain.Item;
import com.example.hibia.dto.ItemDTO;
import com.example.hibia.model.response.CommonResult;
import com.example.hibia.model.response.ListResult;
import com.example.hibia.model.response.SingleResult;
import com.example.hibia.service.ItemService;
import com.example.hibia.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    /*
    * 페이징 추가한 전체 검색
    * ?page={숫자}&size={숫자}
    * pageableDefault size = 7로 변경 (10기본, 7로 그냥 한번 바꿔보았다 써보고싶어서), 사이즈를 따로 지정하면 변경됨
     */
    @GetMapping(value = "/")
    public ListResult<Item> findAllItems(@PageableDefault(size = 7) Pageable pageable){
        logger.info("log : <<"+ pageable +">>");
        return responseService.getListResult(itemService.findAllItemss(pageable));
    }
    
    /*
    * id값으로 내림차순 정렬 기능, 어떻게 동적으로 백엔드에서 구현할지 고민해봐야겟다.
    * +api를 여러개 찍어놓으면 프론트에서 동적으로 처리되는 것처럼 보일 순 있을 것 같다.
     */

    @GetMapping(value= "/search")
    public ListResult<Item> findByName(String keyword, @PageableDefault(size = 10,sort = "id",direction = Sort.Direction.DESC)
    Pageable pageable){
        logger.info("keyword : <<"+ keyword +">>");
        logger.info("pageable : <<"+ pageable +">>");
        //Page<Item> pageList = itemService.findByItemnameDesc(keyword, pageable);
        return responseService.getListResult(itemService.findByItemnameDesc(keyword, pageable));
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
