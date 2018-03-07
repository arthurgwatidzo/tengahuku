package zw.co.tengahuku.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="ORDER_DETAIL")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Column(name="UNIT_PRICE")
	private Double unitPrice;
	@Column(name="QUANTITY")
	private int quantity;
	@Column(name="DISCOUNT")
	private Double discount;

}
