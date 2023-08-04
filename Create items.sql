ALTER TABLE items
ALTER COLUMN imagePath VARCHAR(MAX);
-- Chicken Parmesan
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Chicken Parmesan', 'Breaded chicken cutlets topped with marinara sauce and melted cheese, typically served with pasta.', 5, 'https://food.fnr.sndimg.com/content/dam/images/food/fullset/2011/6/3/1/FNM_070111-Fried-Chicken-026_s4x3.jpg.rend.hgtvcom.616.462.suffix/1382539796174.jpeg', 1002, 0, 1);

-- Butter Chicken (Murgh Makhani)
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Butter Chicken (Murgh Makhani)', 'A creamy and flavorful Indian dish where chicken is cooked in a rich tomato-based sauce.', 6, 'https://images.immediate.co.uk/production/volatile/sites/30/2022/11/Whole-roast-chicken-d28d2dc.jpg', 1002, 0, 1);

-- Chicken Alfredo
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Chicken Alfredo', 'Pasta dish featuring grilled chicken and fettuccine noodles tossed in a creamy Alfredo sauce.', 5.5, 'https://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/11/2/0/DV1510H_fried-chicken-recipe-10_s4x3.jpg.rend.hgtvcom.616.462.suffix/1568222255998.jpeg', 1002, 0, 1);

-- General Tso's Chicken
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('General Tsos Chicken', 'A popular Chinese-American dish with crispy fried chicken chunks coated in a sweet and tangy sauce.', 6.5, 'https://assets.bonappetit.com/photos/5d7296eec4af4d0008ad1263/1:1/w_2560%2Cc_limit/Basically-Gojuchang-Chicken-Recipe-Wide.jpg', 1002, 0, 1);

-- Chicken Tikka Masala
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Chicken Tikka Masala', 'A classic Indian dish consisting of marinated chicken cooked in a spiced tomato-based sauce.', 6, 'https://www.foodandwine.com/thmb/jJupeS5vHMkh9TBsJkwdaG1uPY8=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Tamarind-Chicken-FT-RECIPE0522-80072d93f7bc4bc7abf1dcf5b5317b0c.jpg', 1002, 0, 1);

-- Chicken Piccata
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Chicken Piccata', 'Chicken cutlets sautéed in a lemon and caper sauce, often served with pasta or rice.', 5.5, 'https://hips.hearstapps.com/hmg-prod/images/skillet-lemony-chicken-and-artichokes-6413282bd7ca0.jpg?crop=1.00xw:0.334xh;0,0.361xh&resize=1200:*', 1002, 0, 1);

-- Chicken Teriyaki
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Chicken Teriyaki', 'Grilled or pan-fried chicken glazed with a sweet and savory teriyaki sauce.', 6, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfDPhflijnU5qh4NeAo8apySYVSaLOCYZdPw&usqp=CAU', 1002, 0, 1);

-- Chicken Curry
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Chicken Curry', 'A popular dish in various cuisines, featuring chicken cooked in a flavorful curry sauce.', 5.5, 'https://hips.hearstapps.com/hmg-prod/images/tomatobutterroastchicken-2-1669133641.jpeg', 1002, 0, 1);

-- Chicken Shawarma
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Chicken Shawarma', 'Marinated and grilled chicken, usually thinly sliced, served in a pita wrap with vegetables and sauce.', 6.5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT014E6uKC56bkiBcUmOEReUqAIRR2ZJ8Ryb030dgtRQnTKrQxz_Ebx3kOBMLjt4p86AgI&usqp=CAU', 1002, 0, 1);

-- Chicken Caesar Salad
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Chicken Caesar Salad', 'A classic salad featuring grilled chicken, romaine lettuce, croutons, Parmesan cheese, and Caesar dressing.', 5, 'https://static.toiimg.com/thumb/53222760.cms?imgsize=312586&width=800&height=800', 1002, 0, 1);
/////////////////////////////////
-- Margherita Pizza
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Margherita Pizza', 'A classic Italian pizza topped with tomato sauce, mozzarella cheese, and fresh basil leaves.', 8, 'https://www.kagomeindia.com/wp-content/uploads/Pizza-Margherita-_large.jpg', 1003, 0, 1);

-- Pepperoni Pizza
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Pepperoni Pizza', 'A classic pizza topped with tomato sauce, mozzarella cheese, and slices of pepperoni.', 9, 'https://img.dominos.vn/Veggie-mania-Pizza-Rau-Cu-Thap-Cam.jpg', 1003, 0, 1);

