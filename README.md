# Tesztek 
## 1. A játékos ládákat tol teszt
### Leírás
> A tesztben egy játékos és három láda vesz részt. A ládák egy sorban helyezkednek el úgy, hogy minden láda után egy üres mező található.  Ha a játékos gyengébb, mint a 3 láda együttes súrlódása, akkor a 3. lépéskor nem történik változás.
### Ellenőrzött funkcionalitás, várható hibahelyek	
> Annak ellenőrzése, hogy a láda eltoláskor valóban tovább megy a mezőre és ha nem tud tovább menni, mert előtte ládák sorakoznak vagy fal gátolja a mozgásban, akkor valóban ne mozduljon el a láda. Ellenőrizzük a több láda eltolására is az előbb említett funkciót.
### Bemenet	
	step p1 right
	step p1 right
	step p1 right
### Elvárt kimenet
w☺■.■.■.w //
w.☺■■.■.w //
w..☺■■■.w //
w..☺■■■.w //


## 2. Maradj talpon teszt

## 3. A játékos súrlódás miatt meghal

## 4. A játékos ládát tol egy célhelyre, majd letolja róla a ládát

## 5. A játékos ládát tol egy sima mezőre majd egy mézesre

## 6. A játékos minden irányba lépked

## 7. A játékos lyukba esik
