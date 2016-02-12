Check calculated exchange rate
Narrative:
In order to know optimal exchange rate
As an User
I want to check optimal exchange rate in summary table

Scenario: Checking for maximum purchase rate
Given the user is on the Finance home page
And the user switches to eur tab
When the user looks up for 'maximum' 'purchase' rate in the summary table
Then they should see it to be the corresponding 'maximum' 'purchase' rate of the previous table 

Scenario: Checking for maximum sale rate
Given the user is on the Finance home page
And the user switches to eur tab
When the user looks up for 'maximum' 'sale' rate in the summary table
Then they should see it to be the corresponding 'maximum' 'sale' rate of the previous table 



Scenario: Checking for average purchase rate
Given the user is on the Finance home page
And the user switches to eur tab
When the user looks up for 'average' 'purchase' rate in the summary table
Then they should see it to be the corresponding 'average' 'purchase' rate of the previous table 

Scenario: Checking for average sale rate
Given the user is on the Finance home page
And the user switches to eur tab
When the user looks up for 'average' 'sale' rate in the summary table
Then they should see it to be the corresponding 'average' 'sale' rate of the previous table 



Scenario: Checking for optimal purchase rate
Given the user is on the Finance home page
And the user switches to eur tab
When the user looks up for 'optimal' 'purchase' rate in the summary table
Then they should see it to be the corresponding 'optimal' 'purchase' rate of the previous table 

Scenario: Checking for optimal sale rate
Given the user is on the Finance home page
And the user switches to eur tab
When the user looks up for 'optimal' 'sale' rate in the summary table
Then they should see it to be the corresponding 'optimal' 'sale' rate of the previous table 



Scenario: Checking for minimum purchase rate
Given the user is on the Finance home page
And the user switches to eur tab
When the user looks up for 'minimum' 'purchase' rate in the summary table
Then they should see it to be the corresponding 'minimum' 'purchase' rate of the previous table 

Scenario: Checking for minimum sale rate
Given the user is on the Finance home page
And the user switches to eur tab
When the user looks up for 'minimum' 'sale' rate in the summary table
Then they should see it to be the corresponding 'minimum' 'sale' rate of the previous table 
