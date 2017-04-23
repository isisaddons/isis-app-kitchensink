$(document).ready(function() {
	/// here...

    ( function() {

/*

        console.log("event handlers - installing");

        $("input.form-control").focusin(function() {

            $(this).editable('toggle');
        });

        $(".editable").on("keydown", function() {



          $(this).data('editable').input.$input.on('keydown', function(e) {

            if(e.which == 9) {                                      // when tab key is pressed
              e.preventDefault();

              console.log("xxx")
              if(e.shiftKey) {                                      // shift + tab
                $(this) .blur()
                        .parents().prevAll(":has(.editable):first") // find the parent of the editable before this one in the markup
                        .find(".editable:last").editable('show');   // grab the editable and display it
              } else {                                              // just tab
                $(this) .blur()
                        .parents().nextAll(":has(.editable):first") // find the parent of the editable after this one in the markup
                        .find(".editable:first").editable('show');  // grab the editable and display it
              }
            }
          });
        });

        console.log("event handlers - installed");
*/


/*
        $("input.editable").on('focus',
            function(e) {
                console.log("focus gained" +  e);
            }
        );
*/

    } )();

});