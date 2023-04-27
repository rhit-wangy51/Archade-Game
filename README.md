# Archade-Game
Project Summary:
A simple Arcade Game refactored to follow advanced object-oriented patterns to make it easier to maintain and add new features

Main Features:
1.	Applied Factory pattern, set up functions needed to implement. Make it easier to create new enemies and reuse the old ones
2.	Applied State pattern to split each level into 3 states: initialize, running and finish. To switch levels, simply run the finish function of the current level to remove all the game objects and run the initialize method of the next level to create the game objects of the next level. In each frame, run the running function of the current level.
