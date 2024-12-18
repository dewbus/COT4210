-------------------------------------------------------------
          README: How to Load and Launch Contoso Demo Image
-------------------------------------------------------------

This Docker container launches the Digital Twin Contoso demo on port 3000. The working
directory (./app) hosts a bash script (./app/start.sh) which contains 2 commands:
1.) cd src/AdtGaDemo.Web/ClientApp
2.) npx serve build -s

The application is then accessible via http://172.17.0.X:3000/ where X is determined
by the available IP addresses of the host machine (usually X = 2).

Index:
-------------------------------------------------------------
1. Loading the Docker Image (if exported as a tarball)
2. Launching a New Container from Your Docker Image
3. Accessing the Running Container
4. Stopping and Removing the Container
5. Removing the Docker Image
-------------------------------------------------------------

-------------------------------------------------------------
1. Loading the Docker Image (if exported as a tarball)
-------------------------------------------------------------

If your Docker image was exported as a tarball (e.g., corteso_demo.tar),
you can load it into Docker with the `docker load` command.

- To load the image, open the CLI in the directory of the tarball and:
  docker load -i /contoso_demo.tar

- After loading, you can verify the image is available by listing all images:
  docker images

-------------------------------------------------------------
2. Launching a New Container from Your Docker Image
-------------------------------------------------------------

Once the tarball is loaded, you can run a new container from it.

- To run the container in the background (use -d for detached mode):
  docker run -it --name <container_name> contoso_demo:0.1

  Where:
    - <container_name>: A name for your new container (optional, but useful for identification).
    - <image_name>: The name of the image you want to run (e.g., my-new-image).
    - <tag>: The tag of the image (e.g., latest). If no tag is specified, Docker assumes latest.

  This will start the container in interactive mode. To run the container in background
  mode, use the -d flag instead.

-If running the container on a server, map the port of the server to the container
  docker run -p <host-port>:<3000> -d contoso_demo:0.1

-------------------------------------------------------------
3. Accessing the Running Container
-------------------------------------------------------------

- To check if the container is running:
  docker ps

  This will show you all running containers.

- To access the container’s terminal (interactive mode), you can use docker exec:
  docker exec -it <container_name> /bin/bash


-------------------------------------------------------------
4. Stopping and Removing the Container
-------------------------------------------------------------

- To stop the running container:
  docker stop <container_name>

- To remove the container (after stopping it):
  docker rm <container_name>

-------------------------------------------------------------
5. Removing the Docker Image
-------------------------------------------------------------

If you no longer need the image, you can remove it with:

  docker rmi -f <image_name>:<tag>