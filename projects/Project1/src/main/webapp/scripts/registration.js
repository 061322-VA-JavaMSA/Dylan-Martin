if (principal) {
    window.location.href = "./index.html";
}

//If principalString is a truthy value(non null), therefore exists
if (principalString) {
    // converts the JSON string back to a JS object and assigns it to principal
    principal = JSON.parse(principalString);

    if (principal.role === 'ADMIN') {
        createNavElement('Users', nav_left, './users.html', null);
    }

    createNavElement('Reimbursements', nav_left, './reimbursement.html', null);

    createNavElement('Logout', nav_right, null, logout);
}

let registerButton = document.getElementById("submitButton");
registerButton.addEventListener("click", createUser);

// Setting up event listener for Register button
async function createUser() {
    let firstname = document.getElementById("first-name").value;
    let lastname = document.getElementById("last-name").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let email = document.getElementById("email").value;
    let role = document.getElementById("role").value;

    let response = await fetch(`${apiUrl}/users`, {
        method: "POST",
        credentials: "include",
        headers: {
            "Content-Type": "application/json; charset=utf-8",
        },
        body: JSON.stringify({
            firstname: `${firstname}`,
            lastname: `${lastname}`,
            username: `${username}`,
            password: `${password}`,
            email: `${email}`,
            role: `${role}`,
        }),
    });

    if (response.status == 201) {
        let data = await response.text();

      
        // redirect to the login page on success    
        window.location.href = "./login.html";
    } else {
        console.log("Unable to register.");
    }
}