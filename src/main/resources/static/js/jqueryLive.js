// jQuery
function replaceItems (html) {
    // Replace the <fieldset id="items"> with a new one returned by server.
    $('#items').replaceWith($(html));
}

$('button[name="addPermiso"]').click(function (event) {
    event.preventDefault();
    var data = $('form').serialize();
    // Add parameter "addItem" to POSTed form data. Button's name and value is
    // POSTed only when clicked. Since "event.preventDefault();" prevents from
    // actual clicking the button, following line will add parameter to form
    // data.
    data += 'addPermiso';
    $.post('/order', data, replaceItems);
});

$('button[name="removePermiso"]').click(function (event) {
    event.preventDefault();
    var data = $('form').serialize();
    // Add parameter and index of item that is going to be removed.
    data += 'removePermiso=' + $(this).val();
    $.post('/order', data, replaceItems);
});