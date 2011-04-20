function insertAtCursor(myField, myValue)
{
	if (document.selection){
		myField.focus();
		sel = document.selection.createRange();
		sel.text = myValue;
	}
	else if (myField.selectionStart || myField.selectionStart == '0')
	{
		var startPos = myField.selectionStart;
		var endPos = myField.selectionEnd;
		restoreTop = myField.scrollTop;
		myField.value = myField.value.substring(0, startPos) +
		myValue + myField.value.substring(endPos, myField.value.length);

		myField.selectionStart = startPos + myValue.length;
		myField.selectionEnd = startPos + myValue.length;
		if (restoreTop>0)
		{
			myField.scrollTop = restoreTop;
		}
	}
	else
	{
		myField.value += myValue;
	}
}

(function($){
	var keyPressedIsTabKey = function(keyCode){
		return keyCode == 9;
	}

	var init = function(){
		$("textarea").keydown(function(event){
			if(keyPressedIsTabKey(event.keyCode)){
				insertAtCursor(this,'\t');
				event.preventDefault();
			}
		});
	};	
	$(document).ready(init);
})(jQuery)
