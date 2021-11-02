import java.io.Serializable;
import java.util.Scanner;

public class Product implements IProduct, Serializable{
	private String productId;
	private String productName;
	private String title;
	private float importPrice;
	private float exportPrice;
	private float frofit;
	private String descriptions;
	private boolean productStatus;
	private Categories catalog;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Product(String productId, String productName, String title, float importPrice, float exportPrice,
			float frofit, String descriptions, boolean productStatus, Categories catalog) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.title = title;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.frofit = frofit;
		this.descriptions = descriptions;
		this.productStatus = productStatus;
		this.catalog = catalog;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) throws Exception {
		if (productId.toLowerCase().startsWith("c") == false && productId.length() != 4) {
			throw new Exception("Mã sản phẩm bao gồm 4 ký tự, bắt đầu là ký tự “C” và là duy nhất");
		}
		for (Product pro : Data.productt) {
			if(pro.getProductId().equals(productId))
				throw new Exception("Ma san pham da ton tai");
		}
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) throws Exception {
		if(productName.length() <6 || productName.length() >50)
			throw new Exception("Ten san pham tu 6-50 ky tu");
		for (Product num : Data.productt) {
			if(num.getProductName() == productName) {
				throw new Exception("Ten san pham da ton tai");
			}
		}
		this.productName = productName;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) throws Exception {
		if(productName.length() <6 || productName.length() >30)
			throw new Exception("Tieu de san pham tu 6-30 ky tu");
		this.title = title;
	}


	public float getImportPrice() {
		return importPrice;
	}


	public void setImportPrice(float importPrice) throws Exception {
		if(importPrice <= 0)
			throw new Exception("Gia san pham la so thuc lon hon khong");
		this.importPrice = importPrice;
	}


	public float getExportPrice() {
		return exportPrice;
	}


	public void setExportPrice(float exportPrice) throws Exception {
		if(exportPrice < MIN_INTEREST_RATE)
			throw new Exception("giá bán sản phẩm là số thực và có giá trị lớn hơn giá bán ít nhất là MIN_INTEREST_RATE lần");
		this.exportPrice = exportPrice;
	}


	public float getFrofit() {
		return frofit;
	}


	public void setFrofit(float frofit) {
		this.frofit = frofit;
	}


	public String getDescriptions() {
		return descriptions;
	}


	public void setDescriptions(String descriptions) throws Exception {
		if(descriptions.length() == 0)
			throw new Exception("khi nhập không được để trống");
		this.descriptions = descriptions;
	}


	public boolean isProductStatus() {
		return productStatus;
	}


	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}


	public Categories getCatalog() {
		return catalog;
	}


	public void setCatalog(Categories catalog){
		
		this.catalog = catalog;
	}


	@Override
	public void inputData() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			try {
				System.out.println("Nhap ma san pham: ");
				this.setProductId(sc.nextLine()); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap ten san pham: ");
				this.setProductName(sc.nextLine()); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap tieu de san pham: ");
				this.setTitle(sc.nextLine());
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap gia nhap san pham: ");
				this.setImportPrice(Float.parseFloat(sc.nextLine())); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap gia ban san pham: ");
				this.setExportPrice(Float.parseFloat(sc.nextLine())); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap mo ta san pham: ");
				this.setDescriptions(sc.nextLine()); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			System.out.println("Nhap trang thai san pham: ");
			String sttt = sc.nextLine();
			if(sttt.equals("true") || sttt.equals("false") || sttt.equals("TRUE") || sttt.equals("FALSE")) {
			this.productStatus = Boolean.parseBoolean(sttt);
			check = true;
			} else {
				System.out.println("Trang thai phai la true|false");
				check = false;
			}
		} while (!check);
		do {
			System.out.println("Danh muc san pham: ");
			int id = Integer.parseInt(sc.nextLine());
			Categories d = null;
			for (Categories cat : Data.categoriess) {
				if(cat.getCatalogId()==id) {
					d = cat;
					check = true;
					break;
				} else {
					System.err.println("Danh muc san pham chua ton tai!");
					check = false;
				}
			}
			this.catalog = d;
		} while (!check);
//		System.out.println("Danh muc san pham: ");
//		int id = Integer.parseInt(sc.nextLine());
//		Categories d = null;
//		for (Categories cat : Data.categoriess) {
//			if(cat.getCatalogId()==id)
//				d = cat;
//		}
//		this.catalog = d;
	}

	@Override
	public void displayData() {
		// TODO Auto-generated method stub
		System.out.println("Ma san pham" + this.productId);
		System.out.println("Ten san pham: " + this.productName);
		System.out.println("Tieu de san pham: " + this.title);
		System.out.println("Gia nhap san pham: " + this.importPrice);
		System.out.println("Gia ban san pham: " + this.exportPrice);
		System.out.println("Loi nhuan san pham: " + this.frofit);
		System.out.println("Mo ta san pham: " + this.descriptions);
		System.out.println("Trang thai san pham: " + (this.productStatus?"Hoat dong":"Khong hoat dong"));
		
	}

	@Override
	public void calProfit() {
		// TODO Auto-generated method stub
		this.frofit = this.exportPrice - this.importPrice;
		
	}
	public void inputDataUpdate(Product s) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			try {
				System.out.println("Nhap ten san pham: ");
				s.setProductName(sc.nextLine()); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap tieu de san pham: ");
				s.setTitle(sc.nextLine());
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap gia nhap san pham: ");
				s.setImportPrice(Float.parseFloat(sc.nextLine())); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap gia ban san pham: ");
				s.setExportPrice(Float.parseFloat(sc.nextLine())); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			try {
				System.out.println("Nhap mo ta san pham: ");
				s.setDescriptions(sc.nextLine()); 
				check = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				check = false;
			}
		} while (!check);
		do {
			System.out.println("Nhap trang thai san pham: ");
			String sttt = sc.nextLine();
			if(sttt.equals("true") || sttt.equals("false") || sttt.equals("TRUE") || sttt.equals("FALSE")) {
			s.productStatus = Boolean.parseBoolean(sttt);
			check = true;
			} else {
				System.out.println("Trang thai phai la true|false");
				check = false;
			}
		} while (!check);
		System.out.println("Danh muc san pham: ");
		int id = Integer.parseInt(sc.nextLine());
		Categories d = null;
		for (Categories cat : Data.categoriess) {
			if(cat.getCatalogId()==id)
				d = cat;
		}
		s.catalog = d;
	}

}
