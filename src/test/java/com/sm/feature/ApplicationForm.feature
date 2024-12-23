Feature: To validate user can able to fill application for smart bus

Scenario: To validate application form details
	Given user should be on login page
	And enter valid userName "admin"
	And enter valid password "Admin@123$"
	And to click on login button
	When to click on user button
	And to mouse hover at application tab
	And to mouse hover & click at smart bus tab
