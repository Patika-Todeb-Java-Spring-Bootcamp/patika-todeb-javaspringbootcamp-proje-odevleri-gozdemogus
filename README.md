# patika-todeb-javaspringbootcamp-proje-odevleri-gozdemogus
patika-todeb-javaspringbootcamp-proje-odevleri-gozdemogus created by GitHub Classroom

# Second Hand App
This project is a RESTFUL adaptation of second-hand applications which are very popular in daily life.

## Project Structure
<ul>
  <li>Config</li>
  <li>Controller</li>
  <li>Exception</li>
  <li>Model
    <ul>
      <li>DTO</li>
      <li>Entity</li>
      <li>Enums</li>
      <li>Mapper</li>
    </ul>
  </li>
  <li>Repository</li>
    <li>Security</li>
      <li>Service</li>
</ul>

## Usage
The project contains Spring Security feature. In order to access the endpoints firstly you need to visit the address:

| Type | Method |
| ------ | ------ |
| POST | http://localhost:2020/login |

Then login with the following credentials: 
```
{
    "username" : "user",
    "password" : "123"
}
```
You are free to reach other endpoints with bearer token.

Some method and body examples:

| Type | Method |
| ------ | ------ |
| POST | http://localhost:2020/api/product/create |

```
{
    "brand":"DKNY",
    "title":"Chained Bag With Two Pockets",
    "details":"Bought 2 months ago, not used. Original.",
    "size": "S",
    "color": "GREY",
    "usage":"UNUSED"
}
```
| Type | Method |
| ------ | ------ |
| POST | http://localhost:2020/api/user/create |

```
{
    "username": "jamesw",
    "name":"James",
    "surname":"Walker",
    "about":"Toy collector, 36 years old",
    "email":"jamesw@gmail.com",
    "address":"Valwood Pkwy, Michigan, United States",
    "phone":"2727900888"
}
```
