package zw.co.tengahuku.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="ORDER_LINE")
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_ID")
	private Order order;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	private PoultryProduct poultryProduct;
	@Column(name="QUANTITY")
	private Long quantity;
}
