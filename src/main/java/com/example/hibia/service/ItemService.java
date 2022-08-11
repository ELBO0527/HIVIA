package com.example.hibia.service;


import com.example.hibia.advice.exception.ResourceNotFoundException;
import com.example.hibia.domain.Item;
import com.example.hibia.dto.ItemDTO;
import com.example.hibia.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }

    //아이템 이름 id값으로 단일 조회, 아래 함수와 오버로딩
    public Item findItem(Long id){
        return itemRepository.findById(id).orElseThrow(null);
    }

    //아이템 이름 이름값으로 단일 조회, 윗 함수 오버로딩
    public Item findItem(String itemName){
        return Optional.ofNullable(itemRepository.findByName(itemName)).orElseThrow(ResourceNotFoundException::new);
    }

    public Item saveItem(ItemDTO itemDTO){
        Item item = Item.builder()
                .name(itemDTO.getName())
                .brand(itemDTO.getBrand())
                .stars(itemDTO.getStars())
                .color(itemDTO.getColor())
                .country(itemDTO.getCountry())
                .price(itemDTO.getPrice())
                .stock(itemDTO.getStock())
                .prodDate(itemDTO.getProdDate())
                .size(itemDTO.getSize())
                .build();

        return itemRepository.save(item);
    }

    public Item updateItem(Long id,ItemDTO itemDTO){
        Item item = findItem(id);
        item.setItem(itemDTO.getName(), itemDTO.getCountry(), itemDTO.getColor(), itemDTO.getBrand(), itemDTO.getPrice(), itemDTO.getStars(), itemDTO.getStock(), itemDTO.getSize(), itemDTO.getProdDate());

        return item;
    }

    public void deleteItem(Long id){
        this.findItem(id);
        itemRepository.deleteById(id);
    }
}
