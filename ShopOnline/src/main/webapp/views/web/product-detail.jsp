<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url value="/template/assets" var="url"></c:url>

<div class="main">
    <div class="container-fluid">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN SIDEBAR -->
            <div class="sidebar col-md-3 col-sm-5">
                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <c:forEach items="${categoryList}" var="cateList">
                        <li class="list-group-item clearfix">
                            <a href="<c:url value="/product/list?categoryId=${cateList.categoryId}&sellerId=0"></c:url>">
                                <img style="width:22px; margin-right:10px"
                                     src="<c:url value="/image?fname=category/${cateList.images }"></c:url>">
                                <i class="fa fa-angle-right" style="width:22px"></i>${cateList.categoryName}</a>
                        </li>
                    </c:forEach>
                </ul>

                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <c:forEach items="${sellerList}" var="sellerList">
                        <li class="list-group-item clearfix">
                            <a href="<c:url value="/product/list?sellerId=${sellerList.sellerId}&categoryId=0"></c:url>"><img
                                    style="width:22px" alt=""
                                    src="<c:url value="/image?fname=seller/${sellerList.images }"></c:url>"> <i
                                    class="fa fa-angle-right" style="width:22px"></i>${sellerList.sellerName}</a>
                        </li>
                    </c:forEach>

                </ul>

                <%--            <div class="sidebar-filter margin-bottom-25">--%>
                <%--                <h2>Filter</h2>--%>
                <%--                <h3>Availability</h3>--%>
                <%--                <div class="checkbox-list">--%>
                <%--                    <label><input type="checkbox"> Not Available (3)</label> <label><input--%>
                <%--                        type="checkbox"> In Stock (26)</label>--%>
                <%--                </div>--%>

                <%--                <h3>Price</h3>--%>
                <%--                <p>--%>
                <%--                    <label for="amount">Range:</label> <input type="text" id="amount"--%>
                <%--                                                              style="border: 0; color: #f6931f; font-weight: bold;">--%>
                <%--                </p>--%>
                <%--                <div id="slider-range"></div>--%>
                <%--            </div>--%>


            </div>
            <!-- END SIDEBAR -->

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-7" style="margin: -200px 0 0 290px">
                <div class="product-page">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <div class="product-main-image">
                                <img src="<c:url value="/image?fname=products/${product.images}"></c:url>"
                                     alt="Cool green dress with red bell" class="img-responsive"
                                     data-BigImgsrc="<c:url value="/image?fname=products/${product.images}"></c:url>">
                            </div>
                            <div class="product-other-images">
                                <a href="<c:url value="/image?fname=products/${product.image2}"></c:url>"
                                   rel="photos-lib"><img alt="Berry Lace Dress"
                                                         src="<c:url value="/image?fname=products/${product.image2}"></c:url>"></a>
                                <a href="<c:url value="/image?fname=products/${product.image3}"></c:url>"
                                   class="fancybox-button" rel="photos-lib"><img alt="Berry Lace Dress"
                                                                                 src="<c:url value="/image?fname=products/${product.image3}"></c:url>"></a>
                                <a href="<c:url value="/image?fname=products/${product.image4}"></c:url>"
                                   class="fancybox-button" rel="photos-lib"><img alt="Berry Lace Dress"
                                                                                 src="<c:url value="/image?fname=products/${product.image4}"></c:url>"></a>
                                <a href="<c:url value="/image?fname=products/${product.image5}"></c:url>"
                                   class="fancybox-button" rel="photos-lib"><img alt="Berry Lace Dress"
                                                                                 src="<c:url value="/image?fname=products/${product.image5}"></c:url>"></a>

                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <h1>${product.productName}</h1>
                            <div class="price-availability-block clearfix">
                                <div class="price">
                                    <strong>${product.price}</strong>
                                    <em><span>${product.price/0.25}</span></em>
                                </div>
                                <div class="availability">
                                    Availability: <strong>${product.stoke}</strong>
                                </div>
                            </div>
                            <div class="description">
                                <p>${product.description}</p>
                            </div>
                            <div class="product-page-options">
                                <div class="pull-left">
                                    <label class="control-label">Size:</label>
                                    <select class="form-control input-sm">
                                        <option>L</option>
                                        <option>M</option>
                                        <option>XL</option>
                                    </select>
                                </div>
                                <div class="pull-left">
                                    <label class="control-label">Color:</label>
                                    <select class="form-control input-sm">
                                        <option>Red</option>
                                        <option>Blue</option>
                                        <option>Black</option>
                                    </select>
                                </div>
                            </div>
                            <div class="product-page-cart" >
                                <form name="f1" method="get"
                                      action="<c:url value="/member/cart/updateQuantity"></c:url>">


                                    <input type="text" name="pId" id="pid"
                                           value="${product.productId}" hidden="">

                                    <input type="text" id="stock${product.productId}" value="${product.stoke}" hidden="">

                                    <button type="button" class="quantity-button"
                                            name='subtract${product.productId}'
                                            onclick='javascript: subtractQty0(${product.productId});'
                                            value="-">-
                                    </button>

                                    <input readonly type="text" name="quantity"
                                           value="${1}"
                                           id="product-quantity${product.productId}"
                                           style="width: 40px"/>




                                    <button type="button" class="quantity-button"
                                            name='add${product.productId}'
                                            onclick='javascript: subtractQty9(${product.productId});'
                                            value="+">+
                                    </button>
