% 2.02 (**) Determine the prime factors of a given positive integer. 

% prime_factors(N, L) :- N is the list of prime factors of N.
%    (integer,list) (+,?)

%%%%% prime factors %%%%%

prime_factors(N,L) 		:- N > 0,  prime_factors(N,L,2).

prime_factors(1,[],_) 		:- !.
prime_factors(N,[F|L],F) 	:- R is N // F, N =:= R * F, !, prime_factors(R,L,F).
prime_factors(N,L,F) 		:- next_factor(N,F,NF), prime_factors(N,L,NF).

next_factor(_,2,3) 		:- !.
next_factor(N,F,NF) 		:- F * F < N, !, NF is F + 2.
next_factor(N,_,N).




sinartisi(1,[],_) 		:- !.
sinartisi(N,[F|L],F) 	:- R is N // F, N =:= R * F, !, sinartisi(R,L,F).
sinartisi(N,L,F) 		:- next_sinartisi(N,F,NF), sinartisi(N,L,NF).

next_sinartisi(_,2,3) 		:- !.
next_sinartisi(N,F,NF) 		:- F * F < N, !, NF is F + 2.
next_sinartisi(N,_,N).


% prime_factors(10, X).


%%%%% is prime %%%%%

is_prime(2).
is_prime(3).
is_prime(P) :- integer(P), P > 3, P mod 2 =\= 0, \+ has_factor(P,3).  

has_factor(N,L) :- N mod L =:= 0.
has_factor(N,L) :- L * L < N, L2 is L + 2, has_factor(N,L2).
sinartisi(N,L)	:- N2 is N+1,is_prime(N),sinartisi(N2,L).
