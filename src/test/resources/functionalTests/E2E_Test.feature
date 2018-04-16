#Author: shamli.singh@atos.net

#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""

Feature: Automated End-to-End Tests
Description: This feature will test end-to-end integration

Scenario: Customer place an order by purchasing an item from search
		Given user is on Home Page
		When he search for "dress"
		And choose to buy the first item
		And moves to checkout from mini cart
		And enter personal details on checkout page
		And select same delivery address
		And select payment method as "check" payment
		And place the order