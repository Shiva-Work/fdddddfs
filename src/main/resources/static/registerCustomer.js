document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('registerCustomerForm').addEventListener('submit', event => {
        event.preventDefault();
        const name = document.getElementById('name').value;
        const phone = document.getElementById('phone').value;
        const email = document.getElementById('email').value;

        const customer = {
            name: name,
            phone: phone,
            email: email
        };

        fetch('/reg', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(customer),
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to register customer');
            }
            return response.json();
        })
        .then(data => {
            alert('Customer registered with ID: ' + data.id);
            // Redirect to submitCredentials.html with customer ID as query parameter
            window.location.href = `submitCredentials.html?id=${data.id}`;
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Failed to register customer.');
        });
    });
});
