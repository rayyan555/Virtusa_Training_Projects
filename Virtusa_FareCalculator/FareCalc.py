rates = {
    'Economy': 10,
    'Premium': 18,
    'SUV': 25
}

def calculate_fare(km, vehicle_type, hour):
    if vehicle_type not in rates:
        return None

    base_fare = km * rates[vehicle_type]

    if 17 <= hour <= 20:
        base_fare *= 1.5

    return base_fare


km = float(input("Enter distance (in km): "))
vehicle_type = input("Enter vehicle type (Economy/Premium/SUV): ")
hour = int(input("Enter hour of travel (0-23): "))

fare = calculate_fare(km, vehicle_type, hour)

if fare is None:
    print("Service Not Available")
else:
    print("\n----- Ride Receipt -----")
    print("Distance:", km, "km")
    print("Vehicle Type:", vehicle_type)
    print("Travel Hour:", hour)

    if 17 <= hour <= 20:
        print("Surge Pricing Applied: Yes (1.5x)")
    else:
        print("Surge Pricing Applied: No")

    print("Total Fare: ₹", round(fare, 2))