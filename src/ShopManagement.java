import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Data.readCategoriess();
		Data.readProduct();
		mainMenu(sc);
	}
	public static void mainMenu(Scanner sc) {
		System.out.println("*************************MENU*************************");
		System.out.println("1. Quan ly danh muc ");
		System.out.println("2. Quan ly san pham  ");
		System.out.println("3. Thoat ");
		System.out.println("Su lua chon cua ban: ");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 1: 
			categoriesMenu(sc);
			break;
		case 2: 
			productsMenu(sc);
			break;
		case 3: 
			System.out.println("Chuong trinh ket thuc!");
			System.exit(0);
			break;
		default:
			System.err.println("Ban chon sai chuc nang. Vui long nhap lai: ");
			break;
		}
	}
	public static void categoriesMenu(Scanner sc) {
		do {
		System.out.println("*************************QUAN LY DANH MUC*************************");
		System.out.println("1. Danh sach danh muc ");
		System.out.println("2. Them danh muc");
		System.out.println("3. Xoa danh muc ");
		System.out.println("4. Tim kiem danh muc");
		System.out.println("5. Quay lai");
		System.out.println("Su lua chon cua ban");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 1: 
			categoriesShowMenu(sc);
			break;
		case 2: 
			System.out.print("Số danh muc cần thêm: ");
			int n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; i++) {
				Categories cate = new Categories();
				cate.inputData();
				Data.categoriess.add(cate);
			}
			Data.writeCategoriess();
			break;
		case 3: 
			System.out.println("Nhap ma danh muc can xoa: ");
			int m = Integer.parseInt(sc.nextLine());
			List<Categories> categ =new ArrayList<>();
			for (Categories ca : Data.categoriess) {
				if(ca.getCatalogId() == m) {
					categ.add(ca);
				}
			}
			for (Categories ca : categ) {
				Data.categoriess.remove(ca);
			}
			Data.writeCategoriess();
			break;
		case 4: 
			System.out.println("Nhap ten danh muc can tim kiem: ");
			String name = sc.nextLine();
			List<Categories> cat =new ArrayList<>();
			for (Categories ca : Data.categoriess) {
				if(ca.getCatalogName().toLowerCase().contains(name.toLowerCase())) {
					cat.add(ca);
				}
			}
			for (Categories categories : cat) {
				categories.displayData();
			}
			break;
		case 5:
			mainMenu(sc);
			break;
		default:
			System.err.println("Ban chon sai chuc nang. Vui long nhap lai: ");
			break;
		}
		} while(true);
	}
	public static void categoriesShowMenu(Scanner sc) {
		do {
			System.out.println("*************************DANH SACH DANH MUC*************************");
			System.out.println("1. Danh sach cay danh muc ");
			System.out.println("2. Thong tin chi tiet danh duc");
			System.out.println("3. Quay lai");
			System.out.println("Su lua chon cua ban");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1: 
					System.out.println("__________________Danh sách cây danh mục_________________");
					int lv1 = 0;
						for (Categories cate : Data.categoriess) {
							if (cate.getParentId() == 0) {
					// Hiển thị cấp 1
								System.out.println((++lv1) + "." + cate.getCatalogName());
								int lv2 = 0;
								for (Categories cate1 : Data.categoriess) {
									if (cate1.getParentId() == cate.getCatalogId()) {
					// Hiển thị cấp 2
										System.out.println("\t" + lv1 + "." + (++lv2) + "." + cate1.getCatalogName());
										int lv3 = 0;
										for (Categories cate2 : Data.categoriess) {
											if (cate2.getParentId() == cate1.getCatalogId()) {
					// Hiển thị cấp 3
												System.out.println("\t\t" + lv1 + "." + lv2 + "." + (++lv3) + "."
														+ cate2.getCatalogName());
											}
										}
									}
								}



							}
					}
					break;
			case 2: 
				System.out.println("Nhap ten danh muc can xem thong tin: ");
				String inp = sc.nextLine();
				for (Categories seach : Data.categoriess) {
					if(seach.getCatalogName().contains(inp))
						seach.displayData();
				}
				break;
			case 3: 
				categoriesMenu(sc);
				break;

			default:
				System.err.println("Ban chon sai chuc nang. Vui long nhap lai: ");
				break;
			}
			} while(true);
	}
	public static void productsMenu(Scanner sc) {
		do {
			System.out.println("*************************QUAN LY SAN PHAM*************************");
			System.out.println("1. Them san pham moi ");
			System.out.println("2. Tinh loi nhuan san pham");
			System.out.println("3. Hien thi thong tin san pham");
			System.out.println("4. Sap xep san pham");
			System.out.println("5. Cap nhat thong tin san pham");
			System.out.println("6. Cap nhat trang thai san pham");
			System.out.println("7. Quay lai");
			System.out.println("Su lua chon cua ban");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1: 
				System.out.print("Số san pham cần thêm: ");
				int n = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < n; i++) {
					Product pro = new Product();
					pro.inputData();
					Data.productt.add(pro);
				}
				Data.writeProduct();
				break;
			case 2: 
				System.out.println("Tinh loi nhuan san pham");
				for (Product pro : Data.productt) {
					pro.calProfit();
				}
				break;
			case 3: 
				productsShowMenu(sc);
				break;
			case 4: 
				productsSortMenu(sc);
				break;
			case 5: // cap nhat theo ma
				System.out.println("Nhâp ma san pham can cap nhat: ");
				String ma = sc.nextLine();
				for (Product pro : Data.productt) {
					if(pro.getProductId().equals(ma)) {
						Product _p = pro;
						// cap nhật
						boolean check = true;
						do {
							try {
								System.out.println("Nhap ten san pham: ");
								_p.setProductName(sc.nextLine()); 
								check = true;
							} catch (Exception e) {
								System.err.println(e.getMessage());
								check = false;
							}
						} while (!check);
						do {
							try {
								System.out.println("Nhap tieu de san pham: ");
								_p.setTitle(sc.nextLine());
								check = true;
							} catch (Exception e) {
								System.err.println(e.getMessage());
								check = false;
							}
						} while (!check);
						do {
							try {
								System.out.println("Nhap gia nhap san pham: ");
								_p.setImportPrice(Float.parseFloat(sc.nextLine())); 
								check = true;
							} catch (Exception e) {
								System.err.println(e.getMessage());
								check = false;
							}
						} while (!check);
						do {
							try {
								System.out.println("Nhap gia ban san pham: ");
								_p.setExportPrice(Float.parseFloat(sc.nextLine())); 
								check = true;
							} catch (Exception e) {
								System.err.println(e.getMessage());
								check = false;
							}
						} while (!check);
						do {
							try {
								System.out.println("Nhap mo ta san pham: ");
								_p.setDescriptions(sc.nextLine()); 
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
							_p.setProductStatus(Boolean.parseBoolean(sttt)); 
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
						_p.setCatalog(d);
					}
					
				}
				Data.writeProduct();
				break;
			case 6:
				System.out.println("Nhâp ma san pham can cap nhat: ");
				String masp = sc.nextLine();
				for (Product pro : Data.productt) {
					if(pro.getProductId().equals(masp)) {
						Product _psp = pro;
						// cap nhật
						boolean check = true;
						do {
							System.out.println("Nhap trang thai san pham cap nhat: ");
							String sttt = sc.nextLine();
							if(sttt.equals("true") || sttt.equals("false") || sttt.equals("TRUE") || sttt.equals("FALSE")) {
								_psp.setProductStatus(Boolean.parseBoolean(sttt)); 
							check = true;
							} else {
								System.out.println("Trang thai phai la true|false");
								check = false;
							}
						} while (!check);
					}
				}
				Data.writeProduct();
				break;
			case 7:
				mainMenu(sc);
				break;
			default:
				System.err.println("Ban chon sai chuc nang. Vui long nhap lai: ");
				break;
			}
			} while(true);
	}
	public static void productsShowMenu(Scanner sc) {
		do {
			System.out.println("*************************THONG TIN SAN PHAM*************************");
			System.out.println("1. Hien thi san pham theo danh muc ");
			System.out.println("2. Hien thi chi tiet san pham");
			System.out.println("3. Quay lai");
			System.out.println("Su lua chon cua ban");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1: 
				 for (Categories cate : Data.categoriess) {
					 System.out.println(cate.getCatalogName());
					 for(Product pro : Data.productt) {
						 if(pro.getCatalog().getCatalogId() == cate.getCatalogId()) {
							 System.out.println(" \t" + pro.getProductName());
						 }
					 }
				}
				break;
			case 2: 
				System.out.println("Nhap ten san pham can tim kiem: ");
				String name = sc.nextLine();
				List<Product> pro =new ArrayList<>();
				for (Product pr : Data.productt) {
					if(pr.getProductName().toLowerCase().contains(name.toLowerCase())) {
						pro.add(pr);
					}
				}
				for (Product pr : pro) {
					pr.displayData();
				}
				break;
			case 3: 
				productsMenu(sc);
				break;
			
			default:
				System.err.println("Ban chon sai chuc nang. Vui long nhap lai: ");
				break;
			}
			} while(true);
	}
	public static void productsSortMenu(Scanner sc) {
		do {
			System.out.println("*************************QUAN LY SAN PHAM*************************");
			System.out.println("1. Sap xep san pham theo gia ban tang dan");
			System.out.println("2. Sap xep san pham theo loi nhuan giam dan");
			System.out.println("3. Quay lai");
			System.out.println("Su lua chon cua ban");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1: 
				List<Product> lstSx = Data.productt;
				lstSx.sort((b1, b2) -> Float.compare(b1.getExportPrice(), b2.getExportPrice()));
				for (Product product : lstSx) {
					product.displayData();;
				}
				break;
			case 2: 
				List<Product> lstSxCal = Data.productt;
				lstSxCal.sort((b1, b2) -> Float.compare(b2.getFrofit(), b1.getFrofit()));
				for (Product product : lstSxCal) {
					product.displayData();;
				}
				break;
			case 3: 
				productsMenu(sc);
				break;
			
			default:
				System.err.println("Ban chon sai chuc nang. Vui long nhap lai: ");
				break;
			}
			} while(true);
	}

	}
	
