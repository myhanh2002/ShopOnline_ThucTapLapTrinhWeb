package vn.projectLTW.controller.admin;

import org.apache.commons.beanutils.BeanUtils;
import vn.projectLTW.controller.web.HomeController;
import vn.projectLTW.model.Category;
import vn.projectLTW.model.Product;
import vn.projectLTW.model.Seller;
import vn.projectLTW.service.ICategoryService;
import vn.projectLTW.service.ILogService;
import vn.projectLTW.service.IProductService;
import vn.projectLTW.service.ISellerService;
import vn.projectLTW.service.Impl.CategoryServiceImpl;
import vn.projectLTW.service.Impl.LogServiceImpl;
import vn.projectLTW.service.Impl.ProductServiceImpl;
import vn.projectLTW.service.Impl.SellerServiceImpl;
import vn.projectLTW.util.Constant;
import vn.projectLTW.util.UploadUtils;
import vn.projectLTW.model.Log;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024*1024*10,//10MB
					maxFileSize = 1024*1024*50,//50MB
					maxRequestSize = 1024*1024*50 ) //50MB

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/product", "/admin/product/create", "/admin/product/update", "/admin/product/edit",
		"/admin/product/delete", "/admin/product/reset" })
public class ProductController extends HttpServlet {
	ICategoryService categoryService=new CategoryServiceImpl();
	ISellerService sellerService=new SellerServiceImpl();
	IProductService productService=new ProductServiceImpl();
	ILogService logService=new LogServiceImpl();
	Log log = new Log(Log.INFO,"","","",1);
	static final Logger LOGGER= Logger.getLogger(HomeController.class.getName());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		Product product = null;

		if (url.contains("delete")) {
			delete(req, resp);
			product = new Product();
			req.setAttribute("product", product);// đẩy dữ liệu lên Views

		} else if (url.contains("edit")) {
			edit(req, resp);

		} else if (url.contains("reset")) {
			product = new Product();
			req.setAttribute("product", product);// đẩy dữ liệu lên Views

		}
		req.setAttribute("tag", "pro");

		findAll(req, resp); // hiện danh sách product trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/list-product.jsp");
		dispacher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURL().toString();
		Product product = null;

		if (url.contains("create")) {
			create(req, resp);

		} else if (url.contains("update")) {
			update(req, resp);
		} else if (url.contains("reset")) {
			product = new Product();
			req.setAttribute("product", product);

		}
		findAll(req, resp); // hiện danh sách product trong model

		// chuyển về Views
		RequestDispatcher dispacher = req.getRequestDispatcher("/views/admin/list-product.jsp");
		dispacher.forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Category> categoryList = categoryService.findAll();// gọi hàm findAll trong service trả về đối tượng List<products>
			req.setAttribute("categoryList", categoryList);// đẩy ds lên Views
			
			List<Seller> sellerList=sellerService.findAll();//lấy tất cả seller trogn bảng seller
			req.setAttribute("sellerList", sellerList);
			
			List<Product> productList=productService.findAll();
			req.setAttribute("productList", productList);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("productId");// lấy tham số từ Views có name = productId

			// Xóa ảnh cũ đi
			Product oldProduct = productService.findOne(Integer.parseInt(id));
			if (oldProduct.getImages() != null) {
				String fileName = oldProduct.getImages();
				UploadUtils.deleteFile(fileName, "/products/");
			}
			productService.delete(Integer.parseInt(id)); // gọi hàm delete trong service để xóa product thông qua id
			req.setAttribute("message", "Đã xóa thành công");

			log.setLevel(Log.WARNING);
			log.setStatus(4);
			log.setSrc("Delete product");
			log.setContent("1 product has been removed from the list");
			logService.insert(log);
			LOGGER.warning("delete product");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("productId");// lấy tham số từ Views có name = id
			Product product = productService.findOne(Integer.parseInt(id)); // gọi hàm findOne trong service để lấy 1 product thông
																	// qua id
			req.setAttribute("product", product); // đẩy đối tượng product lên views

