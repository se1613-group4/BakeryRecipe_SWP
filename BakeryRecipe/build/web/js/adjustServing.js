/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*-------------------------------------
    Quantity Holder
    -------------------------------------*/
var serving = document.querySelector("#serving").value;
$('#quantity-holder').on('click', '.quantity-plus', function () {

        var $holder = $(this).parents('.quantity-holder');
        var $target = $holder.find('input.quantity-input');
        var $quantity = parseInt($target.val(), 10);
        if ($.isNumeric($quantity) && $quantity > 0) {
            $quantity = $quantity +1;
            $target.val($quantity);
            adjustServing($quantity);
        } else {
            $target.val(serving);
        }

    }).on('click', '.quantity-minus', function () {

        var $holder = $(this).parents('.quantity-holder');
        var $target = $holder.find('input.quantity-input');
        var $quantity = parseInt($target.val(), 10);
        if ($.isNumeric($quantity) && $quantity >= 2) {
            $quantity = $quantity - 1;
            $target.val($quantity);
            adjustServing($quantity);
        } else {
            $target.val(1);
        }
    });

/*-------------------------------------
    Adjust Servings
    -------------------------------------*/
function adjustServing(numServing) {    
    var recipeId = document.querySelector("#recipeID").value;    
    $.ajax({
            url: "/BakeryRecipe/AdjustServingController",
            type: "get", //send it through get method            
            data: {
                ajaxid: 4,
                numServing: numServing,
                recipeId: recipeId,
                serving: serving
            },
            success: function (response) {
                //Do Something
                document.querySelector(".testAjax").innerHTML = response;
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
}
