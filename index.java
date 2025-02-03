// script.js
function handleCredentialResponse(response) {
    // Verify the token on your server.
    const token = response.credential;

    // Here, you would typically send the token to your backend for verification
    // and to retrieve user information.  This example just hides the Google
    // sign-in button and shows the Instagram form.

    document.getElementById('google-signin-button').style.display = 'none';
    document.getElementById('instagram-form').style.display = 'block';

    console.log("Google ID token:", token); //  Send this to your server to verify the user.
}

window.onload = function() {
  google.accounts.id.initialize({
    client_id: 'YOUR_GOOGLE_CLIENT_ID', // Replace with your Google Client ID
    callback: handleCredentialResponse
  });
  google.accounts.id.renderButton(
    document.getElementById("google-signin-button"),
    { theme: "outline", size: "large" }  // customization options
  );

    const form = document.getElementById('insta-form');
    form.addEventListener('submit', (event) => {
        event.preventDefault(); // Prevent form from actually submitting

        const username = document.getElementById('insta-username').value;
        const password = document.getElementById('insta-password').value;

        // In a real application, you would send these credentials to your server
        // for verification against Instagram's API (which is complex and often
        // requires special approval).  This is just a placeholder.
        console.log("Instagram Username:", username);
        console.log("Instagram Password:", password);

        // Placeholder for what to do after "successful" login.
        alert("Instagram login simulated. In a real app, you'd interact with Instagram's API here.");
    });
}

