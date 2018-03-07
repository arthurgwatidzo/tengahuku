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
@Table(name="PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	@Column(name="PAYMENT_DATE")
	private Date paymentDate;
	@Column(name="PAYMENT_AMOUNT")
	private Double paymentAmount;
	@Column(name="PAYMENT_DESCRIPTION")
	private String paymentDescription;
	@Column(name="PAYMENT_TYPE")
	private String paymentType;

}
