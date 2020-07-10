# Area Contact Backend

This simple backend service simulates a Contact app.

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Deployment](#deployment)
- [Usage](#usage)
- [Built Using](#built_using)
- [TODO](./TODO.md)
- [Authors](#authors)
<!-- - [Contributing](../CONTRIBUTING.md) -->
<!-- - [Acknowledgments](#acknowledgement) -->

## 🧐 About <a name = "about"></a>

The purpose of this Spring Boot application is to try a new way to query aa Elasticsearch db throw Spring Data. 

## 🏁 Getting Started <a name = "getting_started"></a>

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See [deployment](#deployment) for notes on how to deploy the project on a live system.

### Prerequisites
For running this Spring Boot Application you need Java 8 and Docker. If you do not have these things yet here below you can find where get them.

- Docker for Windows [Link](https://docs.docker.com/docker-for-windows/install/)
- Docker for OS X [Link](https://docs.docker.com/docker-for-mac/install/)
- Docker compose [Link](https://docs.docker.com/compose/install/)
- Java for Windows [Link](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- Java for Mac [Link](https://docs.oracle.com/javase/8/docs/technotes/guides/install/mac_jdk.html)

## 🎈 Usage <a name="usage"></a>

For run this localy you can use this command:

```bash
docker-compose up --build
```

##  Rest Endpoint <a name = "endpoint"></a>

- GET /contacts (retrieve all contacts)
- POST /contacts (add a new contact)
- PUT /contacts (update a contact)
- DELETE /contacts (delete a contact)
- GET /contacts/search (search contacts by phone number full match or full text on other fields)

## 🚀 Deployment <a name = "deployment"></a>

See [TODO.md](./TODO.md) file.

## ⛏️ Built Using <a name = "built_using"></a>

- [Docker](https://www.docker.com/)
- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Elasticsearch](https://www.elastic.co/)

## ✍️ Authors <a name = "authors"></a>

- [@DonNya88](https://github.com/DonNy88) - Initial work

<!-- See also the list of [contributors](https://github.com/kylelobo/The-Documentation-Compendium/contributors) who participated in this project.

## 🎉 Acknowledgements <a name = "acknowledgement"></a>

- Hat tip to anyone whose code was used
- Inspiration
- References -->
