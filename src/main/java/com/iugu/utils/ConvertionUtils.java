package com.iugu.utils;

import java.util.ArrayList;
import java.util.List;

import com.iugu.model.Item;
import com.iugu.responses.ItemResponse;

public abstract class ConvertionUtils {
	public static String booleanToString(boolean Value) {
		return Boolean.toString(Value);
	}
	
	public static Item itemResponseToItem(ItemResponse itemResponse) {
		Item item = new Item(itemResponse.getId(), itemResponse.getDescription(),itemResponse.getQuantity(), itemResponse.getPriceCents(), itemResponse.is_destroy());		
		return item;
	}
	
	public static List<Item> itemsResponseToItem(List<ItemResponse> itemsResponse) {
		List<Item> items = new ArrayList<>();
		for (ItemResponse itemResponse : itemsResponse) {
			items.add(itemResponseToItem(itemResponse));
		}		
		return items;
	}
}
