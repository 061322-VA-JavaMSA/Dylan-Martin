// if no users are logged in/ user logged in is not admin, redirects to homepage 
if(!principal || principal.role !== 'ADMIN'){
    window.location.href="./index.html";
}else{
    getUsers();
}
async function getUsers(){

    let response = await fetch(`${apiUrl}/users`, {
        credentials: 'include'
    });

    if(response.status == 200){
        let data = await response.json();

        populateTable(data);
    } else{
        console.log('Unable to retrieve users.')
    }
}

function populateTable(data){
    let tableBody = document.getElementById('users-tbody');

    data.forEach(user => {
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdFirstname = document.createElement('td');
        let tdLastname = document.createElement('td');
        let tdUsername = document.createElement('td');
        let tdPasword = document.createElement('td');
        let tdEmail = document.createElement('td');
        let tdRole = document.createElement('td');

        tdId.innerHTML = user.id;
        tdFirstname.innerHTML = user.firstname;
        tdLastname.innerHTML = user.lastname;
        tdUsername.innerHTML = user.username;
        tdPassword.innerHTML = user.password;
        tdEmail.innerHTML = user.email;
        tdRole.innerHTML = user.role;

        tr.append(tdId);
        tr.append(tdFirstname);
        tr.append(tdLastname);
        tr.append(tdUsername);
        tr.append(tdPassword);
        tr.appent(tdEmail);
        tr.append(tdRole);

        tableBody.append(tr);
    });
}