package baidu.giftshop.bean;

public class Base<T> {
	
	private String result;
	
	private Integer code;
	
	private T content;
	
	private T list;
	
	public Base(String result, Integer code, T content) {
		super();
		this.result = result;
		this.code = code;
		this.content = content;
	}
	
	public Base(String result, Integer code, T content, T list) {
		super();
		this.result = result;
		this.code = code;
		this.content = content;
		this.list = list;
	}


	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	

	public T getList() {
		return list;
	}

	public void setList(T list) {
		this.list = list;
	}

	public Base() {
		super();
	}
}
