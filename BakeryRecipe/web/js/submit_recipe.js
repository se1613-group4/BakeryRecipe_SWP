function test() {
    createNewIngrdientInput();
    alert("You have created new ingredient input text.");
}

const createNewIngrdientInput = () => {
    let elementOrigin = document.querySelector("#ingredient-sample"),
        parent = document.querySelector("#ingredient-parent"),
        after = document.querySelector("#add-ingre-tbn"),
        selectOrigin = document.querySelector("#unit-sample");
    var id = new Date().toISOString();
    const element = elementOrigin.cloneNode(true);
    element.id = id;
    const select = selectOrigin.cloneNode(true);

    parent.insertBefore(element,after);

    
    // parent.insertBefore(select,after);

};



