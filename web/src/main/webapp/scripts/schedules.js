$(function () {
    $('#scheduleUpdateForm').hide();
    $('.scheduleDelete').on('click', function () {
        var id = $(this).data('id');
        console.log(id);

        $.ajax('/web/schedules/schedule/' + id, {
            method: 'delete',
            type: 'json'
        }).done(function (data) {
            console.log(data);
        })
    });

    $('.scheduleUpdate').on('click', function () {
        var id = $(this).data('id');
        console.log(id);

        $.ajax('/web/schedules/schedule/' + id, {
            method: 'put'
        }).done(function (data) {
            location = data;
        })
    });

    $('.showUpdatePage').on('click', function () {

        var id = $(this).data('id');
        console.log(id);
        $('#scheduleUpdateForm').show();

    })
});