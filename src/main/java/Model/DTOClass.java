package Model;

public class DTOClass {
	private int id;
	private string name;
	public DTOClass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public DTOClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DTOClass [id=" + id + ", name=" + name + "]";
	}


}
