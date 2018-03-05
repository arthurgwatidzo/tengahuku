package zw.co.tengahuku.model;

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
@Table(name="SHED")
public class Shed {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Column(name="NAME")
	private String name;
	@Column(name="BIRD_CAPACITY")
	private String birdCapacity;
	@Column(name="INITIAL_BIRD_COUNT")
	private String initialBirdCount;
	@Column(name="BATCH_LOADING_DATE")
	private String batchLoadingDate;
	

}
