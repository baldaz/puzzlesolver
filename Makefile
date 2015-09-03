JC = javac
SBIN = -g -classpath bin/server -d bin/server
CBIN = -g -classpath bin/client -d bin/client

.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

default: Server Client

# server side

SPiece.class:
	$(JC) $(SBIN) src/server/models/Piece.java src/server/models/IPiece.java

SPuzzle.class: SPiece.class
	$(JC) $(SBIN) src/server/models/Puzzle.java

SharedSortStat.class:
	$(JC) $(SBIN) src/server/controllers/SharedSortStat.java

SortAlg.class: SharedSortStat.class
	$(JC) $(SBIN) src/server/controllers/SortAlg.java

SortAlgFromTop.class: SortAlg.class
	$(JC) $(SBIN) src/server/controllers/SortAlgFromTop.java

SortAlgFromBottom.class: SortAlg.class
	$(JC) $(SBIN) src/server/controllers/SortAlgFromBottom.java

SPuzzleController.class: SPuzzle.class SortAlgFromTop.class SortAlgFromBottom.class
	$(JC) $(SBIN) src/server/controllers/IPuzzleServerController.java src/server/controllers/PuzzleServerController.java

Server.class: SPuzzle.class SPuzzleController.class
	$(JC) $(SBIN) src/server/PuzzleSolverServer.java

Server: Server.class

# client side

CPiece.class:
	$(JC) $(CBIN) src/client/models/Piece.java src/client/models/IPiece.java

CPuzzle.class: CPiece.class
	$(JC) $(CBIN) src/client/models/Puzzle.java

CIOPuzzle.class:
	$(JC) $(CBIN) src/client/models/IOFile.java src/client/models/IOPuzzle.java

CPuzzleView.class: CPuzzle.class CIOPuzzle.class
	$(JC) $(CBIN) src/client/views/IPuzzleView.java src/client/views/PuzzleView.java

CPuzzleController.class: CPuzzle.class CPuzzleView.class
	$(JC) $(CBIN) src/client/controllers/IPuzzleController.java src/client/controllers/PuzzleController.java src/server/controllers/IPuzzleServerController.java

Client.class: CPuzzle.class CPuzzleController.class
	$(JC) $(CBIN) src/client/PuzzleSolverClient.java

Client: Client.class

startServer:
	rmiregistry -J-Dclasspath=$(SBIN) & java -cp $(SBIN) PuzzleSolverServer localhost &

clean:
	$(RM) bin/puzzlesolver/*.class $(RM) bin/*.class
