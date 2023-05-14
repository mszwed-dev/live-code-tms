Task 0: Get familiar with the code (don’t be afraid to ask).

Task 1: Implement the `getCarts` endpoint in the `CartRestController` class, which will return a list of all carts.

- Include pagination,
- include sorting - by default, ascending by price (totalPrice),
- prove that the solution works correctly.

Task 2: Implement new `discount policy`:

- If the number of products in the cart exceeds 3, apply a 10% discount to all products in the cart,
- prove that the solution works correctly.

Additional information:

When started, the application initializes the in-memory database (h2) with data from the `data.sql` file.

Products (ID, name, brand, price):

- '089978b2-5448-497e-8139-7e1b9f832300', 'MacBook Pro', 'Apple', 7000.00
- '735a6422-f8ab-4dbc-928e-09b0fc09457a', 'AirPods Pro 2', 'Apple', 400.00
- '0a49aba9-5762-4c46-8729-5f5c1e02e83c', 'iPhone 14 Pro', 'Apple', 2100.00
- '67a5ca69-453c-45b1-bd38-a3eeb466a4a3', 'iPad Pro', 'Apple', 1100.00
- '7a3ecea4-7184-4c3c-b70e-2b1525ca9537', 'Watch Ultra', 'Apple', 1300.00

Carts (ID, total_price):

- '492e4921-95be-4240-a82a-d0c16668f8c9', 7000.00 (MacBook Pro)
- 'd2f87da7-374a-4f60-951f-79d1af56c575', 400.00 (AirPods Pro 2)
- '4ee77099-ed53-4fcf-8953-0dd25dd73f1e', 11900.00 (MacBook Pro, AirPods Pro 2, iPhone 14 Pro, iPad Pro, Watch Ultra)