function getCommentContent(form) {
    var formData = new FormData(form);
    let obj = Object.fromEntries(formData.entries());
    return obj;
}
document.querySelector('#commentList').addEventListener("click", event => {
    if (event.target.classList.contains("btn-delete")) {
        let isConfirm = confirm('You will remove a comment, are you sure?');
        if (isConfirm) {
            //remove comment item on UI
            let item = event.target.parentElement;
            let commentId = event.target.previousElementSibling.innerHTML;
            while (!item.classList.contains("comment-element")) {
                item = item.parentElement;
            }
            item.remove();

            //change total number of comments
            let total = document.querySelector('.review-number');
            total.innerHTML = parseInt(total.innerHTML) - 1;
            //remove comment item on Database by Ajax
            deleteComment(commentId);
        };
    };

    if (event.target.classList.contains("btn-edit")) {
        //get comment details
        let commentDetail = event.target.previousElementSibling.innerHTML;
        let commentId = event.target.nextElementSibling.innerHTML;
        console.log('commentDetail: ', commentDetail);
        console.log('commentId: ', commentId);

        //display popup
        let form = document.querySelector(`.comment-edit-form-${commentId}`);
        form.classList.remove('d-none');

        //hide the old content
        let oldContent = document.querySelector(`#comment-detail-${commentId}`);
        oldContent.classList.add('d-none');

        form.addEventListener("submit", event => {
            event.preventDefault();
            //get form's content
            let content = getCommentContent(event.target).content;

            //update UI
            form.classList.add('d-none');
            oldContent.innerHTML = content;
            oldContent.classList.remove('d-none');
            //call Ajax
            editComment(commentId, content);
        })
    };

});

//This function to remove comments item on Database by Ajax                            
function deleteComment(commentId) {
    $.ajax({
        url: "/BakeryRecipe/DeleteCommentController",
        type: "get", //send it through get method
        data: {
            commentId: commentId
        },
        success: (response) => {
            console.log(response);
        },
        error: (xhr) => {
            console.log(xhr);
        }
    });
};

//This function to edit comments item on Database by Ajax                            
function editComment(commentId, content) {
    $.ajax({
        url: "/BakeryRecipe/EditCommentController",
        type: "get", //send it through get method
        data: {
            commentId: commentId,
            content: content
        },
        success: (response) => {
            console.log(response);
        },
        error: (xhr) => {
            console.log(xhr);
        }
    });
};