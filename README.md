# Mini Java/JS Fullstack App

## About

This is a small fullstack app with React on the client and Java Spring Boot on the server. The source code is in their respective directories.

Example data to be utilised by the service layer was provided.

## Running the app locally

Both front end and back end can be run independently:

### Front end from the client directory

Install deps:

```
npm i
```

Run:

```
npm run dev
```

### Back end from service directory

Install deps:

```
mvn install
```

Run:

```
mvn spring-boot:run
```

## Run app in containers

A docker compose file is available. Build both apps with `npm run build` and `mvn clean package` respectively.

Build the images and then the front end will be available on port 8080, the back end on 8443.

Run `docker-compose up --build`

