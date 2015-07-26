$(function () {

    $('.userUpdate').on('click', function () {

        var id = $(this).data('id');
        $.ajax('/web/users/user/' + id, {
            method: 'post'
        }).done(function (data) {
            console.log(data);
            //location = data.url;
        });
        console.log(id);

    });

    $('.userDelete').on('click', function () {
        var id = $(this).data('id');
        console.log(id);
        $.ajax('/web/users/user' + id, {
            method: 'delete'
        }).done(function (data) {
            //console.log(data);
            //location = '/web/users';
        })
    });
});