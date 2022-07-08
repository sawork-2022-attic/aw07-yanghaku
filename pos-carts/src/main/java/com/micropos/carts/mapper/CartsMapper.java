package com.micropos.carts.mapper;

import com.micropos.carts.dto.ItemDto;
import com.micropos.carts.model.Item;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper
public interface CartsMapper {
    Collection<ItemDto> toCartDto(Collection<Item> items);

    Collection<Item> toCart(Collection<ItemDto> cartItems);

    ItemDto toItemDto(Item cartItem);

    Item toItem(ItemDto cartItem);
}
