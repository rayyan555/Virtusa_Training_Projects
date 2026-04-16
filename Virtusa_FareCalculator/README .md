# FareCalc – Travel Fare Optimizer

This is a simple Python program built for a ride-sharing scenario (CityCab).
It calculates the total ride fare based on distance, vehicle type, and time of travel.

The main idea of this project is to simulate how real cab apps adjust pricing during peak hours.

---
## Problem Statement

A ride-sharing startup, CityCab, needs a backend system to calculate ride fares dynamically instead of using fixed pricing. The fare should vary depending on the distance traveled, type of vehicle selected, and time of the ride.

The task is to develop a Python-based fare calculation script that determines the final ride cost using predefined rates for different vehicle categories. Additionally, the system must account for peak hours by applying a surge pricing multiplier during specific time intervals.

The program should accept user inputs such as distance (in kilometers), vehicle type, and hour of the day, then compute and display a well-formatted price receipt. It should also handle invalid inputs gracefully by informing the user when a selected service is not available.

The goal is to demonstrate the use of dictionaries, functions, conditional logic, and basic error handling in a real-world scenario.

---

##  Features

* Calculates fare based on distance (per km rate)
* Supports multiple vehicle types:

  * Economy
  * Premium
  * SUV
* Applies surge pricing during peak hours (5 PM to 8 PM)
* Handles invalid vehicle types
* Displays a clear ride receipt

---

##  How it Works

1. User enters:

   * Distance (in km)
   * Vehicle type
   * Travel hour (0–23 format)

2. The program:

   * Picks the rate from a dictionary
   * Calculates base fare
   * Checks if the time is between 17 and 20
   * Applies 1.5x surge if it is peak time

3. Finally, it prints the ride details and total fare

---

##  Example


Enter distance (in km): 10

Enter vehicle type (Economy/Premium/SUV): Premium

Enter hour of travel (0-23): 18

----- Ride Receipt -----

Distance: 10.0 km

Vehicle Type: Premium

Travel Hour: 18

Surge Pricing Applied: Yes (1.5x)

Total Fare: ₹ 270.0


---

##  Concepts Used

* Dictionary (for storing rates)
* Functions (for modular code)
* Conditional statements (if-else)
* User input handling
* Basic error handling (`if-in` check)

---

##  Notes (while entering the details)

* Time should be entered in 24-hour format
* Vehicle type is case-sensitive (must match exactly)
* Surge pricing is only applied between 17 and 20

---
##  Output Screenshots

###  Invalid Vehicle Type
![Invalid](images/Screenshot%202026-04-14%20112846.png)

---

###  Economy with Surge Pricing
![Economy Surge](images/Screenshot%202026-04-14%20112830.png)

---

###  Premium without Surge
![Premium](images/Screenshot%202026-04-14%20112819.png)

---

###  SUV Ride
![SUV](images/Screenshot%202026-04-14%20112807.png)

---

##  Author

Rayyan A

BE CSE (AIML)

Email: rayyanibnrahman903@gmail.com
---


