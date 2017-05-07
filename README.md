# Phonebook
A simple CRUD web application written in Spring MVC 4 (backend) and AngularJS (frontend)

To run this app locally, cd into the src folder and run
<code>mvn tomcat7:run</code>

Limitations/Issues:
1. No database integration yet, the phonebook is only maintained as a Java list.
2. The first time a contact is added, the page does not append it to the list below (works every other time, however).
