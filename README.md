
# Documentación de API Rest Blog v1.0.0
## Descripción del proyecto
Este proyecto radica en la creación de una API Rest que pueda crear un Blog  con "x" comentarios. Ya que la relación es que un blog puede tener muchos comentarios.
Tambien un Autor puede tener varios blog como 1 blog tiene un Autor
1 Visitante pude hacer 1 comentario, el comentrio tiene un visitante

## tecnologías
Se usa lenguaje Java pero usando el Framework Spring Boot version 3.2
El entorno de desarrollo usado es Eclipse IDE ya que viene instalado el plugin de Spring Boot.

## Recursos
El proyecto esta creado con las siguientes tecnologías, las primeras 4 se obtienen
al momento de crear el proyecto.

| Plugin                | URL                      |
|-----------------------|--------------------------|
| Spring Web            | https://start.spring.io/ |
| Spring Data JPA       | https://start.spring.io/ |
| H2 Database           | https://start.spring.io/ |
#getting-started |

## Accesos

Acceso a la base de datos H2 mediante URL:

```sh
url:http://localhost:8080/h2-console/login.jsp?jsessionid=0b9f7d257677eb75547afc44e1343bf4
user: sa
password: 
```


## Uso en Postman
http://localhost:8080/api/v1/blog :

### POST (Crear Blog)

Hay que insertar un JSON para esta petición.

``` json
{
    "titulo":"desarrollo",
    "tema":"desarrollo web",
    "contenido":"el desarrollo de web ",
    "periocidad":"semanal",
    "comentario":"si",
    "fechaPublicacion":"2020-12-12",
    "autor":[
    {        
    "nombres":"keren",
     "apellidoPaterno":"Cano",
	"apellidoMaterno":"Cuellar",
	"fecha_Nacimiento":"2020-12-10",
	"paisResidencia":"chile",
	"correoElectronico":"keren@hotmail.com"
    }
    ]
}

### POST (Crear Visitante)

http://localhost:8080/api/v1/visitante

Hay que insertar un JSON para esta petición.

``` json

{
    "nombre":"jhaneth",
    "correo":"celene@gmail.com",
    "pais_residencia":"bolivia"
}



