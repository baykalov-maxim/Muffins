function addToCart(muffinId) {
    var xhr = new XMLHttpRequest();

    var json = JSON.stringify({
        id_cart: getCookie("session_id"),
        id_muffin: muffinId
    });

    xhr.open("POST", '/cart/add');
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    xhr.onreadystatechange = function () {
        location.reload();
    }
}

function removeFromCart(muffinId) {
    var xhr = new XMLHttpRequest();

    var json = JSON.stringify({
        id_cart: getCookie("session_id"),
        id_muffin: muffinId
    });

    xhr.open("POST", '/cart/remove');
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    xhr.onreadystatechange = function () {
        location.reload();
    }
}

function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}