-- Hawaiian Pizza
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Hawaiian Pizza', 'A controversial pizza topped with tomato sauce, mozzarella cheese, ham, and pineapple.', 8.5, 'https://www.recipetineats.com/wp-content/uploads/2020/05/Pepperoni-Pizza_5-SQjpg.jpg', 1003, 0, 1);

-- BBQ Chicken Pizza
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('BBQ Chicken Pizza', 'A pizza featuring barbecue sauce as the base, topped with grilled chicken, red onions, and mozzarella cheese.', 9.5, 'https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F19%2F2014%2F07%2F10%2Fpepperoni-pizza-ck-x.jpg&q=60', 1003, 0, 1);

-- Supreme Pizza
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Supreme Pizza', 'A pizza loaded with various toppings, typically including pepperoni, sausage, bell peppers, onions, mushrooms, and olives.', 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNBADafZOzhiaOSczT-4EVrxVXscvUQ-qTaQ&usqp=CAU', 1003, 0, 1);
//////////////////////////////////////
-- Vegetable Stir-Fry
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Vegetable Stir-Fry', 'A colorful and nutritious dish consisting of various vegetables stir-fried in a flavorful sauce.', 7, 'https://images.immediate.co.uk/production/volatile/sites/30/2022/07/Mushroom-curry-2fa78aa.jpg?quality=90&resize=440,400', 1004, 0, 1);

-- Caprese Salad
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Caprese Salad', 'A refreshing salad made with fresh tomatoes, mozzarella cheese, and basil leaves, drizzled with olive oil.', 6, 'https://images.everydayhealth.com/images/what-is-a-vegan-diet-benefits-food-list-beginners-guide-alt-1440x810.jpg?sfvrsn=1d260c85_1', 1004, 0, 1);

-- Lentil Curry (Dal)
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Lentil Curry (Dal)', 'A comforting and protein-rich curry made with lentils, typically flavored with Indian spices.', 7.5, 'https://www.realsimple.com/thmb/2ixrIIlE-44L1MypGHIs2TqIQYk=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/vegetarian-recipes-1672e2b4f9104ed3b3867a2a14889ce9.jpg', 1004, 0, 1);

-- Spinach and Mushroom Quesadilla
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Spinach and Mushroom Quesadilla', 'A delicious Mexican-inspired dish where spinach, mushrooms, and cheese are sandwiched between tortillas and grilled until crispy.', 8, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxuCbwGtAHXfOnFgdCKcBBdyt6ekhZoEg9SQ&usqp=CAU', 1004, 0, 1);


INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Eggplant Parmesan', 'A hearty Italian dish featuring breaded and fried eggplant slices layered with marinara sauce and cheese, then baked until bubbly.', 8.5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs0A1U01Cya51zSaeD9fGWdLn2W029HqmcdA&usqp=CAU', 1004, 0, 1);

-- Chickpea Curry (Chana Masala)
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Chickpea Curry (Chana Masala)', 'A popular Indian curry made with chickpeas, cooked in a spiced tomato-based sauce.', 7.5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRh2ndRt6dLGdBr8vOcyjVHFiYMPXBN5pgjRA&usqp=CAU', 1004, 0, 1);

-- Vegetable Biryani
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Vegetable Biryani', 'A fragrant and flavorful rice dish made with basmati rice, mixed vegetables, and a blend of spices.', 9, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0B1fYG6vVGrqvXaImDjHlEu8nRBfsS2iDhw&usqp=CAU', 1004, 0, 1);

-- Greek Salad
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Greek Salad', 'A refreshing salad made with crisp lettuce, tomatoes, cucumbers, red onions, olives, and feta cheese, dressed with a simple vinaigrette.', 7, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDvr9uTUCMEU4v9wHfFV9rPJ81dnaZRjWcGg&usqp=CAU', 1004, 0, 1);

-- Stuffed Bell Peppers
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Stuffed Bell Peppers', 'Bell peppers stuffed with a filling of rice, vegetables, and cheese, then baked until tender.', 8, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRe2YmMqpOvVs-trBRi2qTGaWLbbp4CUbjQrQ&usqp=CAU', 1004, 0, 1);

-- Mushroom Risotto
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Mushroom Risotto', 'A creamy and comforting Italian dish where Arborio rice is cooked with mushrooms, onions, and vegetable broth.', 8.5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZ3MXuy9coMcvrgPu-0CH-NVYvtVQ_JNtCZQ&usqp=CAU', 1004, 0, 1);

-- Pad Thai
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Pad Thai', 'A classic Thai dish featuring stir-fried rice noodles with tofu, shrimp or chicken, eggs, and a tangy sauce.', 9, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqVPkk3ltS-N8NuI5LqRM7xZCC5kXWs9h0Zg&usqp=CAU', 1005, 0, 1);

