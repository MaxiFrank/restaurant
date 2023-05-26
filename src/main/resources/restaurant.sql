DROP TABLE IF EXISTS availability;

CREATE TABLE availability (
    id SERIAL PRIMARY KEY,
    table_id VARCHAR (50) NOT NULL,
    capacity INT NOT NULL,
    time_slot VARCHAR (50) NOT NULL
);

INSERT INTO availability (table_id, capacity, time_slot) VALUES
    ('1', '2', '11-12'),
    ('1', '2', '12-13'),
    ('1', '2', '13-14'),
    ('1', '2', '17-18'),
    ('1', '2', '18-19'),
    ('1', '2', '19-20'),
    ('1', '2', '20-21'),
    ('2', '2', '11-12'),
    ('2', '2', '12-13'),
    ('2', '2', '13-14'),
    ('2', '2', '17-18'),
    ('2', '2', '18-19'),
    ('2', '2', '19-20'),
    ('2', '2', '20-21'),
    ('3', '4', '11-12'),
    ('3', '4', '12-13'),
    ('3', '4', '13-14'),
    ('3', '4', '17-18'),
    ('3', '4', '18-19'),
    ('3', '4', '19-20'),
    ('3', '4', '20-21'),
    ('4', '4', '11-12'),
    ('4', '4', '12-13'),
    ('4', '4', '13-14'),
    ('4', '4', '17-18'),
    ('4', '4', '18-19'),
    ('4', '4', '19-20'),
    ('4', '4', '20-21'),
    ('5', '6', '11-12'),
    ('5', '6', '12-13'),
    ('5', '6', '13-14'),
    ('5', '6', '17-18'),
    ('5', '6', '18-19'),
    ('5', '6', '19-20'),
    ('5', '6', '20-21');

DROP TABLE IF EXISTS reservations;

CREATE TABLE reservations (
    id SERIAL PRIMARY KEY,
    availability_id INT NOT NULL,
    user_id INT NOT NULL,
    timestamp TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS dishes;

CREATE TABLE dishes (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
	description VARCHAR (255) NOT NULL,
	price decimal NOT NULL
);

INSERT INTO dishes (name, description, price) VALUES
('ANTIPASTO MISTO', 'Grilled Eggplant, Zucchini, Salumi, Olives, Fior di Latte Mozzarella', 24.0),
('SUPPLI NAPOLETANA' , 'Fried Arborio Risotto Balls (3), Stuffed w/ Mozzarella, Served w/ Garlic-Aioli', 14.0),
('BURATA', 'Handmade Mozzarella w/ Marinated Olives, Greens, Frontoia Sicilian EVOO', 14.0),
('VEAL BONE MARROW', 'Roasted Veal Marrow, Parsley Caper Salad, Grilled Garlic Bread', 14.0),
('MENESTRA E’ VERDURE', 'Lentil Vegetable Minestrone, Garlic Croutons, Grana Padano', 18.0),
('POLENTA DI BELLA', 'Baked Polenta, Gorgonzola, Sauteed Crimini Mushrooms', 14.0),
('BIGOLI AL SUGO D.O.P.','Thick Spaghetti, Cherry Tomatoes, Basil, San Marzano D.O.P. Sugo', 21.0),
('CARBONARA SBAGLIATA', 'Fettuccine, Pancetta, Pecorino, Egg Sugo',24.0),
('CARBONARA','Fettuccine w/ sautéed butternut squash, sliced Brussels sprouts, Pecorino Romano, tossed w/ Farm Egg Sugo & topped w/ crispy brussels sprouts & drizzled with Giusti 18 year old balsamic vinegar', 24.0),
('AMATRICIANA', 'Maccarune, Guanciale (Pork Jowl), Pecorino, San Marzano D.O.P. Tomato Sugo',24.0),
('PAPPARDELLE SPINACI CON BURRO' ,'Flat Ribbon Spinach Pasta, Pork Sausage, Tartufata, Butter Sugo. Topped with breadcrumbs', 24.0),
('GNOCCHI DI SPINACI CON GORGONZOLA','Potato-Spinach Gnocchi Gorgonzola Bechamel, Crimini Mushrooms. & Tartuffata', 21.0),
('SORRENTINA','Potato Gnocchi, Italian Sausage, Tomato Sugo, Fresh Mozzarella',24.0),
('LA PARMIGIANA','Grilled Eggplant, Fior di Latte Mozzarella, San Marzano Tomato Sugo, Sauteed Spinach',24.0),
('ZUPPA DI PESCE','Seafood Food Stew, North Coast Black Mussels, Manila Clams, Prawns, Scallops, Chopped Eggplant & Zucchini, San Marzano Tomato Sugo',42.0),
('MARINARA','San Marzano Tomato Sugo, Kalamata Olives, Anchovies & Oregano (no cheese)',18.0),
('MARGHERITA','Fior di Latte Mozzarella, San Marzano Tomato Sugo, Basil',19.0),
('TIRAMISU','Lady Fingers dipped in espresso with Kahlua and Layered w/ Marscapone',10.0),
('PANNA COTTA','Cooked cream, strawberrry compote, Balsamic Glaze.',9.0),
('AFFOGATO','Vanilla Ice Cream, Drowned with Espresso & Amaretti Crumble *crumble contains nuts',10.0);