# Eva-Store
### Project description:
It is a web application with CRUD operations represents N-tier architecture model that including *Model*, *Repository*, *Service*, *Controllers* and *DTO* layers.

*Edpoints:*
- `[POST]   /shop - creates a new product`
- `[GET]    /shop/{id} - get a product by id`
- `[GET]    /shop - get products list with pagination`
- `[GET]    /shop/product - get products list using filter by letter`
- `[PUT]    /shop/{id} - updates a product`
- `[DELETE] /shop/{id} - deletes a product`

### Description:
- For getting information fromm BD connect to localhost:8080.
- Use localhost:8080/shop/product?nameFilter=
- - write 1 **'letter'** return products that do NOT start with **'letter'**
- - write a few **'letters'** return products that do NOT contain these **'letters'**

### How to run this application:
1. Fork this project
2. Install PostgreSQL and create a schema.
3. Install [Tomcat 9.0.58 version](https://tomcat.apache.org/download-90.cgi).
4. Write your credentials in the `resources/application.properties` file.
