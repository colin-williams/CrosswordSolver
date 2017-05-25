## A Crossword Solver written in Scala ##

As part of a programming exercise in leiu of a job interview. The problem description for the solver. Note that we are allowed to visit the same position multiple times unlike a regular crossword. Also we can move in any of 9 positions at anytime. However the program could be easily modified to accomidate different behaviors.

Given a matrix similar to the one below I want you to find all possible words. You can assume you have a dictionary of known words to validate your words against. Once you pick a starting letter you can either loop on the same letter or any letter
adjacent to it. 

```
| A G O I C|
| D E R U F|
| M P N B H|
| S T E F W|
```

A modified american - english system dictionary is provided in the resources. Single letter entries were removed because the dictionary used the single letters as index start markers. This means that "I" and "A" aren't included, but if I were to clean the dictionary this filtering wouldn't be necessevary.

Below is a set of Lists with each entry corresponding to a position on a board, the solution to the provided crossword.

```
List(ag, ago, agog, age, aged, agent, agents, agree, agreed, agreement, agreements, ad, ada, adage, add, added, adder, adept, adepts, aden, admen)
List(ga, gag, gagged, gage, gaged, gad, gadded, gaea, go, gog, goo, gorge, gorged, gore, gored, goren, gd, ge, geo, george, gee, geed, ger, gere, gem, gems, gen, gene, generic, genre, gent, gents, gene, genet, grog, greg, gregg, gregorio, greed, greer, green, greene, greened, greener, greene, gruff, grunt, grunts, grub)
List(ogden, ogre, or, ore, oreo, orr, orb, our)
List(io, ir, ire, irene, irene, if)
List(ci, cu, cur, curio, cure, cured, curer, current, currents, curb, cuff, cunt, cunts, cub, cube, cf)
List(dagger, dad, dada, dead, deader, deaden, deadened, degree, dee, deed, deeded, deer, deere, deem, deemed, deems, deep, deeper, deepen, deepened, deeps, deepen, deepened, dem, depp, den, dent, dents, deneb)
List(eager, eagerer, egg, eggo, egged, ego, ed, edge, edged, edger, edda, eden, er, erg, ergo, eric, ere, err, error, erred, em, emerge, emerged, emergent, emperor, ems, enure, enured, ennui, entente)
List(roger, rogered, roe, roeg, rio, riff, re, reagent, reagents, read, reader, reggae, regor, regent, regents, red, redder, redden, reddened, redeem, redeemed, redeemer, redeems, reed, reemerge, reemerged, reread, rerun, rep, repent, repents, reps, repent, repents, rene, renegade, renegaded, renege, reneged, renee, rennet, rent, rents, rene, renee, ru, ruff, run, rune, runner, runt, runts, rune, rub, rubric, rube, ruben, rn, rb)
List(ur, urge, urged, urgent, uric, urea, urn, unread, unneeded, unbent, uh)
List(fir, fire, fired, firemen, fur, furor, furred, fun, funner)
List(md, me, meager, mead, meade, meg, medea, merge, merged, merger, mere, men, menu, mennen, mennen, ms, mt)
List(pd, pea, peg, pegged, pedagog, pee, peed, peer, peered, peep, peeped, peeper, peeps, per, peru, pep, pepped, pepper, peppered, peps, pen, penn, penned, pent, pro, prior, preempt, preempts, preen, preened, prep, prepped, preps, prune, pruned, prune, pm, psst, pt, pep, pepped, pepper, peppered, peps, pen, penn, penned, pent, pet, pets, pete, pee, peep, peeped, peeper, peeps)
List(ne, negro, neogene, neogene, ned, need, needed, nero, nu, nun, nub, np, nb, ne, net, nets)
List(br, bread, breaded, bred, breed, breeder, bremen, brenner, brent, brr, brunt, brunet, brunets, brunette, bur, burg, burger, burr, burro, burred, burp, burped, burps, burn, burned, burner, burnt, burnett, buff, bun, bunt, bunts, be, ben, bennett, bent, bents, benet, bet, bets, bette, bee, beep, beeped, beeper, beeps, been, beebe, beet, beets, beef, beefburger)
List(hui, huff, hun, hunt, hunts, huntsmen, hub, hubbub, huh, hf, hf)
List(sm, sped, speed, speeded, speeder, speer, spent, spread, spreader, spree, spreed, spent, st, step, steppe, stepped, steppe, steps, steep, steeped, steeper, steeps)
List(tm, ts, tepee, tepee, ten, tenement, tenements, tenure, tenured, tent, tents, tenet, tenets, tet, tee, teepee, teepee, teen)
List(enure, enured, ennui, entente, ebro, ebb, eben, effete)
List(fe, fen, feb, fee, feet)
List()
```
