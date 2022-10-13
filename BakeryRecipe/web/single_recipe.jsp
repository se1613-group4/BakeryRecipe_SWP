<%-- 
    Document   : single-recipe
    Created on : Sep 26, 2022, 1:50:27 PM
    Author     : LamVo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Bakery Recipe - Single Recipe</title>
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
    <h1>My Single Recipe</h1>
    Recipe Id: ${param.recipeId} </br>
    <!-- Pre loader Start Here -->
    <div id="preloader"></div>
    <!-- Pre loader End Here -->
    <!-- Scroll Up Start Here -->
    <a href="#wrapper" data-type="section-switch" class="scrollup">
        <i class="fas fa-angle-double-up"></i>
    </a>
    <!-- Scroll Up End Here -->
    
    <div id="wrapper" class="wrapper">        
        <!-- Inner Page Banner Area Start Here -->
        <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="breadcrumbs-area">
                            <h1>Single Recipe</h1>
                            <ul>
                                <li>
                                    <a href="home_page.jsp">Home</a>
                                </li>
                                <li>Recipe Details</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Inner Page Banner Area End Here -->

        <!-- Single Recipe With Side bar Area Start Here -->
        <c:set var="recipeDto" value="${requestScope.RECIPE_INFO}"/>
        <c:set var="author" value="${recipeDto.authorInfo}"/>
        <c:set var="category" value="${recipeDto.category}"/>
        <c:set var="image" value="${recipeDto.image}"/>
        <c:set var="likeCount" value="${requestScope.LIKES_COUNT}"/>
        <c:url var="single_recipe_url" value="DisplaySingleRecipe">
            <c:param name="recipeId" value="${recipeDto.recipeId}"/>
        </c:url>        
        <section class="single-recipe-wrap-layout1 padding-top-74 padding-bottom-50">            
            <div class="container">
                <div class="row gutters-60">
                    <div class="col-lg-8">
                        <div class="single-recipe-layout1">
                            <div class="ctg-name">${category.name}</div>
                            <h2 class="item-title">${recipeDto.name}</h2>
                            <div class="row mb-4">
                                <div class="col-xl-9 col-12">
                                    <ul class="entry-meta">
                                        <li class="single-meta"><a href="#"><i class="far fa-calendar-alt"></i>${recipeDto.lastModified}</a></li>
                                        <li class="single-meta"><a href="#DisplayAuthorInfo"><i class="fas fa-user"></i>by <span>${author.fullName}</span></a></li>
                                        <li class="single-meta"><a href="#"><i class="fas fa-heart"></i><span>${likeCount}</span>
                                                Likes</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="item-figure">
                                <img src="${image.imgLink}" alt="Post Image">
                            </div>
                            <div class="item-feature">
                                <ul>
                                    <li>
                                        <div class="feature-wrap">
                                            <div class="media">
                                                <div class="feature-icon">
                                                    <i class="far fa-clock"></i>
                                                </div>
                                                <div class="media-body space-sm">
                                                    <div class="feature-title">PREP TIME</div>
                                                    <div class="feature-sub-title">${recipeDto.preTime} Mins</div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="feature-wrap">
                                            <div class="media">
                                                <div class="feature-icon">
                                                    <i class="fas fa-utensils"></i>
                                                </div>
                                                <div class="media-body space-sm">
                                                    <div class="feature-title">COOK TIME</div>
                                                    <div class="feature-sub-title">${recipeDto.cookTime} Mins</div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="feature-wrap">
                                            <div class="media">
                                                <div class="feature-icon">
                                                    <i class="fas fa-users"></i>
                                                </div>
                                                <div class="media-body space-sm">
                                                    <div class="feature-title">SERVING</div>
                                                    <div class="feature-sub-title">${recipeDto.serving} People</div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="feature-wrap">
                                            <div class="media">
                                                <div class="feature-icon">
                                                    <i class="far fa-eye"></i>
                                                </div>
                                                <div class="media-body space-sm">
                                                    <div class="feature-title">SAVES</div>
                                                    <div class="feature-sub-title">${recipeDto.savedCount}</div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <p class="item-description">${recipeDto.description}</p>
                            
                            <div class="making-elements-wrap">
                                <div class="row">
                                    <div class="col-xl-6 col-12">
                                        <div class="ingridients-wrap">
                                            <h3 class="item-title"><i class="fas fa-list-ul"></i>Ingridients</h3>
                                            
                                            <!-- List ingredients-->
                                            <div class="checkbox checkbox-primary">
                                                <input id="checkbox1" type="checkbox">
                                                <label for="checkbox1">1 cup sifted all purpose flour</label>
                                            </div>
                                            <!--End of list ingredients-->
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!--List of making steps-->
                            <div class="direction-wrap-layout1">
                                <div class="section-heading heading-dark">
                                    <h2 class="item-heading">DIRECTIONS</h2>
                                </div>
                                <p class="section-paragraph">Salamander lied porpoise much over tightly circa horse
                                    taped so innocuously side crudey mightily rigorous plot life. New homes in
                                    particular are subject. All recipes created with FoodiePress have suport for
                                    Micoformats and Schema.org is a collaboration byo improve convallis.</p>
                                <div class="direction-box-layout1">
                                    <div class="item-content">
                                        <div class="serial-number">01 Step</div>
                                        <p>Recipe View<span class="item-time"><i class="far fa-clock"></i>5 Minutes</span> chemaorg is a
                                            collaboration improve
                                            the web by creat inegaera structured markupinn ocuously
                                            side crudey mightily rigorous plot life.</p>
                                    </div>
                                </div>
                                <div class="direction-box-layout1">
                                    <div class="item-content">
                                        <div class="serial-number">02 Step</div>
                                        <p>Recipe View<span class="item-time"><i class="far fa-clock"></i>5 Minutes</span> chemaorg is a
                                            collaboration improve
                                            the web by creat inegaera structured markupinn ocuously
                                            side crudey mightily rigorous plot life.</p>
                                    </div>
                                </div>
                                <div class="direction-box-layout1">
                                    <div class="item-content">
                                        <div class="serial-number">03 Step</div>
                                        <p>Recipe View<span class="item-time"><i class="far fa-clock"></i>5 Minutes</span> chemaorg is a
                                            collaboration improve
                                            the web by creat inegaera structured markupinn ocuously
                                            side crudey mightily rigorous plot life.</p>
                                    </div>
                                </div>
                                <div class="direction-box-layout1">
                                    <div class="item-content">
                                        <div class="serial-number">04 Step</div>
                                        <p>Recipe View<span class="item-time"><i class="far fa-clock"></i>5 Minutes</span> chemaorg is a
                                            collaboration improve
                                            the web by creat inegaera structured markupinn ocuously
                                            side crudey mightily rigorous plot life.</p>
                                    </div>
                                </div>
                            </div>
                            
                           <!-- Tag of this Recipe-->
                            <div class="tag-share">
                                <ul>
                                    <li>
                                        <ul class="inner-tag">
                                            <li>
                                                <a href="#">Burger</a>
                                            </li>
                                            <li>
                                                <a href="#">Dinner</a>
                                            </li>
                                            <li>
                                                <a href="#">Pizza</a>
                                            </li>
                                            <li>
                                                <a href="#">Salad</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <ul class="inner-share">
                                            <li>
                                                <a href="#">
                                                    <i class="fab fa-facebook-f"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fab fa-twitter"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fab fa-linkedin-in"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fab fa-google-plus-g"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fab fa-pinterest"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>  
                            
                           <!-- Recipe's Author -->
                           <div class="recipe-author">
                                <div class="media media-none--xs">
                                    <img src="img/blog/author9.jpg" alt="Blog Author" class="rounded-circle media-img-auto">
                                    <div class="media-body">
                                        <h4 class="author-title">Michel Jack</h4>
                                        <h5 class="author-sub-title">Written by</h5>
                                        <p>I love cooking and blogging. Using a fork, break salmon. Halve reserved 
                                                potatoes and eggs crosswise. The of something of did require met of
                                                help have someone.</p>
                                        <ul class="author-social">
                                            <li>
                                                <a href="#"><i class="fab fa-facebook-f"></i></a>
                                            </li>
                                            <li>
                                                <a href="#"><i class="fab fa-twitter"></i></a>
                                            </li>
                                            <li>
                                                <a href="#"><i class="fab fa-linkedin-in"></i></a>
                                            </li>
                                            <li>
                                                <a href="#"><i class="fab fa-pinterest-p"></i></a>
                                            </li>
                                            <li>
                                                <a href="#"><i class="fab fa-skype"></i></a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>            
                            <div class="also-like-wrap">
                                <h4 class="also-like-title">YOU MAY ALSO LIKE</h4>
                                <div class="row">
                                    <div class="col-xl-4 col-lg-6 col-md-6 col-12">
                                        <div class="product-box-layout2">
                                            <figure class="item-figure"><img src="img/product/product11.jpg"
                                                        alt="Product"></figure>
                                            <div class="item-content">
                                                <span class="sub-title">BREAKFAST</span>
                                                <h3 class="item-title"><a href="single-recipe1.html">Tomatoes Stuffed with Foie and
                                                        Chanterelles</a></h3>
                                                <ul class="entry-meta">
                                                    <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 col-lg-6 col-md-6 col-12">
                                        <div class="product-box-layout2">
                                            <figure class="item-figure"><img src="img/product/product12.jpg"
                                                        alt="Product"></figure>
                                            <div class="item-content">
                                                <span class="sub-title">DESERT</span>
                                                <h3 class="item-title"><a href="single-recipe1.html">Pumpkin Cheesecake With
                                                        GingersnapCrust</a></h3>
                                                <ul class="entry-meta">
                                                    <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 d-block d-md-none d-xl-block col-12">
                                        <div class="product-box-layout2">
                                            <figure class="item-figure"><img src="img/product/product13.jpg"
                                                        alt="Product"></figure>
                                            <div class="item-content">
                                                <span class="sub-title">JUICE</span>
                                                <h3 class="item-title"><a href="single-recipe1.html">Blueberry Juice with Lemon Crema</a></h3>
                                                <ul class="entry-meta">
                                                    <li><a href="#"><i class="fas fa-user"></i>by <span>John Martin</span></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>             
                            </div>
                           
                           
                           <jsp:include page="like.jsp" />
                           <jsp:include page="comment.jsp" />
                           
