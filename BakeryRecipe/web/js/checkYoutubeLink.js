/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function checkUrl() {
    var vidUrl = document.querySelector("#vid-input").value;
    var grid = document.querySelector("#video-grid");
    $.ajax({
        url: "/BakeryRecipe/CheckYoutubeUrlController",
        type: "get", //send it through get method
        data: { 
            ajaxid: 4, 
            vidUrl: vidUrl
        },
        success: function (data) {
            //Do Something
//            document.querySelector("#add-ingre-tbn").insertAdjacentHTML("beforebegin", data);
            grid.innerHTML = data;
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });
}


