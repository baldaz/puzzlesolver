#!/bin/bash

if [[ -z $1 ]]; then
    echo "Missing input file argument";
    exit;
else
    make
    java -cp bin PuzzleSolver $1 $2
fi