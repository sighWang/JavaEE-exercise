$(function () {
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
        var id = $(this).data(id);
        console.log(id);

        $.ajax('/web/schedules/schedule/' + id, {
            method: 'post'
        }).done(function (data) {
            location = data;
        })
    })
});