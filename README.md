# ArtistPairings
Programming Challenge for Bakpax

The input text file contains the favorite musical artists of 1000 users from Some Popular Music Review Website. Each line is a list of up to 50 artists, formatted as follows:


Radiohead,Pulp,Morrissey,Delays,Stereophonics,Blur,Suede,Sleeper,The La's,Super Furry Animals,Iggy Pop\n
Band of Horses,Smashing Pumpkins,The Velvet Underground,Radiohead,The Decemberists,Morrissey,Television\n


ArtistPairings uses this input and produces an output file containing a list of pairs of artists which appear TOGETHER in at least fifty different lists. For example, in the above sample, Radiohead and Morrissey appear together twice, but every other pair appears only once. My solution is a csv, with each row being a pair. For example:


Morrissey,Radiohead\n


Optimizations made include using functional programming with immutable data structures leveraging parallel streams to take advantage of multi-core architecture on the host machine. Since runtime was 22 seconds on a modest consumer-grade laptop with quad-core architecture at less than 3ghz per core, further optimizations are premature. Pairs such as "artist1,artist2" / "artist2,artist1" were considered distinct. 
