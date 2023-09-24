Feature: Login page test


Scenario Outline: User got successfully logged in with valid credentials 
Given Chrome browser got launched 
When user hit the URL "https://admin-demo.nopcommerce.com/login"
And user enters Email as "<email>" 
And user enters password as "<password>"
And user clicks on Login
Then page title should be "Dashboard / nopCommerce administration"
Then user click on help
Then user click on Documentation page
Then user come back to admin/parent window 
When user clicks on logout button
Then page title should be "Your store. Login"
And close the browser

Examples:
| email | password |
| admin@yourstore.com | admin |
| wrong_email@ss.com | nahi |




