male(terach).
male(abraham).
male(nachor).
male(haran).
male(isaac).
male(lot).
male(dimitris).

female(sarah).
female(milcah).
female(yiscah).
mother(sarah,isaac).

person(X) :- male(X) ; female(X).

father(terach,abraham).
father(terach,nachor).
father(terach,haran).
father(abraham,isaac).
father(haran,lot).
father(haran,milcah).
father(haran,yiscah).
parent(X,Y) 			:- father(X,Y).
parent(X,Y) 			:- mother(X,Y).
ancestor(Ancestor,Descendant) 	:- parent(Ancestor,Descendant).
ancestor(Ancestor,Descendant) 	:- parent(Ancestor,Person), ancestor(Person,Descendant).

grandparent(X,Y) 		:- parent(X,Z), parent(Z,Y).

son(X,Y) 			:- parent(X,Y), male(Y).
daughter(X,Y) 			:- parent(Y,X), female(X).
child(X, Y)			:- son(X, Y) ; daughter(X, Y).

relative(X,Y)			:- ancestor(X,Y); ancestor(Y,X);son(X,Y);daughter(X,Y);son(Y,X);daughter(Y,X).

stranger(X,Y) 	:- ((male(X),female(Y));(male(Y),female(X))),not(relative(Y,X)).








