package com.qcommerce.backend.service;

import com.qcommerce.backend.dto.request.ItemRequest;
import com.qcommerce.backend.dto.response.ItemResponse;
import com.qcommerce.backend.dto.response.PageResponse;
import com.qcommerce.backend.entity.Category;
import com.qcommerce.backend.entity.Item;
import com.qcommerce.backend.exception.ResourceNotFoundException;
import com.qcommerce.backend.mapper.ItemMapper;
import com.qcommerce.backend.mapper.PageMapper;
import com.qcommerce.backend.repository.CategoryRepository;
import com.qcommerce.backend.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public PageResponse<ItemResponse> getItems(String search, String categoryId, Double minPrice, Double maxPrice,
                                               Boolean active, int pageSize, int pageNumber, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                sortDir.equalsIgnoreCase("asc")
                        ? Sort.by(Sort.Direction.ASC, sortBy)
                        : Sort.by(Sort.Direction.DESC, sortBy));

        Page<Item> pageItem = itemRepository.searchItems(search, categoryId, minPrice, maxPrice, active, pageable);
        Page<ItemResponse> pageItemResponse = pageItem.map(ItemMapper::toResponse) ;
        return PageMapper.toResponse(pageItemResponse);
    }

    public ItemResponse getItemById(String itemId){
        Item itemById=itemRepository.findById(itemId)
                .orElseThrow(()->new ResourceNotFoundException("Item Not Found"));

        return ItemMapper.toResponse(itemById);
    }

    public void deleteItemById(String itemId){
        Item itemById=findByIdOrElseThrow(itemId);
        itemRepository.delete(itemById);

    }


    public ItemResponse createItem(@Valid ItemRequest itemRequest) {
        Category cayegoryById=findByCategoryIdOrElseThrow(itemRequest.categoryId());
        Item newItem=ItemMapper.toEntity(itemRequest,cayegoryById);
        Item savedItem=itemRepository.save(newItem);
        return ItemMapper.toResponse(savedItem);
    }
    private Item findByIdOrElseThrow(String itemId){
        return itemRepository.findById(itemId)
                .orElseThrow(()->new ResourceNotFoundException("Item Not Found"));
    }

    private Category findByCategoryIdOrElseThrow(String categoryId){
        return categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
    }

    public ItemResponse updateItem(String itemId, ItemRequest itemRequest) {
        findByIdOrElseThrow(itemId);

        Category categoryById=findByCategoryIdOrElseThrow(itemRequest.categoryId());

        Item existingItem=ItemMapper.toEntity(itemRequest,categoryById);
        existingItem.setItemId(itemId);

        Item updateItem=itemRepository.save(existingItem);
        return  ItemMapper.toResponse(updateItem);
    }
}