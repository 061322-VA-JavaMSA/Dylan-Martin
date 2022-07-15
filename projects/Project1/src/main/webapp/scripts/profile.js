async function getUserbyId(id){
    let response = await fetch(`${apiUrl}/profile/${id}`, {
        credentials: 'include'
    });

    if(response.status == 200){
        let data = await response.json();
        return data;
    } else{
        console.log('Unable to retrieve user.')
    }
}

function populateTable(data){
    let tableBody = document.getElementById('profile-tbody');

    data.forEach(user => {
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdFirstname = document.createElement('td');
        let tdLastname = document.createElement('td');
        let tdUsername = document.createElement('td');
        let tdEmail = document.createElement('td');
        let tdRole = document.createElement('td');

        tdId.innerHTML = user.id;
        tdFirstname.innerHTML = user.firstname;
        tdLastname.innerHTML = user.lastname;
        tdUsername.innerHTML = user.username;
        tdEmail.innerHTML = user.email;
        tdRole.innerHTML = user.role;

        tr.append(tdId);
        tr.append(tdFirstname);
        tr.append(tdLastname);
        tr.append(tdUsername);
        tr.append(tdEmail);
        tr.append(tdRole);

        tableBody.append(tr);
    });    
}