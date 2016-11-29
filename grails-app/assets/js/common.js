$(function()
{
	var ticker = function()
	{
		setTimeout(function(){
		    $('.testCon div:first').animate({ marginTop: '-300px' }, 800, function ()
			{
			    $(this).detach().appendTo('div.testCon').removeAttr('style');	
			});
			ticker();
		}, 4000);
	};
	ticker();
});

$(function () {
    var ticker = function () {
        setTimeout(function () {
            $('#clientCon img:first').animate({ marginLeft: '-120px' }, 800, function () {
                $(this).detach().appendTo('div#clientCon').removeAttr('style');
            });
            ticker();
        }, 4000);
    };
    ticker();
});