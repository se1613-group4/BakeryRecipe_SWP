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

function test() {
    createNewIngrdientInput();
//    getIngredientObj(ingredientList);
    alert("You have created new ingredient input text.");
}

const createNewIngrdientInput = () => {
        // destroy select2 from all select tags
        $('select.select2').select2('destroy');
        $('select.select2')
            .removeAttr('data-select2-id')
            .removeAttr('aria-hidden')
            .removeAttr('tabindex');
         let elementOrigin = document.querySelector("#ingredient-sample"),
            parent = document.querySelector("#ingre-parent"),
            after = document.querySelector("#add-ingre-tbn");
        // create clone element
        let cloneElement = elementOrigin.cloneNode(true);
        cloneElement.id = new Date().toISOString();
        // attach the cloneElement into html
        $("#add-ingre-tbn").before(cloneElement);
        //add select2 again to all select tags
        $('select.select2').select2({
            theme: 'classic',
            dropdownAutoWidth: true,
            width: '100%'
        });        
};