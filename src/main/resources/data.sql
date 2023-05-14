INSERT INTO product (id, name, brand, price)
VALUES ('089978b2-5448-497e-8139-7e1b9f832300', 'MacBook Pro', 'Apple', 7000.00);

INSERT INTO product (id, name, brand, price)
VALUES ('735a6422-f8ab-4dbc-928e-09b0fc09457a', 'AirPods Pro 2', 'Apple', 400.00);

INSERT INTO product (id, name, brand, price)
VALUES ('0a49aba9-5762-4c46-8729-5f5c1e02e83c', 'iPhone 14 Pro', 'Apple', 2100.00);

INSERT INTO product (id, name, brand, price)
VALUES ('67a5ca69-453c-45b1-bd38-a3eeb466a4a3', 'iPad Pro', 'Apple', 1100.00);

INSERT INTO product (id, name, brand, price)
VALUES ('7a3ecea4-7184-4c3c-b70e-2b1525ca9537', 'Watch Ultra', 'Apple', 1300.00);


INSERT INTO cart (id, total_price)
VALUES ('492e4921-95be-4240-a82a-d0c16668f8c9', 7000.00);

INSERT INTO cart (id, total_price)
VALUES ('d2f87da7-374a-4f60-951f-79d1af56c575', 400.00);

INSERT INTO cart (id, total_price)
VALUES ('4ee77099-ed53-4fcf-8953-0dd25dd73f1e', 11900.00);

INSERT INTO cart_item (id, brand, name, price, product_id, cart_id)
VALUES ('c8527f3a-65e9-4c8d-a2ac-0c2e08bdc943', 'Apple', 'MacBook Pro', 7000.00, '089978b2-5448-497e-8139-7e1b9f832300',
        '492e4921-95be-4240-a82a-d0c16668f8c9');

INSERT INTO cart_item (id, brand, name, price, product_id, cart_id)
VALUES ('047b1885-c393-4c82-8b58-15e82c42d655', 'Apple', 'AirPods Pro 2', 400.00,
        '735a6422-f8ab-4dbc-928e-09b0fc09457a', 'd2f87da7-374a-4f60-951f-79d1af56c575');

INSERT INTO cart_item (id, brand, name, price, product_id, cart_id)
VALUES ('0c941cda-b329-4bb7-aef7-a1f144a395c1', 'Apple', 'iPhone 14 Pro', 2100.00,
        '0a49aba9-5762-4c46-8729-5f5c1e02e83c', '4ee77099-ed53-4fcf-8953-0dd25dd73f1e');

INSERT INTO cart_item (id, brand, name, price, product_id, cart_id)
VALUES ('5d24a4a0-f757-4fe8-b2e1-ca7512cb9fb2', 'Apple', 'Watch Ultra', 1300.00, '7a3ecea4-7184-4c3c-b70e-2b1525ca9537',
        '4ee77099-ed53-4fcf-8953-0dd25dd73f1e');

INSERT INTO cart_item (id, brand, name, price, product_id, cart_id)
VALUES ('9816f07f-7b3a-4152-a85e-7481783fad11', 'Apple', 'AirPods Pro 2', 400.00,
        '735a6422-f8ab-4dbc-928e-09b0fc09457a', '4ee77099-ed53-4fcf-8953-0dd25dd73f1e');

INSERT INTO cart_item (id, brand, name, price, product_id, cart_id)
VALUES ('c02fb00a-2ffa-4902-9ba2-dfa08cd1d82f', 'Apple', 'MacBook Pro', 7000.00, '089978b2-5448-497e-8139-7e1b9f832300',
        '4ee77099-ed53-4fcf-8953-0dd25dd73f1e');

INSERT INTO cart_item (id, brand, name, price, product_id, cart_id)
VALUES ('f9abad88-4ef0-485e-96a1-33e379f250a5', 'Apple', 'iPad Pro', 1100.00, '67a5ca69-453c-45b1-bd38-a3eeb466a4a3',
        '4ee77099-ed53-4fcf-8953-0dd25dd73f1e');

