// Check if user is logged in
window.addEventListener('load', () => {
    const user = JSON.parse(localStorage.getItem('user'));
    
    if (!user) {
        // If no user data found, redirect to login
        window.location.href = 'login.html';
        return;
    }
    
    // Display welcome message
    const welcomeMessage = document.getElementById('welcomeMessage');
    welcomeMessage.textContent = `Welcome, ${user.name}!`;
});

// Logout function
function logout() {
    // Clear user data from localStorage
    localStorage.removeItem('user');
    // Redirect to login page
    window.location.href = 'login.html';
}