// if no users are logged in/ user logged in is not admin, redirects to homepage
if(!principal || principal.role !== 'ADMIN'){
    window.location.href="./index.html";
}else{
    getReimbursements();
}

async function getReimbursements(){

    let response = await fetch(`${apiUrl}/reimbursements`, {
        credentials: 'include'
});

    if(response.status == 200){
        let data = await response.json();

        populateTable(data);
    } else{
        console.log('Unable to retrieve reimbursements.')
    }
}

function populateTable(data){
    let tableBody = document.getElementById('reimbursements-tbody');

    data.forEach(reimbursement => {
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdAmount = document.createElement('td');
        let tdDateSubmitted = document.createElement('td');
        let tdDescription = document.createElement('td');
        let tdAuthor = document.createElement('td');
        let tdStatus = document.createElement('td');
        let tdType = document.createElement('td');
        let tdActions = document.createElement('td');

        tdId.innerHTML = reimbursement.id;
        tdAmount.innerHTML = reimbursement.amt;
        tdDateSubmitted.innerHTML = new Date(reimbursement.submitted).toLocaleDateString("en-US");
        tdDescription.innerHTML = reimbursement.description;
        tdAuthor.innerHTML = reimbursement.author_id.id;
        tdStatus.innerHTML = reimbursement.status;
        tdType.innerHTML = reimbursement.type;
        tdActions.innerHTML = `<button class="btn btn-primary" onclick="acceptReimbursement(${reimbursement.id})">Accept</button>`;
        
        tr.append(tdId);
        tr.append(tdAmount);
        tr.append(tdDateSubmitted);
        tr.append(tdDescription);
        tr.append(tdAuthor);
        tr.append(tdStatus);
        tr.append(tdType);
        tr.append(tdActions);

        tableBody.append(tr);
    });
}

function acceptReimbursement(reimb_id){
    let confirmResult = confirm("Are you sure you want to accept this reimbursement?");
    if(confirmResult){
        fetch(`${apiUrl}/reimbursements?reimb_id=${reimb_id}`, {
            method: 'PUT',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json; charset=utf-8',
            },
            body: JSON.stringify({
                resolved: new Date(reimbursement.resolved).toLocaleDateString("en-US"),
                resolver_id: principal.id,
            }),            
            
        })
        .then(response => {
            if(response.status == 200){
                window.location.href = "./accepted.html";
            } else{
                alert("Unable to accept reimbursement.");
            }
        })
    }
}