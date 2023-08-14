package fpoly.edu.assignment_java5.service.Impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fpoly.edu.assignment_java5.identity.CartItem;
import fpoly.edu.assignment_java5.service.order.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	Map<Long, CartItem> maps = new HashMap<>();
	
	@Override
	public void add(CartItem item) {
		
		CartItem cartItem = maps.get(item.getBookId());
		
		if (cartItem == null) {
			maps.put(item.getBookId(), item);
		} else {
			cartItem.setQty(cartItem.getQty() + 1);
		}		
	}
	
	@Override
	public void remove(Long id) {
		maps.remove(id);
	}
	
	@Override
	public CartItem update(Long bookId, long qty) {
		CartItem cartItem = maps.get(bookId);
		cartItem.setQty(qty);	
		return cartItem;
	}
	
	@Override
	public void clear() {
		maps.clear();
	}
	
	@Override
	public Collection<CartItem> getAllItems(){
		return maps.values();
	}
	
	@Override
	public long getCount() {
		return maps.values().size();
	}
	
	@Override
	public Long getAmount() {
		return maps.values().stream()
				.mapToLong(item -> item.getQty() * item.getBookPrice())
				.sum();
	}
	
}
