# Use official Node.js image as the base image
FROM node:14-alpine as build

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the client application code to the working directory
COPY . .

# Build the client application
RUN npm run build

# Use Nginx as the base image for serving the client application
FROM nginx:alpine

# Copy the built client application to the Nginx web root directory
COPY --from=build /app/dist /usr/share/nginx/html

# Expose port 80
EXPOSE 8080

# Command to run Nginx
CMD ["nginx", "-g", "daemon off;"]