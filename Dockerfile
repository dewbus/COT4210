# Use an official Alpine image as the base image
FROM node:18-alpine

# Install dependencies
RUN apk update && apk add --no-cache \
    bash \
    python3 \
    py3-pip \
    nodejs \
    npm \
    nodejs

# Set the working directory in the container
WORKDIR /app

# Copy your app files into the container
COPY ADT-SupplyChainDemo /app

# Copy the readme
COPY README.txt /app

# Copy the IP Address as txt file title
COPY 172_17_0_X_3000 /app

# Copy the startup script into the container
COPY start.sh /app/start.sh
RUN chmod +x /app/start.sh

# Expose any ports your app needs (if it's a web app, for example)
EXPOSE 3000

# Define the command to run your app (change as needed)
CMD ["/app/start.sh"]