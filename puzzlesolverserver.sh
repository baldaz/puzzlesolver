#!/bin/bash

if [[ -z $1 ]]; then
    echo "Missing server name.";
    exit;
else
    make Server
    # killall rmiregistry
    cd bin/server; rmiregistry&  java PuzzleSolverServer $1
    killall rmiregistry
fi