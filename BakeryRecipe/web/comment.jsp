<%-- 
    Document   : comment
    Created on : Sep 29, 2022, 6:18:35 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bakery Recipe - Comment</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- Normalize Css -->
        <link rel="stylesheet" href="css/normalize.css">
        <!-- Main Css -->
        <link rel="stylesheet" href="css/main.css">
        <!-- Bootstrap Css -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.min.css">
        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/fontawesome-all.min.css">
        <!-- Flaticon CSS -->
        <link rel="stylesheet" href="fonts/flaticon.css">
        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Custom Css -->
        <link rel="stylesheet" href="style.css">
        <!-- Modernizr Js -->
        <script src="js/modernizr-3.6.0.min.js"></script>
    </head>

    <body>
        <c:set var="recipeDto" value="${requestScope.RECIPE_INFO}"/>
        <c:set var="category" value="${recipeDto.category}"/>
        <c:set var="commentDto" value="${requestScope.COMMENT_INFO}"/>}
        <c:set var="userId" value="${commentDto.userId}"/>}
        <c:set var="commentDetail" value="${commentDto.commentDetail}"/>}
        <c:set var="createdDate" value="${commentDto.createdDate}"/>}
        <c:set var="lastModified" value="${commentDto.lastModified}"/>}
        <c:set var="isActived" value="${commentDto.isActived}"/>}
        <c:set var="recipeId" value="${commentDto.recipeId}"/>}
        
        
        
        <div class="recipe-reviews">
            <div class="section-heading heading-dark">
                <h2 class="item-heading">RECIPE COMMENTS</h2>
            </div>
            <div class="avarage-rating-wrap">
                <div class="avarage-rating">Avarage Rating: 
                    <span class="rating-icon-wrap">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </span>
                    <span class="rating-number">(5)</span>                                        
                </div>
                <div class="total-reviews">Total Reviews:<span class="review-number">(02)</span></div>
            </div>
            <ul>
                <li class="reviews-single-item">
                    <div class="media media-none--xs">
                        <img src="img/blog/comment1.jpg" alt="Comment" class="media-img-auto">
                        <div class="media-body">
                            <h4 class="comment-title">${commentDetail}</h4>
                            <span class="post-date">${createdDate}</span>
                            <p>${commentDetail}</p>
                            <ul class="item-rating">
                                <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                <li class="single-item star-empty"><i class="fas fa-star"></i></li>
                                <li class="single-item"><span>9<span> / 10</span></span> </li>
                            </ul>
                        </div>
                    </div>
                </li>
                
            </ul>
        </div>


        <div class="leave-review">
            <div class="section-heading heading-dark">
                <h2 class="item-heading">LEAVE A REVIEW</h2>
            </div>
            <div class="rate-wrapper">
                <div class="rate-label">Rating</div>
                <div class="rate">
                    <div class="rate-item"><i class="fa fa-star" aria-hidden="true"></i></div>
                    <div class="rate-item"><i class="fa fa-star" aria-hidden="true"></i></div>
                    <div class="rate-item"><i class="fa fa-star" aria-hidden="true"></i></div>
                    <div class="rate-item"><i class="fa fa-star" aria-hidden="true"></i></div>
                    <div class="rate-item"><i class="fa fa-star" aria-hidden="true"></i></div>
                </div>
            </div>
            <form class="leave-form-box">
                <div class="row">
                    <div class="col-12 form-group">
                        <label>Comment :</label>
                        <textarea placeholder="" class="textarea form-control" name="message" rows="7"
                                  cols="20" data-error="Message field is required" required></textarea>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="col-lg-4 form-group">
                        <label>Name :</label>
                        <input type="text" placeholder="" class="form-control" name="name"
                               data-error="Name field is required" required>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="col-lg-4 form-group">
                        <label>E-mail :</label>
                        <input type="email" placeholder="" class="form-control" name="email"
                               data-error="E-mail field is required" required>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="col-lg-4 form-group">
                        <label>Website :</label>
                        <input type="email" placeholder="" class="form-control" name="email"
                               data-error="E-mail field is required" required>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="col-12 form-group mb-0">
                        <button type="submit" class="item-btn">POST REVIEW</button>
                    </div>
                </div>
                <div class="form-response"></div>
            </form>
        </div>

        <!-- Jquery Js -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- Bootstrap Js -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap Js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Plugins Js -->
        <script src="js/plugins.js"></script>
        <!-- Owl Carousel Js -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- Smoothscroll Js -->
        <script src="js/smoothscroll.min.js"></script>
        <!-- Custom Js -->
        <script src="js/main.js"></script>
    </body>
</html>
