# Use official Node.js image for building the Angular app
FROM node:18 AS build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the entire project
COPY . .

# Build the Angular application
RUN npm run build --prod

# Use Nginx for serving the Angular app
FROM nginx:alpine

# Copy built Angular app from previous stage
COPY --from=build /app/dist/your-angular-app-name /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
