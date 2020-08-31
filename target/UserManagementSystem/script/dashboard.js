function toggleSideToolBar() {
    let sideMenu = document.getElementById("dashboard-side-menu");
    let buttonIcon = document.getElementById("header-button-icon");
    let main = document.getElementById("dashboard-main");
    if(sideMenu.style.display === "block") {
        sideMenu.style.display = "none";
        buttonIcon.className = "ti-arrow-circle-left";
        main.style.width = "100%";
    } else {
        sideMenu.style.display = "block";
        buttonIcon.className = "ti-arrow-circle-right";
        main.style.width = "73%";
    }
}

function checkPassword() {
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    console.log(password.toString() + " " + confirmPassword);
    if(password !== confirmPassword) {
        document.getElementById("password-message").innerHTML = "Password doesn't match with confirm password";
        return false;
    } else {
        document.getElementById("password-message").innerHTML = "";
        return true;
    }
}