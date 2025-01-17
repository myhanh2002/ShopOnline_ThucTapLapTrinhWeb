<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>

		<div class="row">
			<div class="col">
				<c:if test="${not empty message }">
					<div class="alert alert-success">${message}</div>
				</c:if>

				<c:if test="${not empty error }">
					<div class="alert alert-danger">${error}</div>
				</c:if>

			</div>

		</div>

		<form action="#" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-6">
					<div class="mb-3">
						<label for="productID">Product ID: </label> <input type="text"
							class="form-control" id="productId" name="productId"
							value="${product.productId}" readonly>
					</div>
				
					<div class="mb-3">
						<label for="productCode">Product Code:</label> <input type="text"
							class="form-control" id="productCode" name="productCode"
							value="${product.productCode}">
					</div>
					<div class="mb-3">
						<label for="productName">Product Name:</label> <input type="text"
							class="form-control" id="productName" name="productName"
							value="${product.productName}">
					</div>
					<div class="mb-3">
						<label for="stoke">Stoke:</label> <input type="text"
							class="form-control" id="stoke" name="stoke"
							value="${product.stoke}">
					</div>

				

					<div class="mb-3">
						<label for="price">Price:</label> <input type="text"
							class="form-control" id="price" name="price"
							value="${product.price}">

					</div>

					<div class="mb-3">
						<label for="description">Description:</label> <textarea type="text"
																				class="form-control" id="description" name="description">
						${product.description}</textarea>
					</div>

					<div class="mb-3">
						<label for="Images">Main Images:</label>
						<c:if test="${product.images==null }">
							<c:url value="/template/images/avatar.png" var="imgURL"></c:url>
						</c:if>
						<c:if test="${product.images!=null }">
							<c:url value="/uploads/products/${product.images}" var="imgURL"></c:url>
						</c:if>

						<img alt="images" src="${imgURL}" width="80px" height="80px" id="images" class="rounded-circle">
						<input type="file" class="form-control" onchange="chooseFile(this)"  name="images" value="${product.images}">
					</div>


					<script>
						function chooseFile(fileInput) {
							if(fileInput.files && fileInput.files[0]){
								var reader=new FileReader();
								reader.onload=function(e){
									$('#images').attr('src',e.target.result);
								}
								reader.readAsDataURL(fileInput.file[0]);
							}
						}
					</script>
				</div>
				<div class="col-sm-6">
					<script>
						function chooseFile2(fileInput) {
							if(fileInput.files && fileInput.files[0]){
								var reader=new FileReader();
								reader.onload=function(e){
									$('#image2').attr('src',e.target.result);
								}
								reader.readAsDataURL(fileInput.file[0]);
							}
						}
						function chooseFile3(fileInput) {
							if(fileInput.files && fileInput.files[0]){
								var reader=new FileReader();
								reader.onload=function(e){
									$('#image3').attr('src',e.target.result);
								}
								reader.readAsDataURL(fileInput.file[0]);
							}
						}
						function chooseFile4(fileInput) {
							if(fileInput.files && fileInput.files[0]){
								var reader=new FileReader();
								reader.onload=function(e){
									$('#image4').attr('src',e.target.result);
								}
								reader.readAsDataURL(fileInput.file[0]);
							}
						}
						function chooseFile5(fileInput) {
							if(fileInput.files && fileInput.files[0]){
								var reader=new FileReader();
								reader.onload=function(e){
									$('#image5').attr('src',e.target.result);
								}
								reader.readAsDataURL(fileInput.file[0]);
							}
						}
					</script>

					<div class="mb-3">
						<label for="Images">Images 1</label>
						<c:if test="${product.image2==null }">
							<c:url value="/template/images/avatar.png" var="imgURL"></c:url>
						</c:if>
						<c:if test="${product.image2!=null }">
							<c:url value="/uploads/products/${product.image2}" var="imgURL"></c:url>
						</c:if>
						<img alt="image2" src="${imgURL}" width="80px" height="80px" id="image2" class="rounded-circle">
						<input type="file" class="form-control" onchange="chooseFile2(this)"  name="image2" value="${product.image2}">
					</div>

					<div class="mb-3">
						<label for="Images">Images 2</label>
						<c:if test="${product.image3==null }">
							<c:url value="/template/images/avatar.png" var="imgURL"></c:url>
						</c:if>
						<c:if test="${product.image3!=null }">
							<c:url value="/uploads/products/${product.image3}" var="imgURL"></c:url>
						</c:if>
						<img alt="image3" src="${imgURL}" width="80px" height="80px" id="image3" class="rounded-circle">
						<input type="file" class="form-control" onchange="chooseFile3(this)"  name="image3" value="${product.image3}">
					</div>


					<div class="mb-3">
						<label for="Images">Images 3</label>
						<c:if test="${product.image4==null }">
							<c:url value="/template/images/avatar.png" var="imgURL"></c:url>
						</c:if>
						<c:if test="${product.image4!=null }">
							<c:url value="/uploads/products/${product.image4}" var="imgURL"></c:url>
						</c:if>
						<img alt="image4" src="${imgURL}" width="80px" height="80px" id="image4" class="rounded-circle">
						<input type="file" class="form-control" onchange="chooseFile4(this)"  name="image4" value="${product.image4}">
					</div>

					<div class="mb-3">
						<label for="Images">Images 4</label>
						<c:if test="${product.image5==null }">
							<c:url value="/template/images/avatar.png" var="imgURL"></c:url>
						</c:if>
						<c:if test="${product.image5!=null }">
							<c:url value="/uploads/products/${product.image5}" var="imgURL"></c:url>
						</c:if>
						<img alt="image5" src="${imgURL}" width="80px" height="80px" id="image5" class="rounded-circle">
						<input type="file" class="form-control" onchange="chooseFile5(this)"  name="image5" value="${product.image5}">
					</div>

					
					<div class="mb-3">
						<label>Category:</label>
						<select name="categoryId">
							<c:forEach items="${categoryList}" var="item">
								<option value="${item.categoryId}" ${product.categoryId==item.categoryId?'selected':''}>${item.categoryName}</option>		
							</c:forEach>
						</select>
					</div>
					
					<div class="mb-3">
						<label>Seller:</label>
						<select name="sellerId">
							<c:forEach items="${sellerList}" var="item">
								<option value="${item.sellerId}" ${product.sellerId==item.sellerId?'selected':''}>${item.sellerName}</option>		
							</c:forEach>
						</select>
					</div>

					<label >Status:</label>
					<div class="form-check form-check-inline">
						<input type="radio" class="form-check-input" id="statusOn"
							name="status" value="1" ${product.status==1?'checked':'' }> <label class="form-check-label">Hoạt
							động</label> 
							
						<input type="radio" class="form-check-input" id="statusOff"
							name="status" value="0" ${product.status==0?'checked':'' }> <label class="form-check-label">Khóa</label>
					</div>
					<br />
					
					<button class="btn btn-success"
						formaction="<c:url value="/admin/product/create"/>">
						Create <i class="fa fa-plus"></i>
					</button>
					
					<button  class="btn btn-warning"
						formaction="<c:url value="/admin/product/update"/>">
						Update <i class="fa fa-edit"></i>
					</button>
					
					<button class="btn btn-danger"
						formaction="<c:url value="/admin/product/delete"/>">
						Delete <i class="fa fa-trash"></i>
					</button>
					
					<button class="btn btn-primary"
						formaction="<c:url value="/admin/product/reset"/>">
						Reset <i class="fa fa-undo"></i>
					</button>
					<br />

				</div>
			</div>
		</form>
		<br />

		<div class="row">
			<div class="col-sm-12">
				<table class="table table-striped table-bordered table-hover" id="sample_2">
					<thead>
						<tr>
							<th scope="col">product ID</th>
							<th scope="col">product Code</th>
							<th scope="col">Images</th>
							<th scope="col">Product Name</th>
							<th scope="col">Price</th>							
							<th scope="col">Description</th>
							<th scope="col">Stock</th>
							<th scope="col">Category</th>
							<th scope="col">Seller</th>
							<th scope="col">Status</th>
							<th scope="col">Amount</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${productList}" varStatus="stt">
							<tr>
								<th scope="row">${i.productId}</th>
								<td>${i.productCode}</td>
								<td>
									<c:url value="/uploads/products/${i.images}" var="imgURL"></c:url>
									<img width="80px" height="80px" src="${imgURL}" class="rounded-circle">
								</td>
								<td>${i.productName}</td>
								<td>${i.price}</td>
								<td>${i.description}</td>
								<td>${i.stoke}</td>
								<td>${i.category.categoryName}</td>
								<td>${i.seller.sellerName}</td>
								<td>${i.status==1?'Hoạt động':'Khóa'}</td>
								<td>${i.amount}</td>



								<td>
									<a href="<c:url value="/admin/product/edit?productId=${i.productId}"/>"><i class="fa fa-pencil" title="edit" style="color: #f1c40f; font-size: 20px"> </i></a> |
									<a href="<c:url value="/admin/product/delete?productId=${i.productId}"/>"><i class="fa fa-trash" title="Delete" style="color: red;font-size: 20px"></i></a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

	