import java.io.Serializable;
import java.util.Scanner;

public class Categories implements ICategories, Serializable{
	private int catalogId; 
	private String catalogName;
	private String descriptions;
	private boolean catalogStatus;
	private int parentId;
	

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categories(int catalogid, String catalogName, String descriptions, boolean catalogStatus, int parentId) {
		super();
		this.catalogId = catalogid;
		this.catalogName = catalogName;
		this.descriptions = descriptions;
		this.catalogStatus = catalogStatus;
		this.parentId = parentId;
	}


	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogid(int catalogid) throws Exception{
		if(catalogid <0)
			throw new Exception("Phai la so nguyen lon hon khong");
		this.catalogId = catalogid;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) throws Exception{
		if (catalogName.length() <6 || catalogName.length() >30) {
			throw new Exception("Ten phong ban toi thieu 6 va lon nhat 30 ky tu");
		}
		this.catalogName = catalogName;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) throws Exception{
		if(descriptions.length() ==0)
			throw new Exception("khong duoc bo trong");
		this.descriptions = descriptions;
	}

	public boolean isCatalogStatus(){
		return catalogStatus;
	}

	public void setCatalogStatus(boolean catalogStatus) {
		this.catalogStatus = catalogStatus;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) throws Exception{
		if(parentId != 0) {
		boolean check = false;
		for (Categories paty : Data.categoriess) {
			if(paty.getCatalogId() == parentId) {
				check = true;
				break;
			}
		}
		if(check == false) {
			throw new Exception("Ma danh muc khong ton tai");
		}
		}
		this.parentId = parentId;
	}
	

	@Override
	public void inputData() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			try {
				System.out.println("Nhap ma danh muc: ");
				this.setCatalogid(Integer.parseInt(sc.nextLine()));
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		
		do {
			try {
				System.out.println("Nhap ten danh muc ");
				this.setCatalogName(sc.nextLine()); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap mo ta danh muc: ");
				this.setDescriptions(sc.nextLine());
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			System.out.println("Nhap trang thai danh muc: ");
			String stt = sc.nextLine();
			if(stt.equals("true") || stt.equals("false") || stt.equals("TRUE") || stt.equals("FALSE")) {
				this.catalogStatus = Boolean.parseBoolean(stt);
			check = true;
			} else {
				System.out.println("Trang thai phai la true|false");
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap ma danh muc cha: ");
				this.setParentId(Integer.parseInt(sc.nextLine()));
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		System.out.println("------------------");
	}

	@Override
	public void displayData() {
		// TODO Auto-generated method stub
		System.out.println("Ma danh muc: " + this.catalogId);
		System.out.println("Ten danh muc: " + this.catalogName);
		System.out.println("Mo ta danh muc: " + this.descriptions);
		System.out.println("Trang thai danh muc: " + (this.catalogStatus ? "Hoat dong":"Khong hoat dong"));
		System.out.println("Danh muc cha: " + this.parentId);
		
	}

	

}
