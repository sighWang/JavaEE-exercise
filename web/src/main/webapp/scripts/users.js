$(function () {

    $('.userDelete').on('click', function () {
        var td = $(this);
        var id = $(this).data('id');
        console.log(id);
        $.ajax('/web/users/user/' + id, {
            method: 'delete'
        }).done(function (data) {
            console.log(data);
            td.closest('tr').remove();
        })
    });

    $('.addUser').on('click', function () {
        var form = $('#addUserForm');

        form.submit(function (event) {
            $.ajax({
                type: "POST",
                url: "/web/users/add",
                data: form.serialize()
            }).done(function (data) {
                console.log(data);
                window.location = "http://localhost:8080/web/users";
            });
            event.preventDefault();
        });
    });

    $('.updateUser').on('click', function () {
        var form = $('#updateUserForm');
        var id = $('#id').val();

        form.submit(function (event) {
            $.ajax(({
                type: "PUT",
                url:"/web/users/user" + id,
                data: form.serialize()
            }))
                .done(function () {
                    window.location = "http://localhost:8080/web/users";
                });
            event.preventDefault();
        });
    })
});