-- Ramen
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Ramen', 'A Japanese noodle soup with a flavorful broth, topped with various ingredients such as sliced pork, boiled eggs, and green onions.', 9.5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrZoSqOjmLHRdo34SxPSx8exX0AZOekukn2g&usqp=CAU', 1005, 0, 1);

-- Spaghetti Aglio e Olio
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Spaghetti Aglio e Olio', 'A simple and flavorful Italian pasta dish made with spaghetti, garlic, olive oil, and chili flakes.', 8, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcduSHnfR2zAZ-8tjE__FINGW9YsRJyMHB8w&usqp=CAU', 1005, 0, 1);

-- Beef Chow Mein
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Beef Chow Mein', 'A popular Chinese dish featuring stir-fried egg noodles with tender slices of beef and mixed vegetables.', 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd-pzZTClKo3U6j4eSGz78HFSkivkec1V6vA&usqp=CAU', 1005, 0, 1);

-- Lasagna
INSERT INTO items (name, description, price, imagePath, categoryID, deleted, status)
VALUES ('Lasagna', 'A comforting Italian pasta dish made with layers of lasagna sheets, bolognese sauce, béchamel sauce, and cheese, baked to perfection.', 11, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2oySCs6V7Vg-APW4R5lE7i1cypdng2xYXLQ&usqp=CAU', 1005, 0, 1);

////////////////////////// 

insert into orders(accountID, dateBuy,address,phone, status)
values( 2,'2023-1-2', 'Thu Duc', 0912344131,2)

	INSERT INTO orders (accountID, dateBuy, address, phone, status)
SELECT 
    accountID,
    DATEADD(DAY, ABS(CHECKSUM(NEWID())) % (DATEDIFF(DAY, '2023-01-01', GETDATE())), '2023-01-01') AS randomDate,
    'Address ' + CAST(ABS(CHECKSUM(NEWID())) % 1000 AS NVARCHAR(10)) AS randomAddress,
    '09' + CAST(ABS(CHECKSUM(NEWID())) % 99999999 AS NVARCHAR(8)) AS randomPhone,
    ABS(CHECKSUM(NEWID())) % 3 + 1 AS randomStatus
FROM 
    (VALUES (28), (29), (30), (31), (32), (33), (38), (39), (40), (41), (42), (43), (44), (45), (46), (47)) AS accounts(accountID);
	INSERT INTO orders (accountID, dateBuy, address, phone, status)
SELECT 
    accountID,
    DATEADD(DAY, ABS(CHECKSUM(NEWID())) % (DATEDIFF(DAY, '2023-01-01', GETDATE())), '2023-01-01') AS randomDate,
    'Address ' + CAST(ABS(CHECKSUM(NEWID())) % 1000 AS NVARCHAR(10)) AS randomAddress,
    '09' + CAST(ABS(CHECKSUM(NEWID())) % 99999999 AS NVARCHAR(8)) AS randomPhone,
    ABS(CHECKSUM(NEWID())) % 3 + 1 AS randomStatus
FROM 
    (VALUES (28), (29), (30), (31), (32), (33), (38), (39), (40), (41), (42), (43), (44), (45), (46), (47)) AS accounts(accountID);
	INSERT INTO orders (accountID, dateBuy, address, phone, status)
SELECT 
    accountID,
    DATEADD(DAY, ABS(CHECKSUM(NEWID())) % (DATEDIFF(DAY, '2023-01-01', GETDATE())), '2023-01-01') AS randomDate,
    'Address ' + CAST(ABS(CHECKSUM(NEWID())) % 1000 AS NVARCHAR(10)) AS randomAddress,
    '09' + CAST(ABS(CHECKSUM(NEWID())) % 99999999 AS NVARCHAR(8)) AS randomPhone,
    ABS(CHECKSUM(NEWID())) % 3 + 1 AS randomStatus
FROM 
    (VALUES (28), (29), (30), (31), (32), (33), (38), (39), (40), (41), (42), (43), (44), (45), (46), (47)) AS accounts(accountID);

INSERT INTO orderProperties (orderID, itemID, quantity, price)
SELECT o.orderID, i.id, 3, i.price
FROM orders o
CROSS JOIN items i
WHERE NOT EXISTS (
    SELECT 1
    FROM orderProperties op
    WHERE op.orderID = o.orderID AND op.itemID = i.id
)
ORDER BY o.orderID, NEWID();

update orderProperties
set total = price*quantity 

UPDATE orders
SET total = (
    SELECT SUM(total)
    FROM orderProperties
    WHERE orderProperties.orderID = orders.orderID
);
