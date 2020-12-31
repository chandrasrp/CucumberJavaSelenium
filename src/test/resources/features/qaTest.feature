
@smoke
Feature: test capture location functionality

Scenario: Capturing Stoke Office address from the Maps
Given user is on dg homepage
And hoverover on About to select location
And click on location
And maps page is opened
When click on stoke address point
Then Stoke address is captured