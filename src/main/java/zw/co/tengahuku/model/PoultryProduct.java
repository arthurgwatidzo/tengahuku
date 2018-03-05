package zw.co.tengahuku.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@Table(name="POULTRY_PRODUCT")
public class PoultryProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="QUANTITY_PER_UNIT")
	private int quantityPerUnit;
	@Column(name="UNIT_PRICE")
	private double unitPrice;
	@Column(name="UNITS_IN_STOCK")
	private Long unitsInStock;
	@Column(name="UNITS_ON_ORDER")
	private Long unitsOnOrder;
	@Column(name="DISCONTINUED")
	private Boolean discontinued;
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="poultryProduct")
    private List<Inventory> inventories;
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="poultryProduct")
    private List<OrderLine> orderLines;
}
