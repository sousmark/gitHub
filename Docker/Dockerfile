# It sets the base image for the container.
FROM ubuntu:18.04 

# It sets the author of the Dockerfile.
MAINTAINER Mark Sous <mark.sous@esme.fr>

# It installs the Ethereum client.
RUN apt update -y
RUN apt install -y nano vim iproute2 tmux
RUN apt-get install -y software-properties-common
RUN add-apt-repository -y ppa:ethereum/ethereum
RUN apt-get update -y
RUN apt-get install -y ethereum
RUN apt-get install -y git cmake libleveldb-dev libjsoncpp-dev libboost-all-dev libgmp-dev libreadline-dev libcurl4-gnutls-dev ocl-icd-libopencl1 opencl-headers mesa-common-dev libmicrohttpd-dev build-essential

# It creates a directory named `private-ethereum` in the root directory and then changes the current directory to the newly created directory.
RUN mkdir -p /root/private-ethereum && cd $_

WORKDIR /root/private-ethereum