			List<Category> categoryList = categoryService.findAll();// gọi hàm findAll trong service trả về đối tượng List<products>
			req.setAttribute("categoryList", categoryList);// đẩy ds lên Views
			
			List<Seller> sellerList=sellerService.findAll();//lấy tất cả seller trogn bảng seller
			req.setAttribute("sellerList", sellerList);

			log.setLevel(Log.ALERT);
			log.setStatus(3);
			log.setSrc("Edit product");
			log.setContent("1 product has been edited");
			logService.insert(log);
			LOGGER.warning("edit product");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			//Lấy dữ liệu từ jsp bằng BeanUtils
			Product product=new Product();
			BeanUtils.populate(product, req.getParameterMap());
			// xử lí hình ảnh
			if(req.getPart("images").getSize()!=0) {
				//xử lí hình ảnh
				String fileName=""+System.currentTimeMillis();
				product.setImages(
						UploadUtils.processUpload("images", req, Constant.DIR + "/products/", fileName));
			}
			if(req.getPart("image2").getSize()!=0) {
				//xử lí hình ảnh
				String fileName=""+System.currentTimeMillis();
				product.setImage2(
						UploadUtils.processUpload("image2", req, Constant.DIR + "/products/", fileName));
			}
			if(req.getPart("image3").getSize()!=0) {
				//xử lí hình ảnh
				String fileName=""+System.currentTimeMillis();
				product.setImage3(
						UploadUtils.processUpload("image3", req, Constant.DIR + "/products/", fileName));
			}
			if(req.getPart("image4").getSize()!=0) {
				//xử lí hình ảnh
				String fileName=""+System.currentTimeMillis();
				product.setImage4(
						UploadUtils.processUpload("image4", req, Constant.DIR + "/products/", fileName));
			}

			if(req.getPart("image5").getSize()!=0) {
				//xử lí hình ảnh
				String fileName=""+System.currentTimeMillis();
				product.setImage5(
						UploadUtils.processUpload("image5", req, Constant.DIR + "/products/", fileName));
			}
			product.setCreateDate(new Date(System.currentTimeMillis()));

			
			product.setCategory(categoryService.findOne(product.getCategoryId()));
			product.setSeller(sellerService.findOne(product.getSellerId()));
			
			//gọi pt insert  trong service
			productService.insert(product);
			
			req.setAttribute("product", product);
			req.setAttribute("message", "Đã thêm thành công");

			log.setLevel(Log.INFO);
			log.setStatus(1);
			log.setSrc("Create product");
			log.setContent("1 new category added successfully");
			logService.insert(log);
			LOGGER.info("create product");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Error"+e.getMessage());
		}
		

	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			// Lấy dữ liệu từ JSP bằng BeanUtils
			Product product=new Product();
			BeanUtils.populate(product, req.getParameterMap());
			// Xử lí hình ảnh
			//Khởi tạo DAO
			Product oldproduct=productService.findOne(product.getProductId());
//			System.out.println(oldproduct.getImages());
			if(req.getPart("images").getSize()==0) { 
				product.setImages(oldproduct.getImages());
			}else {
				if(oldproduct.getImages()!=null) {
					//xóa ảnh cũ đi
					String fileName=oldproduct.getImages();
					UploadUtils.deleteFile(fileName, "/product/");
					//xử lí hình ảnh
					fileName=""+System.currentTimeMillis();
					product.setImages(UploadUtils.processUpload("images", req, Constant.DIR+"/products/", fileName));
				
				}
			}
			//Lấy dữ liệu category,seller từ bảng Category và bảng Seller
			product.setCategory(categoryService.findOne(product.getCategoryId()));
			product.setSeller(sellerService.findOne(product.getSellerId()));
			
			productService.update(product);
			
			//thông báo 
			req.setAttribute("product", product);
			req.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	
			req.setAttribute("error", "Error: "+e.getMessage());
		}
	}
}





