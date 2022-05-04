package com.example.hibia.service;


import com.example.hibia.domain.Item;
import com.example.hibia.dto.ItemDTO;
import com.example.hibia.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }

    public Item findItem(Long id){
        return itemRepository.findById(id).orElseThrow();
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
