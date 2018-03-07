package zw.co.tengahuku.dto;

public class OrderLineDTO {

	private Long id;
	private OrderDTO order;
	private PoultryProductDTO poultryProduct;
	private Long quantity;

	public OrderLineDTO(Long id, OrderDTO order, PoultryProductDTO poultryProduct, Long quantity) {
		this.id = id;
		this.order = order;
		this.poultryProduct = poultryProduct;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public PoultryProductDTO getPoultryProduct() {
		return poultryProduct;
	}

	public void setPoultryProduct(PoultryProductDTO poultryProduct) {
		this.poultryProduct = poultryProduct;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
