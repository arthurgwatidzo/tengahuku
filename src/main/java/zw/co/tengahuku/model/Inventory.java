package zw.co.tengahuku.model;

import java.util.Date;

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
@Table(name="INVENTORY")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	private PoultryProduct poultryProduct;
	@Column(name="STOCK_IN")
	private Long stockIn;
	@Column(name="STOCK_OUT")
	private Long stockOut;
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;
	

}
