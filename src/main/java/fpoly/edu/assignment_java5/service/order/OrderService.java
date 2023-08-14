package fpoly.edu.assignment_java5.service.order;

import java.util.Collection;

import fpoly.edu.assignment_java5.identity.CartItem;

public interface OrderService {

	Long getAmount();

	long getCount();

	Collection<CartItem> getAllItems();

	void clear();

	CartItem update(Long bookId, long qty);

	void remove(Long id);

	void add(CartItem item);

}
