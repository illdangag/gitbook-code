const apiKeyInput = document.getElementById('apiKey');
const userEmailInput = document.getElementById('email');
const userPasswordInput = document.getElementById('password');
const loginButton = document.getElementById('login');
const responseTextarea = document.getElementById('response');

loginButton.addEventListener('click', () => {
  const apiKey = apiKeyInput.value;
  const userEmail = userEmailInput.value;
  const userPassword = userPasswordInput.value;

  fetch('https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=' + apiKey, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: new URLSearchParams({
      'email': userEmail,
      'password': userPassword,
      'returnSecureToken': 'true',
    }),
  }).then((response) => response.json())
  .then((data) => responseTextarea.value = JSON.stringify(data, null, 2));
});