<!--                            <div class="recipe-reviews">
                                <div class="section-heading heading-dark">
                                    <h2 class="item-heading">RECIPE REVIEWS</h2>
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
                                                <h4 class="comment-title">Liza Zaman</h4>
                                                <span class="post-date">September 27, 2018</span>
                                                <p>Absolutely great recipe. I cooked it for my kids and they loved it, even 
                                                        asked for more, can you believe it?</p>
                                                <ul class="item-rating">
                                                    <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                                    <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                                    <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                                    <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                                    <li class="single-item star-empty"><i class="fas fa-star"></i></li>
                                                    <li class="single-item"><span>9<span> / 10</span></span> </li>
                                                </ul>
                                                <a href="#" class="item-btn">REPLY<i class="fas fa-long-arrow-alt-right"></i></a>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="reviews-single-item">
                                        <div class="media media-none--xs">
                                            <img src="img/blog/comment2.jpg" alt="Comment" class="media-img-auto">
                                            <div class="media-body">
                                                <h4 class="comment-title">John Martin</h4>
                                                <span class="post-date">September 12, 2018</span>
                                                <p>Absolutely great recipe. I cooked it for my kids and they loved it, even 
                                                        asked for more, can you believe it?</p>
                                                <ul class="item-rating">
                                                    <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                                    <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                                    <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                                    <li class="single-item star-fill"><i class="fas fa-star"></i></li>
                                                    <li class="single-item star-empty"><i class="fas fa-star"></i></li>
                                                    <li class="single-item"><span>7<span> / 10</span></span> </li>
                                                </ul>
                                                <a href="#" class="item-btn">REPLY<i class="fas fa-long-arrow-alt-right"></i></a>
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
                            </div>-->
                        </div>
                    </div>

                    <div class="col-lg-4 sidebar-widget-area sidebar-break-md">
                        <!-- Top 5 Recipes-->
                        <div class="widget">                            
                            <div class="section-heading heading-dark">
                                <h3 class="item-heading">TOP RECIPES</h3>
                            </div>
                            <div class="widget-latest">
                                <ul class="block-list">
                                    <c:set var="top5Recipes" value="${sessionScope.TOP5_RECIPES}"/>
                                    <c:forEach var="recipeDto" items="${top5Recipes}" varStatus="counter">
                                        <c:set var="author" value="${recipeDto.authorInfo}"/>
                                        <c:set var="category" value="${recipeDto.category}"/>
                                        <c:set var="image" value="${recipeDto.image}"/>
                                        <c:url var="single_recipe_url" value="DisplaySingleRecipe">
                                            <c:param name="recipeId" value="${recipeDto.recipeId}"/>
                                        </c:url>                                        
                                        <li class="single-item">
                                            <div class="item-img">
                                                <a href="${single_recipe_url}"><img src="${image.imgLink}" alt="Post"></a>
                                                <div class="count-number">${counter.count}</div>
                                            </div>
                                            <div class="item-content">
                                                <div class="item-ctg">${category.name}</div>
                                                <h4 class="item-title"><a href="${single_recipe_url}">${recipeDto.name}</a></h4>
                                                <div class="item-post-by">
                                                    <a href="#DisplayAuthorProfile"><i class="fas fa-user"></i><span>by</span>
                                                        ${author.fullName}</a>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>

                        
                        <div class="widget">
                            <div class="widget-ad">
                                <a href="#"><img src="img/figure/figure4.jpg" alt="Ad" class="img-fluid"></a>
                            </div>
                        </div>
                                                
                        <!--Featured Article-->                           
                        <div class="widget">
                            <div class="section-heading heading-dark">
                                <h3 class="item-heading">FEATURED ARTICLE</h3>
                            </div>
                            <div class="widget-featured-feed">
                                <div class="rc-carousel nav-control-layout1" data-loop="true" data-items="3"
                                    data-margin="5" data-autoplay="true" data-autoplay-timeout="5000" data-smart-speed="700"
                                    data-dots="false" data-nav="true" data-nav-speed="false" data-r-x-small="1"
                                    data-r-x-small-nav="true" data-r-x-small-dots="false" data-r-x-medium="1"
                                    data-r-x-medium-nav="true" data-r-x-medium-dots="false" data-r-small="1"
                                    data-r-small-nav="true" data-r-small-dots="false" data-r-medium="1"
                                    data-r-medium-nav="true" data-r-medium-dots="false" data-r-large="1"
                                    data-r-large-nav="true" data-r-large-dots="false" data-r-extra-large="1"
                                    data-r-extra-large-nav="true" data-r-extra-large-dots="false">
                                    <div class="featured-box-layout1">
                                        <div class="item-img">
                                            <img src="img/product/product17.jpg" alt="Brand" class="img-fluid">
                                        </div>
                                        <div class="item-content">
                                            <span class="ctg-name">BREAKFAST</span>
                                            <h4 class="item-title"><a href="single-recipe1.html">Baked Garlic Prawn</a></h4>
                                            <p>Definitiones noel ei verear intelle
                                                gatpri civibus consequat area
                                                refund efficiantue.</p>
                                        </div>
                                    </div>
                                    <div class="featured-box-layout1">
                                        <div class="item-img">
                                            <img src="img/product/product18.jpg" alt="Brand" class="img-fluid">
                                        </div>
                                        <div class="item-content">
                                            <span class="ctg-name">DINNER</span>
                                            <h4 class="item-title"><a href="single-recipe1.html">Baked Garlic Prawn</a></h4>
                                            <p>Definitiones noel ei verear intelle
                                                gatpri civibus consequat area
                                                refund efficiantue.</p>
                                        </div>
                                    </div>
                                    <div class="featured-box-layout1">
                                        <div class="item-img">
                                            <img src="img/product/product19.jpg" alt="Brand" class="img-fluid">
                                        </div>
                                        <div class="item-content">
                                            <span class="ctg-name">SALAD</span>
                                            <h4 class="item-title"><a href="single-recipe1.html">Baked Garlic Prawn</a></h4>
                                            <p>Definitiones noel ei verear intelle
                                                gatpri civibus consequat area
                                                refund efficiantue.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Category List-->
                        <div class="widget">
                            <div class="section-heading heading-dark">
                                <h3 class="item-heading">CATEGORIES</h3>
                            </div>
                            <div class="widget-categories">
                                <ul>
                                    <li>
                                        <a href="#">BreakFast
                                            <span>25</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Lunch
                                            <span>15</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Pasta
                                            <span>22</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Dinner
                                            <span>18</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Dessert
                                            <span>36</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Drinks
                                            <span>12</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">Fruits
                                            <span>05</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        
                        <!-- Popular Tags-->
                        <div class="widget">
                            <div class="section-heading heading-dark">
                                <h3 class="item-heading">POPULAR TAGS</h3>
                            </div>
                            <div class="widget-tag">
                                <ul>
                                    <li>
                                        <a href="#">DESERT</a>
                                    </li>
                                    <li>
                                        <a href="#">CAKE</a>
                                    </li>
                                    <li>
                                        <a href="#">BREAKFAST</a>
                                    </li>
                                    <li>
                                        <a href="#">BURGER</a>
                                    </li>
                                    <li>
                                        <a href="#">DINNER</a>
                                    </li>
                                    <li>
                                        <a href="#">PIZZA</a>
                                    </li>
                                    <li>
                                        <a href="#">SEA FOOD</a>
                                    </li>
                                    <li>
                                        <a href="#">SALAD</a>
                                    </li>
                                    <li>
                                        <a href="#">JUICE</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Single Recipe With Side bar Area End Here -->
    </div>

    <!-- Search Box Start Here -->
    <div id="search" class="search-wrap">
        <button type="button" class="close">×</button>
        <form class="search-form">
            <input type="search" value="" placeholder="Type here........" />
            <button type="submit" class="search-btn"><i class="flaticon-search"></i></button>
        </form>
    </div>    
    <!-- Search Box End Here -->
    <!-- Modal Start-->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="title-default-bold mb-none">Login</div>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form class="login-form">
                        <input class="main-input-box" type="text" placeholder="User Name" />
                        <input class="main-input-box" type="password" placeholder="Password" />
                        <div class="inline-box mb-5 mt-4">
                            <div class="checkbox checkbox-primary">
                                <input id="modal-checkbox" type="checkbox">
                                <label for="modal-checkbox">Remember Me</label>
                            </div>
                            <label class="lost-password"><a href="#">Lost your password?</a></label>
                        </div>
                        <div class="inline-box mb-5 mt-4">
                            <button class="btn-fill" type="submit" value="Login">Login</button>
                            <a href="#" class="btn-register"><i class="fas fa-user"></i>Register Here!</a>
                        </div>
                    </form>
                    <label>Login connect with your Social Network</label>
                    <div class="login-box-social">
                        <ul>
                            <li><a href="#" class="facebook"><i class="fab fa-facebook-f"></i></a></li>
                            <li><a href="#" class="twitter"><i class="fab fa-twitter"></i></a></li>
                            <li><a href="#" class="linkedin"><i class="fab fa-linkedin-in"></i></a></li>
                            <li><a href="#" class="google"><i class="fab fa-google-plus-g"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal End-->
    
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
