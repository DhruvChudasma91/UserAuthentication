document.getElementById('loginForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    
    // Get form data
    const formData = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };

    try {
        const response = await fetch('http://localhost:8080/api/users/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });

        const data = await response.json();

        if (response.ok) {
            // Login successful
            // Store user data in localStorage for session management
            localStorage.setItem('user', JSON.stringify(data));
            
            // Redirect to welcome page
            window.location.href = 'welcome.html';
        } else {
            // Login failed
            throw new Error(data);
        }
    } catch (error) {
        // Show error message
        const errorDiv = document.createElement('div');
        errorDiv.className = 'error-message';
        errorDiv.textContent = error.message;
        
        // Remove any existing error message
        const existingError = document.querySelector('.error-message');
        if (existingError) {
            existingError.remove();
        }
        
        document.querySelector('.form-container').appendChild(errorDiv);
    }
});