/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
    Created on : Oct 27, 2022, 13:07:30 PM
    Author     : LamVo
*/
const ul = document.querySelector("#ul-tag"),
input = document.querySelector("#input-tag"),
tagNumb = document.querySelector(".tag-details span");

/*Số lượng tối đa tag*/
let maxTags = 10,
/*Thiết lập tag mặc định*/
tags = [];
countTags();
createTag();
/*Đếm số lượng tag*/
function countTags(){
    input.focus();
    tagNumb.innerText = maxTags - tags.length;
}
/*Tạo tag*/
function createTag(){
    ul.querySelectorAll(".li-tag").forEach(li => li.remove());
    tags.slice().reverse().forEach(tag =>{
        let liTag = `<li class="li-tag">${tag}<i class="fa-solid fa-xmark" onclick="remove(this, '${tag}')"></i></li>`;
//    let liTag = `<li class="li-tag" onclick="remove(this, '${tag}')>${tag}</li>`;
        ul.insertAdjacentHTML("afterbegin", liTag);
    });
    countTags();
}
/*Xoá tag*/
function remove(element, tag){
    let index  = tags.indexOf(tag);
    tags = [...tags.slice(0, index), ...tags.slice(index + 1)];
    element.parentElement.remove();
    countTags();
}
/*Thêm tag bằng dấu enter*/
function addTag(e){
    if(e.key == "Enter"){
        let tag = e.target.value.trim().replace(/\s+/g, ' ');
        if(tag.length > 1){
            if(tags.length  <  10){
                tag.split(',').forEach(tag => {
                    if (tag.trim().length>1 && !tags.includes(tag.trim())){
                        tags.push(tag.trim());
                        createTag();
                    }                    
                });
            }
        }
        e.target.value = "";
    }
}
input.addEventListener("keyup", addTag);
//const removeBtn = document.querySelector(".tag-details button");
///*Xóa tất cả tags*/
//removeBtn.addEventListener("click", () =>{
//    tags.length = 0;
//    ul.querySelectorAll(".li-tag").forEach(li => li.remove());
//    countTags();
//});

