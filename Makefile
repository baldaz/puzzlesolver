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
PuzzleView.class: Puzzle.class
	$(JC) $(BIN) src/views/PuzzleView.java
PuzzleController.class: Puzzle.class PuzzleView.class
	$(JC) $(BIN) src/controllers/PuzzleController.java
PuzzleSolver: PuzzleController.class
	$(JC) $(BIN) src/PuzzleSolver.java

clean:
	$(RM) bin/puzzlesolver/*.class $(RM) bin/*.class