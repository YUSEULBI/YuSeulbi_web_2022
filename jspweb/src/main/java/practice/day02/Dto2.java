package practice.day02;

public class Dto2 {
	private String name;
	private String phone; 
	private double height; 
	private int age;
	private String registDate;
	private String manwoman;
	private boolean privacy;
	private String region; 
	private String introduce;
	
	public Dto2() {
		// TODO Auto-generated constructor stub
	}

	public Dto2(String name, String phone, double height, int age, String registDate, String manwoman, boolean privacy,
			String region, String introduce) {
		super();
		this.name = name;
		this.phone = phone;
		this.height = height;
		this.age = age;
		this.registDate = registDate;
		this.manwoman = manwoman;
		this.privacy = privacy;
		this.region = region;
		this.introduce = introduce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getManwoman() {
		return manwoman;
	}

	public void setManwoman(String manwoman) {
		this.manwoman = manwoman;
	}

	public boolean isPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
	
}
