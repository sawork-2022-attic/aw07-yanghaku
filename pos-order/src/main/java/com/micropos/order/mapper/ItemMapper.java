package com.micropos.order.mapper;

import com.micropos.order.dto.ItemDto;
import com.micropos.order.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper
public interface ItemMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Collection<ItemDto> toCartDto(Collection<Item> items);

    Collection<Item> toCart(Collection<ItemDto> cartItems);

    ItemDto toItemDto(Item cartItem);

    Item toItem(ItemDto cartItem);
}
