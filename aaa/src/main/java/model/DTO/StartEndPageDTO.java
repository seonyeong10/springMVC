package model.DTO;

public class StartEndPageDTO {
	int startDataNum; // 시작행 1, 11, 21, 31, 41 ...
	int endDateNum; // 끝 행 10, 20, 30...

	public StartEndPageDTO(int startDataNum, int endDateNum) {
		super();
		this.startDataNum = startDataNum;
		this.endDateNum = endDateNum;
	}

	public int getStartDataNum() {
		return startDataNum;
	}

	public int getEndDateNum() {
		return endDateNum;
	}

}
