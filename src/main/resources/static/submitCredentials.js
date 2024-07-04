document.addEventListener('DOMContentLoaded', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const customerId = urlParams.get('id');
    
    if (!customerId) {
        alert('Customer ID not found.');
        window.location.href = 'registerCustomer.html'; // Redirect to registration page if ID not found
    } else {
        document.getElementById('customerId').value = customerId;
    }

    document.getElementById('submitCredentialsForm').addEventListener('submit', event => {
        event.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        const credentialsRequest = {
            id: customerId,
            username: username,
            password: password
        };

        fetch('/submitCredentials', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(credentialsRequest),
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to submit credentials');
            }
            return response.text();
        })
        .then(data => {
            alert(data); // Display success message
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Failed to submit credentials.');
        });
    });
});
