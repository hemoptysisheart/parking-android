$(document).ready(function() {
    var domain = window.location.origin;

    var reportFrame = $('#frame-report')[0];
    reportFrame.loadReport = function(srcBt){
        console.log('#loadReport', srcBt);
        $(this).attr('src', domain + '/' + srcBt.attr('value'));
    };
    console.log(origin, reportFrame);

    var buttonList = $('button.bt-show-report')
    console.log(buttonList);
    buttonList.on('click', function() {
        reportFrame.loadReport($(this));
    });
    reportFrame.loadReport($(buttonList[0]));
});
