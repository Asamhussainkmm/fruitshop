# fruitshop

A street vendor sells two products King Coconut & Apple.
The price structures are as follows:
· Apple carton can hold 15 apples. A carton is priced at Rs.300/-
· King Coconut carton can hold 5 King Coconuts per carton, a carton is Rs 625/-
· If you purchase single units, the price is acquired using the carton price multiplied by an increase of 20% (1.2x)
· If you purchase 2 cartons or more, you will receive a 20% discount off the carton price

Price engine and a small calculation feature
The calculation will determine the price of two products for a store
The price engine is to optimize the price, meaning if you order 30 units and you have 20 units
per carton, the price will be set at 1 carton and 10 single units
One UI is to list the prices in a table, listing the actual prices for a product from 1-25 units
Another UI is to present a simple calculator which lets the user choose product and quantity of
either single units or cartons.
· The price is to be calculated server side
· Use a database (e.g. MySQL) to store the initial prices and products.
· The calculation logic is to be developed in Java
