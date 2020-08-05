
function checkProductRegistration() {

    document.getElementById("register-message").innerHTML = "";

    var prdName = document.getElementById("pname").value;
    var price = document.getElementById("price").value;
    var qty = document.getElementById("qty").value;        
    var image = document.getElementById("img").value;
    var des = document.getElementById("description").value;
    var catName = document.getElementById("sel1").value;

    if (prdName == "" || prdName == null || price == "" || price == null || qty == "" || qty == null || image == "" || image == null || des == "" || des == null || catName == "" || catName == null) {
        document.getElementById("register-message").innerHTML = "Please Enter All the Fields ...!";
        return false;
    } else if (!alphanumeric(prdName)) {
        document.getElementById("register-message").innerHTML = "Product Name is invailed...!";
        return false;
    } else if (prdName.length >= 100) {
        document.getElementById("register-message").innerHTML = "Product Name is too long...!";
        return false;
    } else if (des >= 400) {
        document.getElementById("register-message").innerHTML = "Description is too long...!";
        return false;

    } else if (!CheckDecimal(price)) {
        document.getElementById("register-message").innerHTML = "Price value is invalied...!";
        return false;

    } else {
        return true;
    }


}

function alphanumeric(input) {
    return /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(input)
}

function CheckDecimal(input) {

    console.log(/^(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(input));
    return /^(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(input);

}

function cancelProductRegistration() {

    window.location.href = "/";
}