<%--                                    <button type="submit" class="btn btn-danger">Cập nhật</button>--%>
                                    <nbsp></nbsp>
                                    <%--    <button type="submit" class="btn btn-danger">Thêm vào giỏ hàng</button>--%>
                                </form>
                                </td>
                                </br>
                                </br>
                                <a href="<c:url value="/member/cart/add?pId=${product.productId}&quantity=1"/>"
                                   class="btn btn-primary add2cart">Thêm vào giỏ hàng</a>
                            </div>
                            <div class="review">
                                <input type="range" value="4" step="0.25" id="backing4">
                                <div class="rateit" data-rateit-backingfld="#backing4" data-rateit-resetable="false"
                                     data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5">
                                </div>
                                <a href="#">7 reviews</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">Write a review</a>
                            </div>
                            <ul class="social-icons">
                                <li><a class="facebook" data-original-title="facebook" href="#"></a></li>
                                <li><a class="twitter" data-original-title="twitter" href="#"></a></li>
                                <li><a class="googleplus" data-original-title="googleplus" href="#"></a></li>
                                <li><a class="evernote" data-original-title="evernote" href="#"></a></li>
                                <li><a class="tumblr" data-original-title="tumblr" href="#"></a></li>
                            </ul>
                        </div>

                        <div class="product-page-content">
                            <ul id="myTab" class="nav nav-tabs">
                                <li><a href="#Description" data-toggle="tab">Description</a></li>
                                <li class="active"><a href="#Reviews" data-toggle="tab">Reviews (2)</a></li>
                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <div class="tab-pane fade" id="Description">
                                    <p>${product.description}</p>
                                </div>

                                <div class="tab-pane fade in active" id="Reviews">
                                    <!--<p>There are no reviews for this product.</p>-->
                                    <div class="review-item clearfix">
                                        <div class="review-item-submitted">
                                            <strong>Bob</strong>
                                            <em>30/12/2013 - 07:37</em>
                                            <div class="rateit" data-rateit-value="5" data-rateit-ispreset="true"
                                                 data-rateit-readonly="true"></div>
                                        </div>
                                        <div class="review-item-content">
                                            <p>Sed velit quam, auctor id semper a, hendrerit eget justo. Cum sociis natoque
                                                penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis vel
                                                arcu pulvinar dolor tempus feugiat id in orci. Phasellus sed erat leo. Donec
                                                luctus, justo eget ultricies tristique, enim mauris bibendum orci, a sodales
                                                lectus purus ut lorem.</p>
                                        </div>
                                    </div>
                                    <div class="review-item clearfix">
                                        <div class="review-item-submitted">
                                            <strong>Mary</strong>
                                            <em>13/12/2013 - 17:49</em>
                                            <div class="rateit" data-rateit-value="2.5" data-rateit-ispreset="true"
                                                 data-rateit-readonly="true"></div>
                                        </div>
                                        <div class="review-item-content">
                                            <p>Sed velit quam, auctor id semper a, hendrerit eget justo. Cum sociis natoque
                                                penatibus et magnis dis parturient montes, nascetur ridiculus mus. Duis vel
                                                arcu pulvinar dolor tempus feugiat id in orci. Phasellus sed erat leo. Donec
                                                luctus, justo eget ultricies tristique, enim mauris bibendum orci, a sodales
                                                lectus purus ut lorem.</p>
                                        </div>
                                    </div>

                                    <!-- BEGIN FORM-->
                                    <form action="#" class="reviews-form" role="form">
                                        <h2>Write a review</h2>
                                        <div class="form-group">
                                            <label for="name">Name <span class="require">*</span></label>
                                            <input type="text" class="form-control" id="name">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="text" class="form-control" id="email">
                                        </div>
                                        <div class="form-group">
                                            <label for="review">Review <span class="require">*</span></label>
                                            <textarea class="form-control" rows="8" id="review"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Rating</label>
                                            <input type="range" value="4" step="0.25" id="backing5">
                                            <div class="rateit" data-rateit-backingfld="#backing5"
                                                 data-rateit-resetable="false" data-rateit-ispreset="true"
                                                 data-rateit-min="0" data-rateit-max="5">
                                            </div>
                                        </div>
                                        <div class="padding-top-20">
                                            <button type="submit" class="btn btn-primary">Send</button>
                                        </div>
                                    </form>
                                    <!-- END FORM-->
                                </div>
                            </div>
                        </div>

                        <div class="sticker sticker-sale"></div>
                    </div>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

		