JC = javac
BIN = -g -classpath bin -d bin

.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

default: PuzzleSolver

Piece.class:
	$(JC) $(BIN) src/models/Piece.java
Puzzle.class: Piece.class
	$(JC) $(BIN) src/models/Puzzle.java
IOPuzzle.class:
	$(JC) $(BIN) src/models/IOFile.java src/models/IOPuzzle.java
PuzzleView.class: Puzzle.class IOPuzzle.class
	$(JC) $(BIN) src/views/IPuzzleView.java src/views/PuzzleView.java
SortAlg.class:
	$(JC) $(BIN) src/controllers/SortAlg.java
SortAlgFromTop.class: SortAlg.class
	$(JC) $(BIN) src/controllers/SortAlgFromTop.java
SortAlgFromBottom.class: SortAlg.class
	$(JC) $(BIN) src/controllers/SortAlgFromBottom.java
PuzzleController.class: Puzzle.class PuzzleView.class SortAlgFromTop.class SortAlgFromBottom.class
	$(JC) $(BIN) src/controllers/IPuzzleController.java src/controllers/PuzzleController.java
PuzzleSolver: PuzzleController.class
	$(JC) $(BIN) src/PuzzleSolver.java

clean:
	$(RM) bin/puzzlesolver/*.class $(RM) bin/*.class