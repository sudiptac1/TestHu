Feature: Huddle test feature 

Scenario: I can search for key  words in website

 #Given I am a user of Huddle
 When I launch into https://uk.ask.com
 And Search for the key words "Huddle content collaboration"
 Then I should be able to see the see the key words "Collaboration Software" in the search results
