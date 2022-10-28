/**
 * Document   : submit_recipe (javascript)
 * Created on : Oct 7, 2022, 6:50:20 PM
 * Author     : LamVo
 */

const init = (() => {
    $('select.select2').select2({
            theme: 'classic',
            dropdownAutoWidth: true,
            width: '100%'
        });
});
init(); // start select2 function for all select tags with have class name 'select2'

function validateForm() {
    var title = document.forms["submitForm"]["txtRecipeName"].value,
        categoryId = document.forms["submitForm"]["txtCategoryId"].value,
        description = document.forms["submitForm"]["txtDescription"].value;
    if (title == null || title.trim() == "") {
        alert("Title must be filled out!");
        return false;
    };
    if (categoryId == null || categoryId.trim() == "") {
        alert("You must choose category!");
        return false;
    };
    if (description == null || description.trim() == "") {
        alert("Description must be filled out!");
        return false;
    };
    if (checkIngredient() == false) {
        alert("Ingredient and Quantity must be filled out! You can also try remove that input.");
        return false;
    };
    if (checkStep() == false) {
        alert("Step must be filled out! You can also try remove that input.");
        return false;
    };    
    saveIngreString();
    saveTags();
    alert("Submit recipe successfully!");
    return false;    
}

//function addIngredient() {
//    // destroy select2 from all select tags
////        $('select.select2').select2('destroy');
////        $('select.select2')
////            .removeAttr('data-select2-id')
////            .removeAttr('aria-hidden')
////            .removeAttr('tabindex');
//    $.ajax({
//        url: "/BakeryRecipe/AddIngredientInput",
//        type: "get", //send it through get method                   
//        success: function (data) {
//            //Do Something
//            document.querySelector("#add-ingre-tbn").insertAdjacentHTML("beforebegin", data)
//        },
//        error: function (xhr) {
//            //Do Something to handle error
//        }
//    });
//    //add select2 again to all select tags
////        $('select.select2').select2({
////            theme: 'classic',
////            dropdownAutoWidth: true,
////            width: '100%'
////        }); 
//}
//
function addIngredient() {
    if (checkIngredient()) {
        createNewIngrdientInput();
    } else {
        alert("Ingredient and Quantity must be filled out!");
    }
}

var checkIngredient = () => {
    let ingreResult = document.querySelector(".ingre-div:nth-last-child(2) select"),
    quantityResult = document.querySelector(".ingre-div:nth-last-child(2) input");
    if (ingreResult.value.trim() && quantityResult.value.trim()) {
        return true;
    }
    return false;
};
function saveIngreString() {
    let resultPlace = document.querySelector(".hidden-field-area"),
    ingreResultList = document.querySelectorAll(".ingre-div select"),
    quantityResultList = document.querySelectorAll(".ingre-div input"); 
    
    resultPlace.innerHTML = '';
    var i;
    for (i = 0; i < ingreResultList.length; i++) {
        let ingreResult = ingreResultList[i],
            quantityResult = quantityResultList[i];
        let inputEle = document.createElement('input');
//     inputEle.type="hidden";
        inputEle.type="text";
        inputEle.name="txtIngredient";
        inputEle.value=`${ingreResult.value}-${quantityResult.value}`;
    
        resultPlace.appendChild(inputEle);
    }

}
function saveTags() {
    let place = document.querySelector(".hidden-tag");    
    document.querySelectorAll(".li-tag").forEach(li => {
        let inputTag = document.createElement('input');
//     inputEle.type="hidden";
        inputTag.type="text";
        inputTag.name="txtTag";
        inputTag.value=`${li.innerHTML}`;
        place.appendChild(inputTag);
    });
}
const createNewIngrdientInput = () => {
        // destroy select2 from all select tags
        $('select.select2').select2('destroy');
        $('select.select2')
            .removeAttr('data-select2-id')
            .removeAttr('aria-hidden')
            .removeAttr('tabindex');
         let elementOrigin = document.querySelector("#ingredient-sample");
//            parent = document.querySelector("#ingre-parent"),
//            after = document.querySelector("#add-ingre-tbn");
        // create clone element
        let cloneElement = elementOrigin.cloneNode(true);
        cloneElement.id = new Date().toISOString();
        cloneElement.classList.remove('no-remove');
        
        // attach the cloneElement into html
        $("#add-ingre-tbn").before(cloneElement);
        let quantityResult = document.querySelector(".ingre-div:nth-last-child(2) input");
        quantityResult.value ="";
        //add select2 again to all select tags
        $('select.select2').select2({
            theme: 'classic',
            dropdownAutoWidth: true,
            width: '100%'
        });        
};
// insert 1 step input textbox
var checkStep = () => {
    let stepResult = document.querySelector(".step-div:nth-last-child(2) input");
    if (stepResult.value.trim()) {
        return true;
    }
    return false;
};

function addStep() {
    if (checkStep()) {
        createNewStepInput();
    } else {
        alert("Step must be filled out!");
    }
}

const createNewStepInput = () => {
         let elementOrigin = document.querySelector("#step-sample");
        let cloneElement = elementOrigin.cloneNode(true);
        cloneElement.id = new Date().toISOString();
        cloneElement.classList.remove('no-remove');
        $("#add-setep-tbn").before(cloneElement);
        let stepResult = document.querySelector(".step-div:nth-last-child(2) input");
        stepResult.value ="";
};
// insert 1 img input textbox
var checkImg = () => {
    let imgResult = document.querySelector(".img-div:nth-last-child(2) input");
    if (imgResult.value.trim()) {
        return true;
    }
    return false;
};

function addImg() {
    if (checkImg()) {
        createNewImgInput();
    } else {
        alert("Image Url must be filled out first!");
    }
}

const createNewImgInput = () => {
        let elementOrigin = document.querySelector("#img-sample");
        let cloneElement = elementOrigin.cloneNode(true);
        cloneElement.id = new Date().toISOString();
        cloneElement.classList.remove('no-remove');
        $("#add-img-btn").before(cloneElement);
        let imgResult = document.querySelector(".img-div:nth-last-child(2) input");
        imgResult.value ="";
};
function removeElement(element) {
    let divId = element.parentElement.parentElement.parentElement.id,
        removedDiv = document.getElementById(divId);
    if (removedDiv.classList.contains("no-remove")) {
        alert("Can not remove this input!");
    } else {
        removedDiv.parentElement.removeChild(removedDiv);
    }    
}