package model.DTO;

public class StartEndPageDTO {
	Long startRow;
	Long endRow;
	
	// 값을 넣어주기 위한 생성자
	public StartEndPageDTO(Long startRow, Long endRow) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
	}

	// 값을 넘겨주기 위한 게터
	public Long getStartRow() {
		return startRow;
	}

	public Long getEndRow() {
		return endRow;
	}
	
}
