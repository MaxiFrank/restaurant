DROP TABLE IF EXISTS availability;

CREATE TABLE availability (
    id SERIAL PRIMARY KEY,
    table_id VARCHAR (50) NOT NULL,
    time_slot VARCHAR (50) NOT NULL,
	is_available boolean NOT NULL
);

INSERT INTO availability (table_id, time_slot, is_available) VALUES
('1', '11-12', 't'),
('1', '12-13', 't'),
('1', '13-14', 't'),
('1', '17-18', 't'),
('1', '18-19', 't'),
('1', '19-20', 't'),
('1', '20-21', 't'),
('2', '11-12', 't'),
('2', '12-13', 't'),
('2', '13-14', 't'),
('2', '17-18', 't'),
('2', '18-19', 't'),
('2', '19-20', 't'),
('2', '20-21', 't'),
('3', '11-12', 't'),
('3', '12-13', 't'),
('3', '13-14', 't'),
('3', '17-18', 't'),
('3', '18-19', 't'),
('3', '19-20', 't'),
('3', '20-21', 't'),
('4', '11-12', 't'),
('4', '12-13', 't'),
('4', '13-14', 't'),
('4', '17-18', 't'),
('4', '18-19', 't'),
('4', '19-20', 't'),
('4', '20-21', 't'),
('5', '11-12', 't'),
('5', '12-13', 't'),
('5', '13-14', 't'),
('5', '17-18', 't'),
('5', '18-19', 't'),
('5', '19-20', 't'),
('5', '20-21', 't');

DROP TABLE IF EXISTS menu;

CREATE TABLE menu (
    id SERIAL PRIMARY KEY,
    dish_name VARCHAR (50) NOT NULL,
	description VARCHAR (255) NOT NULL,
	price decimal NOT NULL
	);

INSERT INTO menu (dish_name, description, price) VALUES
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