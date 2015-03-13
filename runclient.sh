#!/bin/bash

if [[ -z $1  || -z $2 || -z $3 ]]; then
    echo "Missing parameters(input / output / server name).";
    exit;
else
    make Client
    java -cp bin/client PuzzleSolverClient $1 $2 $3
fi