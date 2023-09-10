$(document).ready(function() {
    var domain = window.location.origin;
    var reportFrame = $('#frame-report')[0];
    console.log(origin, reportFrame);

    $('button.bt-show-report').on('click', function() {
        var bt = $(this);
        var path = bt.attr('value');
        var url = domain + '/' +path;
        reportFrame.attr('src', url);
    });
});