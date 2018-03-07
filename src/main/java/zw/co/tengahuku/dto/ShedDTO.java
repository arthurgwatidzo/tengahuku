package zw.co.tengahuku.dto;

public class ShedDTO {
	
	private Long id;
	private String name;
	private String birdCapacity;
	private String initialBirdCount;
	private String batchLoadingDate;
	
	
	
	public ShedDTO(Long id, String name, String birdCapacity, String initialBirdCount, String batchLoadingDate) {
		
		this.id = id;
		this.name = name;
		this.birdCapacity = birdCapacity;
		this.initialBirdCount = initialBirdCount;
		this.batchLoadingDate = batchLoadingDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirdCapacity() {
		return birdCapacity;
	}
	public void setBirdCapacity(String birdCapacity) {
		this.birdCapacity = birdCapacity;
	}
	public String getInitialBirdCount() {
		return initialBirdCount;
	}
	public void setInitialBirdCount(String initialBirdCount) {
		this.initialBirdCount = initialBirdCount;
	}
	public String getBatchLoadingDate() {
		return batchLoadingDate;
	}
	public void setBatchLoadingDate(String batchLoadingDate) {
		this.batchLoadingDate = batchLoadingDate;
	}
	
	

}
