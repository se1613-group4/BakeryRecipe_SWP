/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const fileUploader = document.getElementById('file-uploader');
//const imageGrid = document.getElementById('image-grid');
const uploadedImageGrid = document.getElementById('uploaded-image-grid');
var files;

$(function() {
    var // Define maximum number of files.
            max_file_number = 5,
            // Define your form id or class or just tag.
            $form = $('form'),
            // Define your upload field class or id or tag.
            $file_upload = $('#file-uploader', $form),
            // Define your submit class or id or tag.
            $button = $('.btn-submit', $form);

    $file_upload.on('change', function () {
//        imageGrid.innerHTML = "";
        uploadedImageGrid.innerHTML ="";
        var number_of_images = $(this)[0].files.length;
        if (number_of_images > max_file_number) {
            alert(`You can upload maximum ${max_file_number} files.`);
            $(this).val('');
            $button.prop('disabled', 'disabled');
        } else {
            files = event.target.files;
            for (i = 0; i < files.length; i++) {
                var file = files[i];
                const reader = new FileReader();
                reader.readAsDataURL(file);
                reader.addEventListener('load', (event) => {
//                    const img = document.createElement('img');
//                    img.className = "uploaded-img";
//                    imageGrid.appendChild(img);                    
//                    img.src = event.target.result;
//                    img.alt = file.name;
                    
                    const img2 = document.createElement('img');
                    img2.className = "uploaded-img";
                    uploadedImageGrid.appendChild(img2);
                    img2.src = event.target.result;
                    img2.alt = file.name;
                });
            }
            $button.prop('disabled', false);
        }
    });
});


function submitImage() {    
    $('#over, .login').fadeOut(300 , function() {
           $('#over').remove();
       });
       
//    var formData = new FormData();
//    for (i = 0; i < files.length; i++) {
//        formData.append("files", files[i]);
//    }
//    var form = $('#upload-from');
//
//    $.ajax({
//        url: "/BakeryRecipe/UploadImageServlet",
//        type: "POST", //send it through get method
//        data : form.serialize(),
//        contentType: false,
//        processData: false,
//        success: function (response) {
//            //Do Something
//        },
//        error: function (xhr) {
//            //Do Something to handle error
//        }
//    });
}

//$('#upload-from').ajaxForm({
//        beforeSend: function() {
//        },
//        complete: function(xhr) {
//            alert("up ok");
//        }
//});        

