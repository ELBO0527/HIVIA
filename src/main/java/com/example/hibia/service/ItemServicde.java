package com.example.hibia.service;


import com.example.hibia.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServicde {

    private final ItemRepository itemRepository;



}
