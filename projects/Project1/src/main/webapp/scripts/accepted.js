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
    let tableBody = document.getElementById('accepted-tbody');

    data.forEach(reimbursement => {
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdAmount = document.createElement('td');
        let tdDateSubmitted = document.createElement('td');
        let tdDateResolved = document.createElement('td');
        let tdDescription = document.createElement('td');
        let tdAuthor = document.createElement('td');
        let tdResolver = document.createElement('td');
        let tdStatus = document.createElement('td');
        let tdType = document.createElement('td');

        tdId.innerHTML = reimbursement.id;
        tdAmount.innerHTML = reimbursement.amt;
        tdDateSubmitted.innerHTML = new Date(reimbursement.submitted).toLocaleDateString("en-US");
        tdDateResolved.innerHTML = new Date(reimbursement.resolved).toLocaleDateString("en-US");
        tdDescription.innerHTML = reimbursement.description;
        tdAuthor.innerHTML = reimbursement.author_id.id;
        tdResolver.innerHTML = reimbursement.resolver_id.id;
        tdStatus.innerHTML = reimbursement.status;
        tdType.innerHTML = reimbursement.type;
        
        tr.append(tdId);
        tr.append(tdAmount);
        tr.append(tdDateSubmitted);
        tr.append(tdDateResolved);
        tr.append(tdDescription);
        tr.append(tdAuthor);
        tr.append(tdResolver);
        tr.append(tdStatus);
        tr.append(tdType);

        tableBody.append(tr);
    });
}