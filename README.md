
# Movies

A Simple service created with spring boot, to store your movies data. It covers creation, update, and deletion the movie data. 





## API Reference

#### Get Movies

```http
  GET /api/movies?page=0&size=2
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|    `page` | `Integer` | determine which page will be shown, default value = 0  |
|    `size` | `Integer` | determine size of the page, default value = 10 |

#### Get Movie by id

```http
  GET /api/movies/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of movie to fetch |

#### Create Movie

```http
  POST /api/movies
```

```json
{
 "title" : "Pengabdi Setan 9 Comunion",
 "description" : "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017, Pengabdi Setan.",
 "rating" : 10.0,
 "image" : "https://froyonion.sgp1.digitaloceanspaces.com/images/blogdetail/36ad30c5038f09e21cd8f06044c9e1782ceeef36.jpg",
 "last_playing" : "2023-08-01 10:56:31"
}

```
id, created_at, and updated_at field will be handled by the service. created_at and updated_at will be shown in GMT+7 timezone, and when firstly created the value of both field will be the same

#### Update Movie

```http
  PUT /api/movies/{ID}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of movie to be updated |

```json
{
 "title" : "Pengabdi Setan 9 Comunion",
 "description" : "dalah sebuah film horor Indonesia tahun 2022 yang disutradarai dan ditulis oleh Joko Anwar sebagai sekuel dari film tahun 2017, Pengabdi Setan.",
 "rating" : 10.0,
 "image" : "https://froyonion.sgp1.digitaloceanspaces.com/images/blogdetail/36ad30c5038f09e21cd8f06044c9e1782ceeef36.jpg",
 "last_playing" : "2023-08-01 10:56:31"
}

```
id, created_at, and updated_at field will be handled by the service. created_at and updated_at will be shown in GMT+7 timezone. After update only updated_at field that will be updated


#### Delete Movie

```http
  DELETE /api/movies/{ID}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of movie to be deleted |
