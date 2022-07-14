let submitButton = document.getElementById("submitButton");
submitButton.addEventListener("click", createReimbursement);

// Setting up event listener for Register button
async function createReimbursement() {
    let principalString = sessionStorage.getItem('principal');
    let principal = JSON.parse(principalString);
    let amt = document.getElementById("amt").value;
    let description = document.getElementById("description").value;
    let reimb_type = document.getElementById("reimb_type").value;

    let response = await fetch(`${apiUrl}/reimbursements`, {
        method: "POST",
        credentials: "include",
        headers: {
            "Content-Type": "application/json; charset=utf-8",
        },
        body: JSON.stringify({
            amt: `${amt}`,
            description: `${description}`,
            reimb_type: `${reimb_type}`,
            author_id: principal
        }),
    });

    if (response.status == 201) {
        let data = await response.text();

      
        // redirect to the login page on success    
        // window.location.href = "./login.html";
        alert("That worked!");
    } else {
        console.log("Unable to register.");
    }
}