package Dto;

public class StuffDto {

	private int num;
	private int price;
	private int kind;
	private String name;

	public StuffDto() {
	}

	public StuffDto(int num, String name, int price, int kind) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.kind = kind;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getKind() {
		return kind;
	}
}
